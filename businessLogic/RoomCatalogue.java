package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import receptionist.ReceptionistsDB;

public class RoomCatalogue {
	ArrayList<Room> RoomList;
	
	public RoomCatalogue() {
		RoomList=new ArrayList<Room>();
		
	}

	public int findRoom(int noOfBeds, String type) {
		populateArrayList();
		for(int i=0;i<RoomList.size();i++){
			Room r=RoomList.get(i);
			if(r.getNoOfBeds()==noOfBeds && r.getRoomType().equals(type))
				return r.id;
		}
		return 0;
	}

	public void vacateRoom(int id) {
		ReceptionistsDB.getDbHandler().vacateRoom(id);
		populateArrayList();
	}

	public void addroom(String Type, int Beds, int floor, long charges) {
		Room r = new Room();
		r.setRoomType(Type);
		r.setFloor(floor);
		r.setNoOfBeds(Beds);
		r.availability = 1;
		r.setCharges(charges);
		ReceptionistsDB.getDbHandler().addRoom(r);
		populateArrayList();

	}

	public void deleteroom(int roomid) {
		ReceptionistsDB.getDbHandler().deleteroom(roomid);
		populateArrayList();

	}

	public void populateArrayList() {

		ResultSet rs = ReceptionistsDB.getDbHandler().room();
		try {
			while (rs.next()) {
				Room r = new Room();
				int ID = rs.getInt("RoomID");
				String Type = rs.getString("Type");
				int floor = rs.getInt("Floor");
				int Beds = rs.getInt("NoOfbeds");
				int avail = rs.getInt("Availability");
				long charges = rs.getLong("Charges");
				r.id = ID;
				r.setRoomType(Type);
				r.setFloor(floor);
				r.setNoOfBeds(Beds);
				r.availability = avail;
				r.setCharges(charges);
				RoomList.add(r);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// //////////Rai's/////////////
	public void endReservation(int id) {
		ReceptionistsDB.getDbHandler().endReservation(id);
		populateArrayList();
	}

	public Room getRoom(int id) {
		return ReceptionistsDB.getDbHandler().checkRoom(id);
		
	}
	// /////////End Rai's/////////
}
