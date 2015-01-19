package businessLogic;
import javax.swing.table.DefaultTableModel;

import accountant.AccountantsDB;

public class Expense {
 private String date;
 private String type;
 private String expense_name;
 private long amount;
 private String details;
 private int ID;
 
 public Expense(){
 
 }
  public Expense(String exp_name,String typ,String dt,long amnt,String dtls){
	 setDate(dt);
	 setType(typ);
	 setExpense_name(exp_name);
	 setAmount(amnt);
	 setDetails(dtls);	 
 }
  public Expense(String exp_name,String typ,String dt,long amnt,String dtls,int id){
		 setDate(dt);
		 setType(typ);
		 setExpense_name(exp_name);
		 setAmount(amnt);
		 setDetails(dtls);
		 setID(id);
	 }
 public void makeExpense(){
	 AccountantsDB.getDbHandler().insertExpense(this);	 
 }
 
 public void updateExpense(){
	 AccountantsDB.getDbHandler().updateExpense(this);
 }

 public DefaultTableModel generateExpenseReport(){
	 return AccountantsDB.getDbHandler().generateExpenseReport();
 }

 public Expense getExpense(int expense_id){
	 return AccountantsDB.getDbHandler().getExpense(expense_id);
 }
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getExpense_name() {
	return expense_name;
}
public void setExpense_name(String expense_name) {
	this.expense_name = expense_name;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
 
}
