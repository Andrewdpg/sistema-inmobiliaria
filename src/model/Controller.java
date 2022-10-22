package model;

public class Controller {

	public static final int TOTAL_BUILDINGS = 10;
	private Building[] buildings;
	private Person[] persons;

	public Controller() {
		this.buildings = new Building[TOTAL_BUILDINGS];
		this.persons = new Person[1];
	}

	public String addBuilding(String name, String address, int qApartments) {
		String msg = "Oops, looks like there is no space left for another building.";
		Building newBuilding = new Building(name, address, qApartments);
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] == null) {
				buildings[i] = newBuilding;
				msg = "Building successfully added.";
				i = TOTAL_BUILDINGS;
			}
		}
		return msg;
	}

	public String addApartmentTo(String name, String id, int qRooms, int qBathrooms, boolean hasBalcony,
			double monthlyCost) {
		String msg = "Building not found";
		Apartment newApartment = new Apartment(id, qRooms, qBathrooms, hasBalcony, monthlyCost);
		int position = searchBuildingPositionByName(name);

		if (position != -1) {
			msg = buildings[position].addApartment(newApartment);
		}

		return msg;
	}

	public Owner newOwner(int idType, String id, String name, String phone, int phoneType, String bankAccount,
			String bankName) {
		return new Owner(IdType.values()[(IdType.values().length > idType && idType >= 0) ? idType : 0], id, name,
				phone, PhoneType.values()[(IdType.values().length > phoneType && phoneType >= 0) ? phoneType : 0],
				bankAccount,
				bankName);
	}

	public Tenant newTenant(int idType, String id, String name, String phone, int phoneType) {
		return new Tenant(IdType.values()[(IdType.values().length > idType && idType >= 0) ? idType : 0], id, name,
				phone, PhoneType.values()[(IdType.values().length > phoneType && phoneType >= 0) ? phoneType : 0]);
	}

	public String addPerson(Person newPerson) {
		String msg = "Id already exist.";
		if (searchPersonPositionById(newPerson.getId()) == -1) {
			boolean added = false;
			for (int i = 0; i < persons.length && !added; i++) {
				if (persons[i] == null) {
					persons[i] = newPerson;
					added = true;
				}
			}
			if (!added) {
				Person[] tempPersons = new Person[persons.length + 1];
				for (int i = 0; i < persons.length; i++) {
					tempPersons[i] = persons[i];
				}
				tempPersons[tempPersons.length - 1] = newPerson;
				persons = tempPersons;
			}
			msg = "Person successfully added.";
		}

		return msg;
	}

	public String linkOwnerOf(String name, String id, String personId) {
		String msg = "Person not found.";
		int personPos = searchPersonPositionById(personId);

		if (personPos != -1) {
			msg = "Building not found.";
			int buildingPos = searchBuildingPositionByName(name);

			if (buildingPos != -1) {
				msg = buildings[buildingPos].setOwnerOf(id, personId);
			}
		}
		return msg;
	}

	public String linkTenantOf(String name, String id, String personId) {
		String msg = "Person not found.";
		int personPos = searchPersonPositionById(personId);

		if (personPos != -1) {
			msg = "Building not found.";
			int buildingPos = searchBuildingPositionByName(name);

			if (buildingPos != -1) {
				msg = buildings[buildingPos].setTenantOf(id, personId);
			}
		}
		return msg;
	}

	public String countApartmentsOf(String name) {
		String msg = "Building not found";
		int position = searchBuildingPositionByName(name);

		if (position != -1) {
			msg = "Total available apartments in " + name + ": " + buildings[position].availableApartments();
		}

		return msg;
	}

	public String totalIncomeOf(String name) {
		String msg = "Building not found";
		int position = searchBuildingPositionByName(name);
		if (position != -1) {
			msg = "Total income of " + name + ": " + buildings[position].getTotalIncome();
		}
		return msg;
	}

	public int searchBuildingPositionByName(String name) {

		int position = -1;

		for (int i = 0; i < buildings.length && position == -1; i++) {
			if (buildings[i] != null) {
				if (buildings[i].getName().equals(name)) {
					position = i;
				}
			}
		}

		return position;
	}

	public int searchPersonPositionById(String id) {

		int position = -1;

		for (int i = 0; i < persons.length && position == -1; i++) {
			if (persons[i] != null) {
				if (persons[i].getId().equals(id)) {
					position = i;
				}
			}
		}

		return position;
	}

	public String getIdTypeList() {
		String msg = "";
		for (int i = 0; i < IdType.values().length; i++) {
			msg += i + ". " + IdType.values()[i] + "\n";
		}
		return msg;
	}

	public String getPhoneTypeList() {
		String msg = "";
		for (int i = 0; i < PhoneType.values().length; i++) {
			msg += i + ". " + PhoneType.values()[i] + "\n";
		}
		return msg;
	}

	public String checkAvailabilityOf(String name, String id) {
		String msg = "Building not found";
		int position = searchBuildingPositionByName(name);
		if (position != -1) {
			msg = buildings[position].checkAvailabilityOf(id);
		}
		return msg;
	}

	public String totalRentedApartmentsBy(String personId) {
		String msg = "Person not found.";

		if (searchPersonPositionById(personId) != -1) {
			int count = 0;
			for (int i = 0; i < buildings.length; i++) {
				if (buildings[i] != null) {
					count += buildings[i].rentedApartmentsBy(personId);
				}
			}
			msg = "Total rented apartments: " + count;
		}
		return msg;
	}

	public String totalPaymentFor(String personId) {
		String msg = "Person not found.";

		if (searchPersonPositionById(personId) != -1) {
			double total = 0;
			for (int i = 0; i < buildings.length; i++) {
				if (buildings[i] != null) {
					total += buildings[i].paymentFor(personId);
				}
			}
			msg = "Total rented apartments: " + total * 0.9;
		}
		return msg;
	}

}