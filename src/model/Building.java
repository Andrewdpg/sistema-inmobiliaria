package model;

public class Building {

	private String name;
	private String address;

	private Apartment[] apartments;

	public Building(String name, String address, int qApartments) {
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

	public String addApartment(Apartment newApartment) {
		String msg = "Apartment already exist in this building.";
		if (searchApartmentPositionById(newApartment.getId()) == -1) {
			msg = "Oops, looks like there is no space left for another apartment in this building.";
			for (int i = 0; i < apartments.length; i++) {
				if (apartments[i] == null) {
					apartments[i] = newApartment;
					msg = "Apartment successfully added.";
					i = apartments.length;
				}
			}
		}
		return msg;
	}

	public int searchApartmentPositionById(String id) {
		int position = -1;
		for (int i = 0; i < apartments.length && position == -1; i++) {
			if (apartments[i] != null) {
				if (apartments[i].getId().equals(id)) {
					position = i;
				}
			}
		}
		return position;
	}

	public String setOwnerOf(String id, String personId) {
		String msg = "Apartment not found.";
		int position = searchApartmentPositionById(id);
		if (position != -1) {
			apartments[position].setOwnerId(personId);
			msg = "Owner of " + this.name + "-" + apartments[position].getId() + " successfully changed";
		}
		return msg;
	}

	public String setTenantOf(String id, String personId) {
		String msg = "Apartment not found.";
		int position = searchApartmentPositionById(id);
		if (position != -1) {
			apartments[position].setTenantId(personId);
			msg = "Tenant of " + this.name + "-" + apartments[position].getId() + " successfully changed";
		}
		return msg;
	}

	public int availableApartments() {
		int count = 0;
		for (int i = 0; i < apartments.length; i++) {
			if (apartments[i] != null) {
				if (apartments[i].getTenantId() == null) {
					count++;
				}
			}

		}
		return count;
	}

	public double getTotalIncome() {
		double total = 0;
		for (int i = 0; i < apartments.length; i++) {
			if (apartments[i] != null) {
				if (apartments[i].getTenantId() != null) {
					total += apartments[i].getMonthlyCost();
				}
			}
		}
		return total;
	}

	public String checkAvailabilityOf(String id) {
		String msg = "Apartment not found.";
		int position = searchApartmentPositionById(id);
		if (position != -1) {
			msg = "The selected apartmens seems to be "
					+ (apartments[position].getTenantId() != null ? "taken." : "free.");
		}
		return msg;

	}

	public int rentedApartmentsBy(String personId) {
		int count = 0;
		for (int i = 0; i < apartments.length; i++) {
			if (apartments[i] != null) {
				if (personId.equals(apartments[i].getTenantId())) {
					count++;
				}
			}
		}
		return count;
	}

	public double paymentFor(String personId) {
		double total = 0;
		for (int i = 0; i < apartments.length; i++) {
			if (apartments[i] != null) {
				if (personId.equals(apartments[i].getOwnerId())) {
					total += apartments[i].getMonthlyCost();
				}
			}
		}
		return total;
	}

}