package businessLogic;
import javax.swing.table.DefaultTableModel;

import accountant.AccountantsDB;



public class Salary {
	private int empID;
	private long salary;
	String emp_name;
	public Salary(){
		
	}
	Salary(int empId,String name,long sal){
		setEmpID(empId);
		emp_name=name;
		setSalary(sal);	
	}
	public Salary(int empId,long sal){
		setEmpID(empId);
		setSalary(sal);	
	}
	
	Salary(String name,long sal){
		emp_name=name;
		setSalary(sal);	
	}

	 public void addSalary(){
		 AccountantsDB.getDbHandler().addSalary(this);
		}
	 public void updateSalary(){
		 AccountantsDB.getDbHandler().updateSalary(this);
				
		}
	 public DefaultTableModel generateSalaryReport(){
		 return AccountantsDB.getDbHandler().generateSalaryReport();
	 }
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

}
