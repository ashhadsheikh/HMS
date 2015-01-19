package businessLogic;

import receptionist.ReceptionistsDB;

public class GuestClass {
	private int id;
	private String cnic;
	private  String name;
	private String nationality;
	private String address;
	public GuestClass(){
	}
	public GuestClass(int i,String c,String n, String n2,String a) {
		 setId(i);
		setCnic(c);
		setName(n);
		setNationality(n2);
		setAddress(a);
	}

	public int getID(){
		return getId();
	}
	public String getcnic(){
		return getCnic();
	}
	public String getName(){
		return name;
	}
	public String returnName(int id){
		return ReceptionistsDB.getDbHandler().returnGuestName(id);
	}
	public String getNationality(){
		return nationality;
	}
	public String getAddress(){
		return address;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
