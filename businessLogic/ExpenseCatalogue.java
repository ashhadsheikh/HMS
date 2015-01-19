package businessLogic;

import javax.swing.table.DefaultTableModel;

import accountant.AccountantsDB;

public class ExpenseCatalogue {
Expense expense;
Salary salary;

//////////////////////////// FUNCTIONS OF EXPENSE ///////////////////////////////

//ADD EXPENSE
	 public void makeExpense(String exp_name, String type, String date, long amount,
				String details){
		 Expense expense = new Expense(exp_name, type, date, amount, details);
		 AccountantsDB.getDbHandler().insertExpense(expense);	 
	 }
//   UPDATE EXPENSE	 
	 public void updateExpense(String exp_name, String type, String date, long amount,
				String details, int expenseID){
		 Expense expense = new Expense(exp_name, type, date, amount, details,
					expenseID);
		 AccountantsDB.getDbHandler().updateExpense(expense);
	 }
//   VIEW EXPENSE
	 public DefaultTableModel generateExpenseReport(){
		 return AccountantsDB.getDbHandler().generateExpenseReport();
	 }
//   GET EXPENSE	 
	 public Expense getExpense(int expense_id){
		 return AccountantsDB.getDbHandler().getExpense(expense_id);
	 }
////////////////////////////FUNCTIONS OF SALARY ///////////////////////////////	
//   ADD SALARY
	 public void addSalary(int empId, long sal){
		 Salary salary = new Salary(empId, sal);
		 AccountantsDB.getDbHandler().addSalary(salary);
		}
//   UPDATE SALARY
	 public void updateSalary(int empId, long sal){
		 Salary salary = new Salary(empId, sal);
		 AccountantsDB.getDbHandler().updateSalary(salary);
				
		}
//   VIEW SALARY	
     public DefaultTableModel generateSalaryReport(){
		 return AccountantsDB.getDbHandler().generateSalaryReport();
	 }
// GET ALL EXPENSE
     public long getAllExpense(){
		 return AccountantsDB.getDbHandler().getAllExpense();
	 }
////////////////////////// VIEW ALL INCOME ////////////////////////////////
     public DefaultTableModel viewAllIncome(){
    	 return AccountantsDB.getDbHandler().viewAllIncome();
     }   
     
}
