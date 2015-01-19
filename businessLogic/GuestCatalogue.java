package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import receptionist.ReceptionistsDB;

public class GuestCatalogue {
	ArrayList<GuestClass> GuestList;
	
	public GuestCatalogue(){
		GuestList=new ArrayList<GuestClass>();
	}
	public GuestClass addGuest(String c, String n, String n2, String a) {
		
		GuestClass guest = new GuestClass();
		guest.setId(0);
		guest.setCnic(c);
		guest.setName(n);
		guest.setNationality(n2);
		guest.setAddress(a);
		GuestClass g= ReceptionistsDB.getDbHandler().addGuest(guest);
		populateArrayList();
		return g;
	}
	public String guestName(int id) {
		//populateArrayList();
		//GuestClass guest = new GuestClass();
		//return guest.returnName(id);
		populateArrayList();
		for(int i=0;i<GuestList.size();i++){
			GuestClass g=GuestList.get(i);
			if(g.getID()==id)
				return g.getName();
		}
		//ReceptionistsDB.getDbHandler().getGuest(id)
		return null;
	}
	public GuestClass getGuest(int id){
		populateArrayList();
		for(int i=0;i<GuestList.size();i++){
			GuestClass g=GuestList.get(i);
			if(g.getID()==id)
				return g;
		}
		//ReceptionistsDB.getDbHandler().getGuest(id)
		return null;
	}
	public void populateArrayList() {

		ResultSet rs = ReceptionistsDB.getDbHandler().guest();
		try {
			while (rs.next()) {
				int ID = rs.getInt("GuestID");
				String n = rs.getString("Name");
				String n2 = rs.getString("Nationality");
				String c = rs.getString("cnic");
				String a = rs.getString("Address");
				GuestClass guest = new GuestClass();
				guest.setId(ID);
				guest.setCnic(c);
				guest.setName(n);
				guest.setNationality(n2);
				guest.setAddress(a);
				GuestList.add(guest);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
