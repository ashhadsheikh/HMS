package businessLogic;

import receptionist.ReceptionistsDB;


public class Room {
	int id;
	private String roomType;
	private int floor;
	private int noOfBeds;
	int availability;
	private long charges;
	Room(){
		
	}
	public Room(int i,String t,int f,int n,int a){
		id=i;
		 setRoomType(t);
		setFloor(i);
		setNoOfBeds(n);
		availability=a;
	}

	void setType(String t){
		setRoomType(t);
	}
	void setfloor(int f){
		setFloor(f);
	}
	void setBeds(int b){
		setNoOfBeds(b);
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public long getCharges() {
		return charges;
	}
	public void setCharges(long charges) {
		this.charges = charges;
	}
	
}
