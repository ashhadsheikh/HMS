package accountant;

import javax.swing.table.DefaultTableModel;

import businessLogic.Expense;
import businessLogic.ExpenseCatalogue;
import businessLogic.Income;
import businessLogic.Salary;

public class AccountantController {
	
	private static AccountantController  controller;
	ExpenseCatalogue AllExpenses;
	Income income;
	
	private AccountantController() {
		// TODO Auto-generated constructor stub
		AllExpenses=new ExpenseCatalogue();
		income = new Income();
	}
	//    SINGLETON CONTROLLER.
	public static AccountantController getController() {
		if (controller == null)
			controller = new AccountantController();
		return controller;
	}

	///////////////  MANAGE EXPENSE.
	public Expense getExpense(int expense_id) {
		return AllExpenses.getExpense(expense_id);
	}

	public void addExpense(String exp_name, String type, String date, long amount,
			String details) {
		AllExpenses.makeExpense(exp_name, type, date, amount, details);
	}

	public void updateExpense(String exp_name, String type, String date, long amount,
			String details, int expenseID) {
		AllExpenses.updateExpense(exp_name, type, date, amount, details,
				expenseID);
	}

	public DefaultTableModel generateExpenseReport() {
		return AllExpenses.generateExpenseReport();
	}

	///////////////  MANAGE SALARY. 
    public void addSalary(int empId, long sal) {
		
		AllExpenses.addSalary(empId, sal);
	}

	public void updateSalary(int empId, long sal) {
		AllExpenses.updateSalary(empId, sal);
	}

	public DefaultTableModel generateSalaryReport() {
		return AllExpenses.generateSalaryReport();
	}
	 public DefaultTableModel viewAllIncome(){
    	 return AllExpenses.viewAllIncome();
     }
	 public long getAllExpense(){
			return AllExpenses.getAllExpense();
			
		 }
	 
	 ///////////////////// TAX STATEMENT
	 public long getIncome(){
		return income.getIncome();
		
	 }
	 public long getTax(){
			long inCome =income.getIncome();
			long expense= AllExpenses.getAllExpense();
			long tax = (long) ((inCome-expense)*0.2);
			if(tax<0){
				return 0;
			}
			else
			return tax;
			
		 }
	 public long getProfit(){
			long inCome =income.getIncome();
			long expense= AllExpenses.getAllExpense();
			long profit = inCome-expense;
			if(profit>0)
			return profit ;
			else
				return 0;
		 }
	 public long getLoss(){
			long inCome =income.getIncome();
			long expense= AllExpenses.getAllExpense();
			long loss = inCome-expense;
			if(loss<0)
			return loss ;
			else
				return 0;
		 }

	 
}
