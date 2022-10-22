package model;

public class Building{
	
	private String name;
	private String address;

	private Apartment[] apartments;

	public Building(String name, String address, int qApartments){
		this.name = name;
		this.address = address;
		this.apartments = new Apartment[qApartments];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}