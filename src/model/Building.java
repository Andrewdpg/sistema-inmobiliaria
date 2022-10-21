package model;

public class Building{
	
	private String name;
	private String address;

	private Apartment[] apartment;

	public Building(String name, String address, int qApartments){
		this.name = name;
		this.address = address;
		this.apartment = new Apartment[qApartments];
	}
}