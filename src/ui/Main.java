package ui;
import java.util.Scanner;

import model.*;

/**
*This is the main class, is for the interaction between the user and the program
*@author Andres Mayor Aldana 
*Icesi University<br>
*APO II<br>
*/
public class Main {

	
	//Relations
	private Investor user;
	private Scanner reader;
	
	/**
	*Main constructor
	*/
	public Main() {
	
		reader = new Scanner(System.in);
		
	}
	
	/**
	*The main method, is the started point of the program
	*@param args is an array of String, taken from the command list
	*/
	public static void main(String[] args) {
		 Main m = new Main();
		 m.welcome();
		 m.showMenu();

	}
	
	/**
	*A text to give the welcome to the user
	*/
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             WELCOME TO THE PET CLUB                                        |");
		System.out.println("----------------------------------------------------------------------------------------------");
	}
	
	/**
	*To show the options that can do the user<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void showMenu(){
		int option = 0;
		while(option != 5){
		
		System.out.println("1.Agregar dueno");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		System.out.println("5.Exit.");
		option =reader.nextInt();
		reader.nextLine();
		switch(option) {
				case(1):
					
					addOwner();
				break;
				
			
				
				
				
				
		}
		
		
		}
		
		
	
	
	
	
	
		}
	
	
		public void addOwner() {
		
		
		System.out.println("Ingresar  identificacion del club ");
		String idCLub  = reader.nextLine();
		
		System.out.println("Ingresar  identificacion del dueno ");
		String id = reader.nextLine();
		System.out.println("Ingrese los nombres: ");
		String names = reader.nextLine();
		System.out.println("Ingrese los Apellidos: ");
		String lastName = reader.nextLine();
		System.out.println("Ingrese Fecha de Nacimiento: ");
		String birthDate = reader.nextLine();
		System.out.println("Ingrese el tipo de Mascotas: ");
		String mascotType = reader.nextLine();
		Owner owner = new Owner(id,names,lastName,birthDate,mascotType);
     
		user.addOwnerClub(owner, idCLub );
		System.out.println("El dueno se ha agregado con Exito");
		}
		public void addClub() {
			
		}
		
		

}
