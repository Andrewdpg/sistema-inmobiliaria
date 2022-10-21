package ui;

import model.Controller;
import java.util.Scanner;

public class Main{
	private Scanner reader; 
	private Controller controller;

	public Main(){
		controller = new Controller();
	}
	
	public static void main(String[] args){
		Main main = new Main();
		int option = -1;

		do{
			option = getOptionShowMenu();
			main.executeOption(option);
		}while(option != 0);	
	}


	public Scanner getReader(){
		return reader;
	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Real State >>>>>");
		System.out.println(
				"1. \n" +
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

	public static int readOption(){

	}

	public void executeOption(int option){


		

		switch(option){
			case 1:
				break;
			default:
				break;
		}
	}

}