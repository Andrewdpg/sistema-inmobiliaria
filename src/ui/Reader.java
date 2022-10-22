package ui;

import java.util.Scanner;

public class Reader {
    
    public static final Scanner reader = new Scanner(System.in);

    public static int readValidInt() {
		int option = -1;

		if (reader.hasNextInt()) {
			option = reader.nextInt();
		} else {
			reader.next();
		}

		return option;
	}

    public static String readString(){
        String value = reader.next();
        return value;
    }
}
