package manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import receptionist.ReceptionistsDB;
import businessLogic.Employee;
import businessLogic.Expense;
import businessLogic.Salary;
public class ManagerDB {


	
private static ManagerDB DBhandler;
		public static ManagerDB getDBhandler(){
			if(DBhandler==null)
				DBhandler=new ManagerDB();
			return DBhandler;
		}
		private ManagerDB() {
			// TODO Auto-generated constructor stub
		}
		public Employee insertEmployee(Employee employee) {
			try {
				String url = "jdbc:ucanaccess://./Project.accdb";
				Connection con = null;
				con = DriverManager.getConnection(url);
				String sql = "INSERT INTO EmployeeTable(Name,Address,CNIC,ContactNumber,Email,DOB,BankName,AccountNumber) values (?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(sql);
				preparedStmt.setString(1,employee.returnName());
				preparedStmt.setString(2, employee.getAddress());
				preparedStmt.setInt(3, employee.getCnic());
				preparedStmt.setInt(4, employee.getContactNumber());
				preparedStmt.setString(5, employee.getEmail());
				preparedStmt.setString(6, employee.returnDob());
				preparedStmt.setString(7, employee.bank_name());
				preparedStmt.setInt(8, employee.acc_num());
				preparedStmt.execute();
				
				con.close();
			} catch (Exception sqlEx) {
				System.out.println(sqlEx);
			}
			return employee;
		}
			
			public Employee getEmployee(int Emp_id) {
				try {
					String url = "jdbc:ucanaccess://./Project.accdb";
					Connection con = null;
					con = DriverManager.getConnection(url);
					String sql = "SELECT * FROM EmployeeTable where EmployeeID=?";
					PreparedStatement preparedStmt2 = con.prepareStatement(sql);
					preparedStmt2.setInt(1, Emp_id);
					ResultSet rs = preparedStmt2.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Name");
						String address = rs.getString("Address");
						String CNIC= rs.getString("CNIC");
						int cnic = Integer.parseInt(CNIC);
						String con_Num= rs.getString("ContactNumber");
						int contactNumber= Integer.parseInt(con_Num);
						String email = rs.getString("Email");
						String dob= rs.getString("DOB");
						String bankName = rs.getString("BankName");
						String acc_Num= rs.getString("AccountNumber");
						int accountNum =Integer.parseInt(acc_Num);
						Employee employee= new Employee(name,cnic,address, contactNumber, email, dob, bankName, accountNum);
						return employee;
					}
					con.close();

				} catch (Exception sqlEx) {
					System.out.println(sqlEx);
				}
				return null;

			} 

		
		
		public void updateEmployee(Employee employee) {
			try {
				String url = "jdbc:ucanaccess://./Project.accdb";
				Connection con = null;
				con = DriverManager.getConnection(url);
				String sql = "update EmployeeTable set Name=? ,ContactNumber=?, AccountNumber=? where EmployeeID = ?";
				PreparedStatement preparedStmt = con.prepareStatement(sql);
				preparedStmt.setString(1, employee.returnName());
				
				preparedStmt.setInt(2, employee.getContactNumber());
				preparedStmt.setInt(3, employee.acc_num());
				preparedStmt.setInt(4, employee.getId());
				
				preparedStmt.execute();

				con.close();

			} catch (Exception sqlEx) {
				System.out.println(sqlEx);
			}

		}
		public void deleteEmployee(Employee employee){
			try{
				String url = "jdbc:ucanaccess://./Project.accdb";
				Connection con = null;
				con = DriverManager.getConnection(url);
				String sql = "Delete from EmployeeTable where EmployeeID=?";
				PreparedStatement preparedStmt = con.prepareStatement(sql);
				preparedStmt.setInt(1, employee.getId());
				preparedStmt.execute();

			} catch (Exception sqlEx) {
				System.out.println(sqlEx);
			}
		}
	}




