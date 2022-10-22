package ui;

import model.Controller;

public class Main {

	public final static String MENU = "<<<<< Real State >>>>>\n\n" +
			"1. Register a building \n" +
			"2. Register an apartment to a building \n" +
			"3. Register an owner \n" +
			"4. Register a tenant \n" +
			"5. Consult the number of apartments on a specific building \n" +
			"6. Consult the total monthly rent value of the rented apartments on a specific building \n" +
			"7. Consult apartment availability \n" +
			"8. Consult total apartments renteds by a tenant \n" +
			"9. Consult total rent value received by an owner \n" +
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

		switch (option) {
			case 1:
				message = "Invalid number of apartments.";

				System.out.print("What is its name? ");
				String name = Reader.readString();

				System.out.print("Where is it located? ");
				String address = Reader.readString();

				System.out.print("How many apartments does it has? ");
				int qApartments = Reader.readValidInt();

				if (qApartments >= 0) {
					message = controller.addBuilding(name, address, qApartments);
				}
				break;
			default:
				message = "Invalid option.";
				break;
		}
		System.out.println("\n"+message+"\n");
	}
}