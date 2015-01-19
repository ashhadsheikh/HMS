package businessLogic;
import java.util.Date;

import accountant.AccountantsDB;
import manager.ManagerDB;

;


public class Employee {
protected int id;
protected String name;
protected int cnic;
protected String address;
protected int contactNumber;
protected String email;
protected String dob;
protected String bank_name;
protected int acc_num;
protected Date dateOfJoining;
protected Date dateOfContactExpiry; 

public Employee(){
	 
}
public Employee(int emp_id){
	setId(emp_id);
}
public Employee(String emp_name,int emp_num, int cont_num, int acc_num){
	
	setId(emp_num);
	setName(emp_name);
	setContactNumber(cont_num);
	setAccNum(acc_num);
	
	
}
 public Employee(String emp_name, int emp_cnic, String emp_adr, int cont_num, String emp_email, String dob, String emp_bank, int acc_num){
	
	 setName(emp_name);
	 setCnic(emp_cnic);
	 setAddress(emp_adr);
	 setContactNumber(cont_num);
	 setEmail(emp_email);
	 setDob(dob);
	 setBankName(emp_bank);
	 setAccNum(acc_num);
	 
	 
}
public int getId(){
return id;
}
public String returnName(){
	return name;
}
public int getCnic(){
	return cnic;
}
public String getAddress(){
	return address;
}
public String getEmail(){
	return email;
	
}
public int getContactNumber(){
	return contactNumber;
}
public String returnDob(){
	return dob;
}
public int acc_num(){
	return acc_num;
	
}
public String bank_name(){
	return bank_name;
}
public Date returnDateOfJoining(){
	return dateOfJoining;
}
public Date returnDateOfContrctExpiry(){
	return dateOfContactExpiry;
}
void setId(int argId){
id=argId;
}
void setName(String argName){
name=argName;
}
void setCnic(int argCnic){
	cnic=argCnic;
}
void setAddress(String argaddress){
	address=argaddress;
}
void setEmail(String argemail){
	email= argemail;
}
void setContactNumber(int argConNum){
	contactNumber=argConNum;
}
void setDob(String argDob){
	dob= argDob;
}
void setBankName(String argBankName){
	bank_name= argBankName;
}
void setAccNum(int argAccNum){
	acc_num= argAccNum;
}
void setDateOfJoining(Date argDateOfJoining){
	dateOfJoining=argDateOfJoining;
}
void setDateOfContrctExpiry(Date argDateOfContactExpiry){
	 dateOfContactExpiry=argDateOfContactExpiry;
}

public void createEmployee(){
	 ManagerDB.getDBhandler().insertEmployee(this);
}
public void updateEmployee(){
	 ManagerDB.getDBhandler().updateEmployee(this);
}
public void deleteEmployee(){
	ManagerDB.getDBhandler().deleteEmployee(this);
}
public void getEmployee(int Emp_id){
	ManagerDB.getDBhandler().getEmployee(Emp_id);
}

}

