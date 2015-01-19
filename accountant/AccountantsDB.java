package accountant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import receptionist.ReceptionistsDB;
import businessLogic.Expense;
import businessLogic.Salary;

public class AccountantsDB {
	private static AccountantsDB dbHandler;
	// SINGLETON DBHANDLER.
	public static AccountantsDB getDbHandler(){
		if(dbHandler==null)
			dbHandler=new AccountantsDB();
		return dbHandler;
	}
	private AccountantsDB() {
		// TODO Auto-generated constructor stub
	}
	public Expense getExpense(int Expense_id) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT * FROM Expense where ExpenseID=?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql);
			preparedStmt2.setInt(1, Expense_id);
			ResultSet rs = preparedStmt2.executeQuery();

			while (rs.next()) {
				String name = rs.getString("ExpenseName");
				String type = rs.getString("Category");
				String date = rs.getString("Date");
				date = date.substring(0, 10);
				String amount = rs.getString("Amount");
				Long am = Long.parseLong(amount);
				String details = rs.getString("Details");
				Expense expense = new Expense(name, type, date, am, details);
				return expense;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;

	}

	public void insertExpense(Expense expense) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "INSERT INTO Expense(ExpenseName,Category,Date,Amount,Details) values (?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, expense.getExpense_name());
			preparedStmt.setString(2, expense.getType());

			@SuppressWarnings("deprecation")
			java.util.Date check0 = new java.util.Date(expense.getDate());
			java.sql.Date sqlDate2 = new java.sql.Date(check0.getTime());
			preparedStmt.setDate(3, sqlDate2);
			preparedStmt.setLong(4, expense.getAmount());
			preparedStmt.setString(5, expense.getDetails());
			preparedStmt.execute();
			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	}

	@SuppressWarnings("deprecation")
	public void updateExpense(Expense expense) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update Expense set ExpenseName=? ,Category=?, Date=?, Amount=?, Details=? where ExpenseID = ?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, expense.getExpense_name());
			preparedStmt.setString(2, expense.getType());
			java.util.Date check0 = new java.util.Date(expense.getDate());
			java.sql.Date sqlDate2 = new java.sql.Date(check0.getTime());
			preparedStmt.setDate(3, sqlDate2);
			preparedStmt.setLong(4, expense.getAmount());
			preparedStmt.setString(5, expense.getDetails());
			preparedStmt.setInt(6, expense.getID());
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}

	}

	public void addSalary(Salary salary) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "INSERT INTO Salary(EmpID,Salary) values (?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, salary.getEmpID());
			preparedStmt.setLong(2, salary.getSalary());
			preparedStmt.execute();
			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}

	}

	public void updateSalary(Salary salary) {

		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update Salary set Salary=? where EmpID = ?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setLong(1, salary.getSalary());
			preparedStmt.setInt(2, salary.getEmpID());
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}

	}

	public DefaultTableModel generateExpenseReport() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Expense";
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

	public DefaultTableModel generateSalaryReport() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Salary";
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
    public DefaultTableModel viewAllIncome(){
    	try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Collection";
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
    public long getIncome(){
    	long inCome=0;
    	try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT Total from Collection";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql);
			ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
				String income = rs.getString("Total");
				long in = Long.parseLong(income);
				inCome+=in;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return inCome;
    	
    }
    public long getAllExpense(){
    	long expense=0;
    	try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT Amount from Expense";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql);
			ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
				String expen = rs.getString("Amount");
				long ex = Long.parseLong(expen);
				expense+=ex;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return expense;
    	
    }
}
