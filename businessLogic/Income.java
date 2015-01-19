package businessLogic;

import accountant.AccountantsDB;
import receptionist.ReceptionistsDB;

public class Income {
	Payment collection;
	
	public Income(){
		collection=new Payment();;
	}
	public Payment makePayment(Reservation r,int dis){
		int re=ReceptionistsDB.getDbHandler().returnRoomrent(r.getRoomID());
		collection.setRent(re);
		collection.setCharges(collection.getRent()*r.returnStay());
		collection.discount=dis;
		collection.setTax((collection.getCharges()-collection.discount)*0.20);
		collection.setTotal((collection.getCharges()-collection.discount)+collection.getTax()-collection.discount);
		ReceptionistsDB.getDbHandler().makePayment(collection.getCharges(),collection.discount,collection.getTotal(),collection.getTax());
		
		return collection;
	}
	public Payment returnPayment(Reservation r){
		int re=ReceptionistsDB.getDbHandler().returnRoomrent(r.getRoomID());
		collection.setRent(re);
		collection.setCharges(collection.getRent()*r.returnStay());
		collection.discount=0;
		collection.setTax((collection.getCharges()-collection.discount)*0.20);
		collection.setTotal((collection.getCharges()-collection.discount)+collection.getTax()-collection.discount);
		return collection;
	}
	public Payment payRefund(Reservation reserveID, int advance) {
		return collection.payRefund(reserveID, advance);
	}
	public long getIncome(){
		 return AccountantsDB.getDbHandler().getIncome();
	 }
}
