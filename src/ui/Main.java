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
		user = new Investor();
		
		
	}
	
	/**
	*The main method, is the started point of the program
	*@param args is an array of String, taken from the command list
	*/
	public static void main(String[] args) {
		
		 Main m = new Main();
		 m.init();
		 m.welcome();
		 m.showMenu();
		 

	}
	
	/**
	*A text to give the welcome to the user
	*/
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             WELCOME TO THE PET CLUB                                        |");
	}
	
	/**
	*To show the options that can do the user<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void showMenu(){
		int option = 0;
		while(option != 11){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.AGREGAR OWNER.");
		System.out.println("2.AGREGAR CLUB.");
		System.out.println("3.AGREGAR PET.");
		System.out.println("4.BUSCAR CLUB");
		System.out.println("5.BUSCAR DUENO");
		System.out.println("6.BUSCAR MASCOTA");
		System.out.println("7.Ordenar Objetos");
		System.out.println("8.Delate Pet");
		System.out.println("9.Delate Owner");
		System.out.println("10.Delate Club");
		
		System.out.println("----------------------------------------------------------------------------------------------");

		System.out.println("11.Exit.                                                                                       |");
		System.out.println("----------------------------------------------------------------------------------------------");

		option =reader.nextInt();
		reader.nextLine();
		switch(option) {
				case(1):
						addOwner();
				break;
				
				
				
				case(2):
					addClubs();
					break;
				
				
				case(3):
					addPets();
					
					break;
									
				case(4):
					
					buscarClub();
				
				break;
				
				case(5):
					
					buscarDueno();
				
				break;
				
				case(6):
					buscarMascot();
				
				break;
				
				case(7):
					Orther();
				break;
				
				case(8):
					 delatePet();
					break;
				
				
				case(9):
					
					delateOwner();
					break;
				
				
				case(10):
					delateClub();
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
     try {
		user.addOwnerClub(owner, idCLub );
     }catch(EqualObject e) {
    	 e.getMessage();
     }
		
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
			reader.nextLine();
			if (option ==1) {
				System.out.println("Por Favor Digite La identificacion del club:");
				String id =reader.nextLine();
				
				long t1 = System.currentTimeMillis();
				System.out.println(user.busquedaTradID(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubId(id));
				long t4 = System.currentTimeMillis();
				long busquBina  =(t4-t3);
				System.out.println("El Metodo Tradicional Ha demorado: "+resul);
				System.out.println("El Metodo de busqueda binaria ha demorado: "+busquBina);

				
			}else if (option ==2 ) {
				System.out.println("Por Favor Digite El Nombre del club:");
				String name = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradName(name));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubName(name));
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option==3) {
				System.out.println("Por Favor La Fecha de Cracion del club en formato AAAA/MM/DD:");
				String date = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradCreationDate(date));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubCreationDate(date));
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if (option == 4){
				System.out.println("Por Favor Digite El tipo de mascota del club:");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradMascotsType(petType));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubMascorType(petType));
				long t4 =System.currentTimeMillis();
				
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado: "+(t4-t3));
				
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
			reader.nextLine();
			if (option==1) {
				
				System.out.println("Por Favor Digite la identificacion del dueno");
				String id  =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchOwnerId(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerId(id));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
				
			}else if (option==2) {
				
				System.out.println("Por Favor Digite los nombres de dueno");
				String names =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchNameOwner(names));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerNames(names));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));			
				
			}else if (option==3) {
				System.out.println("Por Favor Digite los apellidos del dueno");
				String Lastnames =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchLastNamesOwner(Lastnames));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerLastNames(Lastnames));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));	
				
			}else if(option==4) {
				System.out.println("Por Favor Digite la fecha de nacimiento del dueno");
				String creationDate =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.print(user.tradSearchBirthDateOwner(creationDate));
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
				System.out.println(user.tradSearchPetTypeOwner(mascotType));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerPetType(mascotType));
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
				System.out.println(user.tradSearchIdPet(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearcIdPet(id));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				

			}else if (option==2){
				System.out.println("Por Favor Digite el nombre de la mascota  Mascota: ");
				String name  = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchNamePet(name));
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
				System.out.println(user.tradSearchBirthDate(creationDate));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchBirthDate(creationDate));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
				
			}else if(option ==4) {
				System.out.println("Por Favor Digite El tipo de la Mascota: ");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchPetType(petType));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchPetType(petType));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
			}else if(option==5) {
				System.out.println("Por Favor Digite El genero de la mascota: ");
				
				int  gender = reader.nextInt();
				reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchGenderPet(gender));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchGender(gender));
				long t4 =System.currentTimeMillis();
				System.out.println("El metodo Tradicional ha demorado: "+resul);
				System.out.println("El metodo de busqueda Binaria ha demorado"+(t4-t3));
			}
			
			
			
		}
		public void init () {
			user.init();
		}
		
		
		public void Orther () {
			System.out.println("Por favor seleccione que tipo de objeto desea ordenar");
			System.out.println("1.OWNERS");
			System.out.println("2.PETS");
			System.out.println("3.CLUBS");
			int option =reader.nextInt();
			reader.nextLine();
			if(option==1) {
				System.out.println("Por favor Digite por que criterio lo desea Ordenar");
				System.out.println("1.ID");
				System.out.println("2.NAMES");
				System.out.println("3.LAST NAMES");
				System.out.println("4.MASCOTS TYPES");
				System.out.println("5.BIRTH DATE");
				int seleccion =reader.nextInt();
				reader.nextLine();
				if (seleccion==1) {
					user.ortherBubbleOwnerID();;
					for (int i = 0; i < user.getClubs().size();i++) {
						System.out.println(user.getClubs().get(i).getOwners().toString());
					}
				}else if (seleccion==2) {
					user.ortherBubbleOwnerNames();
					for (int i = 0; i < user.getClubs().size();i++) {
						System.out.println(user.getClubs().get(i).getOwners().toString());
					}
				}
					else if(seleccion  == 3) {
						user.ortherBubbleOwnerLastName();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString());
						}
					}
					else if (seleccion ==4 ) {
						user.ortherBubbleOwnerMascost();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString());
						}
					}
					else if(seleccion ==5) {
						user.ortherInsercionOwnerBirthDay();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString());
						}
						
					}
				}else if( option == 2 ) {
					System.out.println("Por favor Digite por que criterio lo desea Ordenar");
					System.out.println("1.NAME");
					System.out.println("2.BIRTH DATE");
					System.out.println("3.GENDER");
					System.out.println("4.MASCOTS TYPES");
					int seleccion =reader.nextInt();
					reader.nextLine();
					if (seleccion==1) {
						user.ortherdtNamesPet();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString());
						}
						
					}else if(seleccion==2) {
						user.ortherdBirthDay();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString());
						}
					}
					else if(seleccion == 3) {
							user.ortherdGenderPet();
							for (int i = 0; i < user.getClubs().size();i++) {
								System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString());
							}
						}
					else if(seleccion ==4) {
						user.ortherdMascotsType();
							for (int i = 0; i < user.getClubs().size();i++) {
								System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString());
							}
						}
					}
				else if(option == 3) {
					System.out.println("Por favor Digite por que criterio lo desea Ordenar");
					System.out.println("1.ID");
					System.out.println("2.CREATION DATE");
					System.out.println("3.NAME");
					System.out.println("4.MASCOTS TYPES");
					int seleccion =reader.nextInt();
					reader.nextLine();
					if(seleccion ==1) {
						user.clubOrtherID();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString());
						}
						
					}else if (seleccion ==2) {
						user.clubsOtheredComparatioDate();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString());
						}
						
					}else if(seleccion==3) {
						user.clubBubbleName();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString());
						}
					}else if(seleccion == 4) {
						user.clubOrtherMascotType();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString());
						}
					}
					
				}
			}
		
		public void delateClub() {
			System.out.println("Por favor Digite el ID del club que quiere Eliminar: ");
			String id =reader.nextLine();
			System.out.println(user.eliminateClub(id));

		}
		public void delatePet() {
			System.out.println("Por favor Digite el ID de la mascota que quiere Eliminar: ");
			String id =reader.nextLine();
			System.out.println(user.eliminatePet(id));

		}
		public void delateOwner() {
			System.out.println("Por favor Digite el ID del dueno  que quiere Eliminar: ");
			String id =reader.nextLine();
			System.out.println(user.eliminateOwners(id));

		}
		
		
		
		
		
		public void addClubs() {
		//	public Club(String id, String name, String creationdate, String mascotsType) 
			System.out.println("Por favor Digite el ID del club: ");
			String id = reader.nextLine();
			System.out.println("Por favor Digite el Nombre del club: ");
			String name = reader.nextLine();
			System.out.println("Por favor Digite el fecha de creacion del club: ");
			String creationDate = reader.nextLine();
			System.out.println("Por favor Digite el Tipo de Mascotas del club: ");
			String petType = reader.nextLine();
			Club clup = new Club (id,name,creationDate,petType);
			user.addClub(clup);
			System.out.println("El Club se Ha agregado con exito ");

		
		}
		public void addPets() {
			//	public Pet(String id, String name, String birthDate, String petType, int gender) {

			System.out.println("Por favor digite el la identificacion de la mascota ");
			String id = reader.nextLine();
			System.out.println("Por favor Digite nombre de la mascota ");
			String name =reader.nextLine();
			System.out.println("Por favor Digite la fecha de nacimiento de la mascota");
			String birthDate =reader.nextLine();
			System.out.println("Por favor Digite El tipo de mascota: ");
			String petType =reader.nextLine();
			System.out.println("Por favor Selecione el Genero");
			System.out.println("1.Male");
			System.out.println("2.Female");
			int options =reader.nextInt();
			reader.nextLine();
			if(options ==1) {
				options = Pet.MALE;				
			}else if(options ==2) {
				options = Pet.FEMALE;
				
			}
			System.out.println("Por favor Digite el Id del Propietario de la mascota: ");
			String idOwner =reader.nextLine();
			
			
			Pet pet1 = new Pet(id,name,birthDate,petType,options);
			user.addPets(pet1, idOwner);
			System.out.println("La Mascota se Ha agregado con exito ");


			
			



			


			
		}
		
		public void verClubs() {
			System.out.println(user.getClubs().toString());
		}
		
		
		
		
		
				
	}
			
			
		
		
		


