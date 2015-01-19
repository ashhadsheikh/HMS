package receptionist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import businessLogic.GuestClass;
import businessLogic.Reservation;
import businessLogic.Room;

public class ReceptionistsDB {
	
	private static ReceptionistsDB dbHandler;
	public static ReceptionistsDB getDbHandler(){
		if(dbHandler==null)
			dbHandler=new ReceptionistsDB();
		return dbHandler;
	}
	private ReceptionistsDB() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * Receptionist
	 * 
	 * 
	 *  */

	public void deleteroom(int roomid){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Delete from RoomTable where RoomID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, roomid);
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		
	}
	public ResultSet  room(){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "select * from RoomTable";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			
			 ResultSet  rs=preparedStmt.executeQuery();
			 con.close();
			 return rs;
			

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
		
	}
	public ResultSet  guest(){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "select * from GuestTable";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			
			 ResultSet  rs=preparedStmt.executeQuery();
			 con.close();
			 return rs;
			

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
		
	}
	public ResultSet  reservation(){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "select * from Reservation";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			
			 ResultSet  rs=preparedStmt.executeQuery();
			 con.close();
			 return rs;
			

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
		
	}
	public void addRoom(Room r){
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Insert into RoomTable values (?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, r.getRoomType());
			preparedStmt.setInt(2, r.getFloor());
			preparedStmt.setInt(3, r.getNoOfBeds());
			preparedStmt.setInt(4, 1);
			preparedStmt.setLong(5, r.getCharges());
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		
	}
	public DefaultTableModel getRooms() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT RoomID,Type,Floor,NoOfbeds,Charges,Availability FROM RoomTable";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));

			}
			// Get row data
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i < columns; i++) {
					row.addElement(rs.getObject(i));
				}
				if(rs.getObject(columns).toString().equals("0")){
					row.addElement("Not Available");
				}
				else{
					row.addElement("Available");
				}
				data.addElement(row);
			}
			con.close();
			DefaultTableModel model = new DefaultTableModel(data, columnNames) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
					for (int row = 0; row < getRowCount(); row++) {
						Object o = getValueAt(row, column);

						if (o != null) {
							return o.getClass();
						}
					}

					return Object.class;
				}
			};

			return model;
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}

	public DefaultTableModel getGuests() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT GuestID,Name,Address,cnic,Nationality FROM GuestTable";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));

			}
			// Get row data
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			con.close();
			DefaultTableModel model = new DefaultTableModel(data, columnNames) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
					for (int row = 0; row < getRowCount(); row++) {
						Object o = getValueAt(row, column);

						if (o != null) {
							return o.getClass();
						}
					}

					return Object.class;
				}
			};

			return model;
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}
	public DefaultTableModel getReservations() {
		try {
			Vector<Object> columnNames = new Vector<Object>();
			Vector<Object> data = new Vector<Object>();
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "select r.ReservationID,r.RoomNo,g.GuestID,g.Name,g.cnic,r.CheckIn,r.CheckOut from Reservation r,GuestTable g where r.GuestID=g.GuestID and r.CheckOut IS NULL";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));

			}
			// Get row data
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			con.close();
			DefaultTableModel model = new DefaultTableModel(data, columnNames) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
					for (int row = 0; row < getRowCount(); row++) {
						Object o = getValueAt(row, column);

						if (o != null) {
							return o.getClass();
						}
					}

					return Object.class;
				}
			};

			return model;
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}

	public void vacateRoom(int id) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update RoomTable set Availability=?  where RoomID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, 1);
			preparedStmt.setInt(2, id);
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}

	}

	public ArrayList<String> getType() {
		ArrayList<String> type = new ArrayList<String>();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT Type FROM RoomTable where Availability=1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("Type");
				type.add(name);
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return type;
	}

	public ArrayList<String> getBeds() {
		ArrayList<String> type = new ArrayList<String>();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT NoOfbeds FROM RoomTable where Availability=1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("NoOfbeds");
				type.add(name);
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return type;
	}

	public ArrayList<String> getIDs() {
		ArrayList<String> type = new ArrayList<String>();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT RoomID FROM RoomTable where Availability=1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("RoomID");
				type.add(name);
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return type;
	}

	public String returnGuestName(int id) {
		String s = "N/A";
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT Name from GuestTable where GuestID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				s = rs.getString("Name");
				return s;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return s;
	}

	public void makePayment(long c, double d, double tot, double ta) {

		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Insert into Collection(Charges,Discount,Total,Tax) values (?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setLong(1, c);
			preparedStmt.setDouble(2, d);
			preparedStmt.setDouble(3, tot);
			preparedStmt.setDouble(4, ta);
			preparedStmt.execute();

			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}

	}

	public int returnRoomrent(int id) {
		int s = 0;
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT Charges from RoomTable where RoomID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String t = rs.getString("Charges");
				s = Integer.parseInt(t);
				return s;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return s;
	}

	public Reservation addReservation(int Roomid, int GuestID, String checkInDate,
			int advance) {

		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Insert into Reservation(RoomNo,GuestID,CheckIn,Advance) values (?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, Roomid);
			preparedStmt.setInt(2, GuestID);
			@SuppressWarnings("deprecation")
			java.util.Date check = new java.util.Date(checkInDate);
			java.sql.Date sqlDate = new java.sql.Date(check.getTime());
			preparedStmt.setDate(3, sqlDate);
			preparedStmt.setInt(4, advance);
			preparedStmt.execute();

			String sql2 = "update RoomTable set Availability=? where RoomID= ?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setInt(1, 0);
			preparedStmt2.setInt(2, Roomid);
			preparedStmt2.execute();

			String sql4 = "Select * from Reservation where RoomNo=? and GuestID=? ";
			PreparedStatement preparedStmt3 = con.prepareStatement(sql4);
			preparedStmt3.setInt(1, Roomid);
			preparedStmt3.setInt(2, GuestID);
			ResultSet rs4 = preparedStmt3.executeQuery();
			while (rs4.next()) {
				String id = rs4.getString("ReservationID");
				int ID = Integer.parseInt(id);
				Reservation res= new Reservation(ID, GuestID, Roomid, checkInDate, checkInDate, 0,
						advance);
				return res;
			}
			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}

	public GuestClass addGuest(GuestClass g) {
		String name = g.getName();
		String address = g.getAddress();
		String passport = g.getcnic();
		String nationality = g.getNationality();

		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Insert into GuestTable(Name,Address,cnic,Nationality,Visitnumber) values (?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, address);
			preparedStmt.setString(3, passport);
			preparedStmt.setString(4, nationality);
			preparedStmt.setInt(5, 1);
			preparedStmt.execute();

			String sql2 = "select * from GuestTable where Name=? and cnic=?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setString(1, name);
			preparedStmt2.setString(2, passport);
			ResultSet rs4 = preparedStmt2.executeQuery();
			while (rs4.next()) {
				GuestClass guest = new GuestClass();
				String id = rs4.getString("GuestID");
				int ID = Integer.parseInt(id);
				guest.setId(ID);
				guest.setCnic(passport);
				guest.setName(name);
				guest.setNationality(nationality);
				guest.setAddress(address);
				
				return guest;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}

	public int findRoom(int noOfBeds, String type) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT * FROM RoomTable where NoOfbeds=? and Type= ? and Availability=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);

			preparedStmt.setInt(1, noOfBeds);
			preparedStmt.setString(2, type);
			preparedStmt.setInt(3, 1);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("RoomID");
				int ID = Integer.parseInt(id);
				return ID;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return 0;
	}

	public Room checkRoom(int id) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT * FROM RoomTable where RoomID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);

			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {

				String idn = rs.getString("RoomID");
				int IDn = Integer.parseInt(idn);
				String type = rs.getString("Type");
				String f = rs.getString("Floor");
				int floor = Integer.parseInt(f);
				String b = rs.getString("NoOfbeds");
				int beds = Integer.parseInt(b);
				//String a = rs.getString("Availability");
				int avail = Integer.parseInt(b);
				Room r = new Room(IDn, type, floor, beds, avail);
				return r;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return null;
	}

	public GuestClass getGuest(int id) {
		GuestClass g = new GuestClass();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT * FROM GuestTable where GuestID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				//
				String d = rs.getString("GuestID");
				int gID = Integer.parseInt(d);
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String cnic = rs.getString("cnic");
				String nat = rs.getString("Nationality");
				// String v = rs.getString("Visitnumber");
				// int vno = Integer.parseInt(v);
				GuestClass k = new GuestClass(gID, cnic, name, nat, address);
				return k;
			}
			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return g;
	}

	@SuppressWarnings("deprecation")
	public
	Reservation returnReservationAtCheckout(int r, String c) {
		Reservation r1 = new Reservation();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update Reservation set CheckOut=? where ReservationID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			java.util.Date check0 = new java.util.Date(c);
			java.sql.Date sqlDate2 = new java.sql.Date(check0.getTime());
			preparedStmt.setDate(1, sqlDate2);
			preparedStmt.setInt(2, r);
			preparedStmt.execute();

			String sql2 = "select * from Reservation where ReservationID=?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setInt(1, r);
			ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
				String roomid = rs.getString("RoomNo");
				int RID = Integer.parseInt(roomid);
				String guestid = rs.getString("GuestID");
				int gID = Integer.parseInt(guestid);
				String check = rs.getString("CheckIn");
				check = check.substring(0, 10);
				String checko = rs.getString("CheckOut");
				checko = checko.substring(0, 10);
				String adv = rs.getString("Advance");
				int advance = Integer.parseInt(adv);
				Reservation r2 = new Reservation(r, gID, RID, check, checko, 0,
						advance);
				return r2;
			}

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return r1;
	}

	public Reservation guestReport(int r) {
		Reservation r1 = new Reservation();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql2 = "select * from Reservation where ReservationID=?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setInt(1, r);
			ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
				String roomid = rs.getString("RoomNo");
				int RID = Integer.parseInt(roomid);
				String guestid = rs.getString("GuestID");
				int gID = Integer.parseInt(guestid);
				String check = rs.getString("CheckIn");
				check = check.substring(0, 10);
				String checko = rs.getString("CheckOut");
				checko = checko.substring(0, 10);
				String adv = rs.getString("Advance");
				int advance = Integer.parseInt(adv);
				Reservation r2 = new Reservation(r, gID, RID, check, checko, 0,
						advance);
				return r2;
			}

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return r1;
	}
	// ////////////////////Rai's/////////////////////////////////////////

	public void returnReservationAtCancelBooking(int rE) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "Delete from Reservation where ReservationID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, rE);
			preparedStmt.execute();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	}

	public int getAdvance(int advance) {
		int s = 0;
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "SELECT Advance from Reservation where Reservation=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, advance);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String t = rs.getString("Advance");
				s = Integer.parseInt(t);
				return s;
			}
			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return s;
	}

	public void endReservation(int id) {
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			String sql = "update RoomTable set Availability=?  where RoomID=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, 1);
			preparedStmt.setInt(2, id);
			preparedStmt.execute();

			con.close();

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	}

	public void roomService(int r) {
		
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			String date =dateFormat.format(cal.getTime());
			
			
			String sql2 = "INSERT INTO RoomService values(?,?)";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setInt(1, r);
			preparedStmt2.setString(2, date);
			 preparedStmt2.execute();
		
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
	}

	public Reservation returnReservation(int r) {
		Reservation r1 = new Reservation();
		try {
			String url = "jdbc:ucanaccess://./Project.accdb";
			Connection con = null;
			con = DriverManager.getConnection(url);

			String sql2 = "select * from Reservation where ReservationID=?";
			PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
			preparedStmt2.setInt(1, r);
			ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
				String roomid = rs.getString("RoomNo");
				int RID = Integer.parseInt(roomid);
				String guestid = rs.getString("GuestID");
				int gID = Integer.parseInt(guestid);
				String check = rs.getString("CheckIn");
				check = check.substring(0, 10);
				String checko = rs.getString("CheckOut");
				checko = checko.substring(0, 10);
				String adv = rs.getString("Advance");
				int advance = Integer.parseInt(adv);
				Reservation r2 = new Reservation(r, gID, RID, check, checko, 0,
						advance);
				return r2;
			}

		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		return r1;
	}

}
