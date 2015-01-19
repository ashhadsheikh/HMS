package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import receptionist.ReceptionistsDB;

public class ReservationCatalogue {
	ArrayList<Reservation> ReservationList;
	public ReservationCatalogue(){
		populateArrayList();
	}

	public Reservation reserveRoom(int Roomid, int GuestID, String checkInDate, int advance) {
		Reservation res = new Reservation(0, GuestID, Roomid, checkInDate, checkInDate, 0,
				advance);
		return res.addReservation();
	}

	public Reservation returnReservationAtCheckout(int res, String checko) {
		Reservation re = ReceptionistsDB.getDbHandler()
				.returnReservationAtCheckout(res, checko);
		re.setStay();
		return re;
	}
/////////////Rai's
	public void cancelBooking(int reserveID) {
		Reservation res = new Reservation();
		res.returnReservationAtCancelBooking(reserveID);

	}

	public void roomService(int reservationID) {
		Reservation res = new Reservation();
		res.roomService(reservationID);

	}
/////////////Rai's
	public Reservation returnReservation(int reserveID) {
		Reservation res = new Reservation();
		return res.returnReservation(reserveID);
	}

	public void returnReservationAtCancelBooking(int r1) {
		Reservation res = new Reservation();
		res.returnReservationAtCancelBooking(r1);
	}
	public void populateArrayList() {

		ResultSet rs = ReceptionistsDB.getDbHandler().reservation();
		try {
			while (rs.next()) {
				int id = rs.getInt("ReservationID");
				int ID = rs.getInt("GuestID");
				int Roomid= rs.getInt("RoomNo");
				String n2 = rs.getString("CheckIn");
				String c = rs.getString("CheckOut");
				int a= rs.getInt("Advance");
				Reservation res = new Reservation(id, ID, Roomid, n2, c, 0,a);
				ReservationList.add(res);
			

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
