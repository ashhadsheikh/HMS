package businessLogic;

import receptionist.ReceptionistsDB;

public class Reservation {
	int reservationID;
	int guestID;
	int roomID;
	String checkIN;
	String checkOut;
	long stay;
	int advance;
///////NEW VARIABLES////////
	String date;
	String typeOfService;
	String comments;
	public Reservation() {
		
	}
	public Reservation(int reser, int g, int r, String checkin2,String checkout2, long st, int ad) {
		reservationID = reser;
		guestID = g;
		roomID = r;
		checkIN = checkin2;
		checkOut = checkout2;
		stay = st;
		advance = ad;
	}
	public int getGuestID(){
		return guestID;
	}
	public int getID(){
		return reservationID;
	}
	public int getRoomID(){
		return roomID;
	}
	public String returncheckIn(){
		return checkIN;
	}
	public String returncheckOut(){
		return checkOut;
	}
	public long returnStay(){
		return stay;
	}
	public int returnAdvance(){
		return advance;
	}
	
	void setStay() {
		String d1=checkIN.substring(checkIN.length() - 2);
		int d1i=Integer.parseInt(d1);
		String d2=checkOut.substring(checkOut.length() - 2);
		int d2i=Integer.parseInt(d2);
		stay=d2i-d1i;
	}

	public Reservation addReservation(){
		return ReceptionistsDB.getDbHandler().addReservation(roomID,guestID,checkIN,advance);
	}
	Reservation guestReport(int res){
		Reservation re=ReceptionistsDB.getDbHandler().guestReport(res);
		re.setStay();
		return re;
	}
	
/////////////////////////////////////Rai's////////////////////////////////
	
	Reservation(int re, int gu, int rI, String checkin,int ad) {
		reservationID = re;
		guestID = gu;
		roomID = rI;
		checkIN = checkin;
		advance = ad;
		}
		Reservation( int rID, int RID,  String d, String typeService, String c){
		roomID= rID;
		reservationID= RID;
		date= d;
		typeOfService= typeService;
		comments= c;

		}
		public Reservation returnReservation(int reserveID){
			return ReceptionistsDB.getDbHandler().returnReservation(reserveID);
		}




		public void returnReservationAtCancelBooking(int r){
			ReceptionistsDB.getDbHandler().returnReservationAtCancelBooking(r);
		}

		public void roomService(int r){
			ReceptionistsDB.getDbHandler().roomService(r);
		}
//////////////////////////////////////////////////////////////
}
