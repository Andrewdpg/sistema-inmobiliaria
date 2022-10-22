package ui;

import model.Controller;

public class Main {

	public final static String MENU = "<<<<< Real State >>>>>\n\n" +
			"1. Register a building \n" +
			"2. Register an apartment to a building \n" +
			"3. Register an owner \n" +
			"4. Set owner for an apartment \n" +
			"5. Register a tenant \n" +
			"6. Set tenant for an apartment \n" +
			"7. Consult the number of available apartments of a specific building \n" +
			"8. Consult the total monthly rent value of the rented apartments on a specific building \n" +
			"9. Consult apartment availability \n" +
			"10. Consult total apartments renteds by a tenant \n" +
			"11. Consult total rent value received by an owner \n" +
			"0. Exit. ";

	private Controller controller;

	public Main() {
		controller = new Controller();
	}

	public static void main(String[] args) {
		Main main = new Main();
		int option = -1;

		do {
			option = main.getOptionShowMenu();
			main.executeOption(option);
		} while (option != 0);
	}

	public Controller getController() {
		return this.controller;
	}

	public int getOptionShowMenu() {
		System.out.println(MENU);
		int option = Reader.readValidInt();
		return option;
	}

	public void executeOption(int option) {
		String message = "";
		String name;
		String address;
		int qApartments;
		String id;
		String personId;
		int qRooms;
		int qBathrooms;
		boolean hasBalcony;
		double monthlyCost;
		int idType;
		int phoneType;
		String phone;
		String bankAccount;
		String bankName;

		switch (option) {
			case 1:
				message = "Invalid number of apartments.";

				System.out.print("What is its name? ");
				name = Reader.readString();

				System.out.print("Where is it located? ");
				address = Reader.readString();

				System.out.print("How many apartments does it has? ");
				qApartments = Reader.readValidInt();

				if (qApartments >= 0) {
					message = controller.addBuilding(name, address, qApartments);
				}
				break;

			case 2:

				System.out.print("What is the building's name? ");
				name = Reader.readString();

				System.out.print("What will be the id for the new apartment? ");
				id = Reader.readString();

				System.out.print("How many rooms does it have? ");
				qRooms = Reader.readValidInt();

				System.out.print("How many bathrooms does it have? ");
				qBathrooms = Reader.readValidInt();

				System.out.print("Has abalcony? \n" + "1. Yes\n" + "2. No\n" + "Awnser: ");
				hasBalcony = Reader.readValidInt() == 1;

				System.out.print("How many does it costs? ");
				monthlyCost = Reader.readValidDouble();

				if (qBathrooms < 0) {
					message = "Invalid bathrooms amount value.";
				} else if (qRooms < 0) {
					message = "Invalid rooms amount value.";
				} else if (monthlyCost < 0) {
					message = "Invalid cost value.";
				} else {
					message = controller.addApartmentTo(name, id, qRooms, qBathrooms, hasBalcony, monthlyCost);
				}
				break;

			case 3:

				System.out.println("ID type: ");
				System.out.println(controller.getIdTypeList());
				idType = Reader.readValidInt();

				System.out.print("What is your id? ");
				personId = Reader.readString();

				System.out.print("What is your name? ");
				name = Reader.readString();

				System.out.println("Phone type: ");
				System.out.println(controller.getPhoneTypeList());
				phoneType = Reader.readValidInt();

				System.out.print("What is your phone number? ");
				phone = Reader.readString();

				System.out.print("What is your bank's name? ");
				bankName = Reader.readString();

				System.out.print("What is your bank's account? ");
				bankAccount = Reader.readString();

				message = controller
						.addPerson(
								controller.newOwner(idType, personId, name, phone, phoneType, bankAccount, bankName));
				break;

			case 4:
				System.out.print("What is the building's name? ");
				name = Reader.readString();

				System.out.print("What is the apartment's id? ");
				id = Reader.readString();

				System.out.print("What is the owner's id? ");
				personId = Reader.readString();

				message = controller.linkOwnerOf(name, id, personId);
				break;
			case 5:

				System.out.println("ID type: ");
				System.out.println(controller.getIdTypeList());
				idType = Reader.readValidInt();

				System.out.print("What is your id? ");
				personId = Reader.readString();

				System.out.print("What is your name? ");
				name = Reader.readString();

				System.out.println("Phone type: ");
				System.out.println(controller.getPhoneTypeList());
				phoneType = Reader.readValidInt();

				System.out.print("What is your phone number? ");
				phone = Reader.readString();

				message = controller
						.addPerson(controller.newTenant(idType, personId, name, phone, phoneType));
				break;
			case 6:
				System.out.print("What is the building's name? ");
				name = Reader.readString();

				System.out.print("What is the apartment's id? ");
				id = Reader.readString();

				System.out.print("What is the tenant's id? ");
				personId = Reader.readString();

				message = controller.linkTenantOf(name, id, personId);
				break;

			case 7:
				System.out.print("What is the building's name? ");
				name = Reader.readString();

				message = controller.countApartmentsOf(name);
				break;

			case 8:

				System.out.print("What is the building's name? ");
				name = Reader.readString();

				message = controller.totalIncomeOf(name);
				break;
			case 9:
				System.out.print("What is the building's name? ");
				name = Reader.readString();

				System.out.print("What is the apartment's id? ");
				id = Reader.readString();

				message = controller.checkAvailabilityOf(name, id);
				break;
			case 10:

				System.out.print("What is the tenant's id? ");
				personId = Reader.readString();

				message = controller.totalRentedApartmentsBy(personId);
			case 11:

				System.out.print("What is the owners's id? ");
				personId = Reader.readString();

				message = controller.totalPaymentFor(personId);
			default:
				message = "Invalid option.";
				break;
		}
		System.out.println("\n" + message + "\n");
	}
}