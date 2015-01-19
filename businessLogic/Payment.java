package businessLogic;

import receptionist.ReceptionistsDB;


public class Payment {
int paymentID;
private int rent;
private long charges;
double discount;
private double total;
private double tax;



////////////////Rai's/////////////////////////////
public Payment payRefund(Reservation reserveID,int  advance){
	ReceptionistsDB.getDbHandler().getAdvance(advance);
return this;
}
public Payment paymentRefund(Reservation reserveID, int advance) {
	Payment pay = new Payment();
	return pay.payRefund(reserveID, advance);
}

/////////////////End Rai's/////////////////////////
public long getCharges() {
	return charges;
}
public void setCharges(long charges) {
	this.charges = charges;
}
public int getRent() {
	return rent;
}
public void setRent(int rent) {
	this.rent = rent;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public double getTax() {
	return tax;
}
public void setTax(double tax) {
	this.tax = tax;
}
}
