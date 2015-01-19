package administrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class AdministratorsDB {
	private static AdministratorsDB  dbHandler;
	public static AdministratorsDB  getDbHandler(){
		if(dbHandler==null)
			dbHandler=new AdministratorsDB ();
		return dbHandler;
	}
	private AdministratorsDB() {
		// TODO Auto-generated constructor stub
	}
	public boolean checkLoginInformation(UserAccount account) {
		Connection con = null;
		try {
			String user=account.getUsername();
			String pass=account.getPassword();
			String url = "jdbc:ucanaccess://./Project.accdb";
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Accounts";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("UserName");
				String add = rs.getString("Password");
				if (name.equals(user) && add.equals(pass))
					return true;
			}

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public void addAccount(UserAccount account) {
		try {
			String user=account.getUsername();
			String pass=account.getPassword();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Insert into Accounts(UserName,Password) values (?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, user);
			preparedStmt.setString(2, pass);
			preparedStmt.execute();
			con.close();
	
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	
	}
	boolean deleteAccount(String user){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Delete from Accounts where UserName=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, user);
			preparedStmt.execute();
			con.close();
			return true;
	
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return false;
	
		
	}
	public void updateAccount(UserAccount account, String new_user) {
		try {
			String user=account.getUsername();
			String pass=account.getPassword();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update Accounts set UserName=? , Password=? where UserName=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, new_user);
			preparedStmt.setString(2, pass);
			preparedStmt.setString(3, user);
			preparedStmt.execute();
	
			con.close();
	
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	
	}
	public DefaultTableModel userAccounts() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT UserName,Password FROM Accounts";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));
	
			}
			// Get row data
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			con.close();
			DefaultTableModel model = new DefaultTableModel(data, columnNames) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
					for (int row = 0; row < getRowCount(); row++) {
						Object o = getValueAt(row, column);
	
						if (o != null) {
							return o.getClass();
						}
					}
	
					return Object.class;
				}
			};
	
			return model;
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}
}
