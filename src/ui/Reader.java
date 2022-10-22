package ui;

import java.util.Scanner;

public class Reader {
    
    public static final Scanner reader = new Scanner(System.in);

    public static int readValidInt() {
		int value = -1;

		if (reader.hasNextInt()) {
			value = reader.nextInt();
		} else {
			reader.next();
		}

		return value;
	}

	public static double readValidDouble() {
		double value = -1;

		if (reader.hasNextDouble()) {
			value = reader.nextDouble();
		} else {
			reader.next();
		}

		return value;
	}

    public static String readString(){
        String value = reader.next();
        return value;
    }
}
