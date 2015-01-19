package manager;

import businessLogic.Employee;
import businessLogic.Expense;

public class ManagerController {
	private static ManagerController controller;

	private ManagerController() {
		
	}

	public static ManagerController getController() {
		if (controller == null)
			controller = new ManagerController();
		return controller;
	}
	
	public void addEmployee(String emp_name, int emp_cnic, String emp_adr, int cont_num, String emp_email, String dob, String emp_bank, int acc_num) {
		Employee employee = new Employee(emp_name, emp_cnic, emp_adr, cont_num, emp_email, dob, emp_bank, acc_num);
		employee.createEmployee();
	}
	public void updateEmployee(String emp_name, int emp_num,  int cont_num, int acc_num){
		Employee employee = new Employee(emp_name, emp_num, cont_num, acc_num);
		employee.updateEmployee();
	}
	public void deleteEmployee(String emp_name,int emp_num, int cont_num, int acc_num){
		Employee employee= new Employee(emp_name, emp_num, cont_num, acc_num);
		employee.deleteEmployee();
	}
	public void getEmployee(int emp_id){
		Employee employee= new Employee();
		employee.getEmployee(emp_id);
	}
}
