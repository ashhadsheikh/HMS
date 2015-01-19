package receptionist;

import javax.swing.table.DefaultTableModel;

import businessLogic.GuestCatalogue;
import businessLogic.GuestClass;
import businessLogic.Income;
import businessLogic.Payment;
import businessLogic.Reservation;
import businessLogic.ReservationCatalogue;
import businessLogic.RoomCatalogue;

public class ReceptionistController {
	Income collection;
	RoomCatalogue rC;
	GuestCatalogue guests;
	ReservationCatalogue reservations;
	private static ReceptionistController controller;
	
	private ReceptionistController(){
		collection=new Income();
		rC=new RoomCatalogue();
		guests=new GuestCatalogue();
		reservations=new ReservationCatalogue();
	}
	public static ReceptionistController getController() {
		if (controller == null)
			controller = new ReceptionistController();
		return controller;
	}


	public int findRoom(int noOfBeds, String type) {
		int r = rC.findRoom(noOfBeds, type);
		return r;
	}

	public GuestClass addGuest(String c, String n, String n2, String a) {
		
		return guests.addGuest(c, n, n2, a);
	}
	public Payment makePayment(Reservation r, int discount) {
		return collection.makePayment(r, discount);
	}

	public String guestName(int id) {
		return guests.guestName(id);
	}

	public Reservation reserveRoom(int Roomid, int GuestID, String checkInDate, int advance) {
		return reservations.reserveRoom(Roomid, GuestID, checkInDate, advance);
	}

	public Reservation checkOut(int reserveID, String checko) {
		return reservations.returnReservationAtCheckout(reserveID, checko);
	}

	

	public void vacateRoom(int id) {
		rC.vacateRoom(id);
	}

	public DefaultTableModel getRooms() {
		return ReceptionistsDB.getDbHandler().getRooms();
	}

	public DefaultTableModel getGuests() {
		return ReceptionistsDB.getDbHandler().getGuests();
	}
	public DefaultTableModel getReservations() {
		return ReceptionistsDB.getDbHandler().getReservations();
	}

	
	public void cancelBooking(int reserveID) {
		reservations.cancelBooking(reserveID);
	}

	public Payment paymentRefund(Reservation reserveID, int advance) {
		return collection.payRefund(reserveID, advance);
	}

	public void endReservation(int id) {
		rC.endReservation(id);
	}

	public void addroom(String Type,int Beds,int floor,long charges) {
		rC.addroom(Type,Beds,floor,charges);

	}
	public void deleteroom(int roomid) {
		rC.deleteroom(roomid);

	}
	public void roomService(int reservationID) {
		reservations.roomService(reservationID);

	}

	public Reservation returnReservation(int reserveID) {
		return reservations.returnReservation(reserveID);
	}

	public void returnReservationAtCancelBooking(int r1) {
		reservations.returnReservationAtCancelBooking(r1);
	}


}
