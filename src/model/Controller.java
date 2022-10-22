package model;

public class Controller {

	public static final int TOTAL_BUILDINGS = 10;
	private Building[] buildings;

	public Controller() {
		this.buildings = new Building[TOTAL_BUILDINGS];
	}

	public String addBuilding(String name, String address, int qApartments) {
		String msg = "Oops, looks like there is no space left for another building.";
		Building newBuilding = new Building(name, address, qApartments);
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] == null){
				buildings[i] = newBuilding;
				msg = "Building successfully added.";
				i=TOTAL_BUILDINGS;
			}
		}
		return msg;
	}
}