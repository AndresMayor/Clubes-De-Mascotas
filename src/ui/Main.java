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
		System.out.println("2.BUSCAR CLUB");
		System.out.println("3.BUSCAR DUENO");
		System.out.println("4.BUSCAR MASCOTA");

		System.out.println("5.Exit.");
		option =reader.nextInt();
		reader.nextLine();
		switch(option) {
				case(1):
						addOwner();
				break;
				
				case(2):
					
					buscarClub();
				
				break;
				
				case(3):
					
					buscarDueno();
				
				break;
				
				case(4):
					buscarMascot();
				
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
		
		
		public void buscarClub() {
			System.out.println("Por Favor Seleccione por que criterio desea buscar el Club");
			System.out.println("1.Indetificacion");
			System.out.println("2.Nombre");
			System.out.println("3.Fecha de Creacion");
			System.out.println("4.Tipo de Mascota");
			int option =reader.nextInt();
			if (option ==1) {
				System.out.println("Por Favor Digite La identificacion del club:");
				String id =reader.nextLine();
				long t1 = System.currentTimeMillis();
				user.busquedaTradID(id);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 =System.currentTimeMillis();
				user.buscarBinarioClubId(id);
				long t4 = System.currentTimeMillis();
				long busquBina  =(t4-t3);
				System.out.println("El Metodo  Tradicional Ha demorado "+resul);
				System.out.println("El Metodo  de busqueda binaria  ha demorado "+busquBina);

				
			}else if (option ==2 ) {
				System.out.println("Por Favor Digite El Nombre del club:");
				String name = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.busquedaTradName(name);
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				user.buscarBinarioClubName(name);
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option==3) {
				System.out.println("Por Favor La Fecha de Cracion del club en formato AAAA/MM/DD:");
				String date = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.busquedaTradCreationDate(date);
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				user.buscarBinarioClubCreationDate(date);
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option == 4){
				System.out.println("Por Favor Digite El tipo de mascota del club:");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.busquedaTradMascotsType(petType);
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				user.buscarBinarioClubMascorType(petType);
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}
			
			
		}
		
		
		public void buscarDueno() {
			
			System.out.println("Por Favor Seleccione por que criterio desea buscar el owner");
			System.out.println("1.Identificacion");
			System.out.println("2.Nombres");
			System.out.println("3.Apellidos");
			System.out.println("4.Fecha De nacimiento");
			System.out.println("5.Tipo de Mascotas");
			
			int option =reader.nextInt();
			
			if (option==1) {
				
				System.out.println("Por Favor Digite la identificacion del dueno");
				String id  =reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchOwnerId(id);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerId(id);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
				
			}else if (option==2) {
				
				System.out.println("Por Favor Digite los nombres de dueno");
				String names =reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchNameOwner(names);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerNames(names);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));			
				
			}else if (option==3) {
				System.out.println("Por Favor Digite los apellidos del dueno");
				String Lastnames =reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchLastNamesOwner(Lastnames);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerLastNames(Lastnames);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));	
				
			}else if(option==4) {
				System.out.println("Por Favor Digite la fecha de nacimiento del dueno");
				String creationDate =reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchBirthDateOwner(creationDate);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerBirthDate(creationDate);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option ==5 ) {
				System.out.println("Por Favor Digite el tipo de mascotas del dueno");
				String mascotType =reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchPetTypeOwner(mascotType);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerPetType(mascotType);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}
			
		}
		
		
		public void buscarMascot() {
			System.out.println("Por Favor Seleccione por que criterio desea buscar de la mascota ");
			System.out.println("1.Identificacion");
			System.out.println("2.Nombre");
			System.out.println("3.Fecha de Nacimiento");
			System.out.println("4.Tipo de Mascota ");
			System.out.println("5.Genero");
			
			int option =reader.nextInt();
			if (option == 1) {
				System.out.println("Por Favor Digite La Identificacion de la Mascota: ");
				String id = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchIdPet(id);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearcIdPet(id);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				

			}else if (option==2){
				System.out.println("Por Favor Digite el nombre de la mascota  Mascota: ");
				String name  = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchNamePet(name);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchNameMascot(name);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option ==3) {
				System.out.println("Por Favor Digite La fecha de nacimeto de la Mascota en formato AAAA/MM/DDD : ");
				String creationDate = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchBirthDate(creationDate);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchBirthDate(creationDate);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if(option ==4) {
				System.out.println("Por Favor Digite El tipo de la Mascota: ");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchPetType(petType);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchPetType(petType);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
			}else if(option==5) {
				System.out.println("Por Favor Digite El genero de la mascota: ");
				
				int  gender = reader.nextInt();
				reader.nextLine();
				long t1 =System.currentTimeMillis();
				user.tradSearchGenderPet(gender);
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchGender(gender);
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
			}
			
		}
		
		

}
