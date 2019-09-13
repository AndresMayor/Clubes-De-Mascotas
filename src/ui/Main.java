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
		System.out.println("1.ADD OWNER.");
		System.out.println("2.ADD CLUB.");
		System.out.println("3.ADD PET.");
		System.out.println("4.SEARCH CLUB");
		System.out.println("5.SEARCH OWNER");
		System.out.println("6.SEARCH PET");
		System.out.println("7.LIST ORDER OBJECTS");
		System.out.println("8.DELATE PER");
		System.out.println("9.DELATE OWNER");
		System.out.println("10.DELATE CLUB");
		
		
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
		
		
		System.out.println("Enter the club ID");
		String idCLub  = reader.nextLine();
		
		System.out.println("Enter owner identification");
		String id = reader.nextLine();
		System.out.println("Enter the names:");
		String names = reader.nextLine();
		System.out.println("Enter the last name:");
		String lastName = reader.nextLine();
		System.out.println("Enter Date of Birth:");
		String birthDate = reader.nextLine();
		System.out.println("Enter the type of Pets:");
		String mascotType = reader.nextLine();
		Owner owner = new Owner(id,names,lastName,birthDate,mascotType);
     try {
		user.addOwnerClub(owner, idCLub );
     }catch(EqualObject e) {
    	 e.getMessage();
     }
		
		}
		
		
		
		public void buscarClub() {
			System.out.println("Select by what criteria you want to search the Club");
			System.out.println("1.ID");
			System.out.println("2.NAME");
			System.out.println("3.BIRTHDATE");
			System.out.println("4.TYPE OF THE PET: ");
			int option =reader.nextInt();
			reader.nextLine();
			if (option ==1) {
				System.out.println("Enter the club ID:");
				String id =reader.nextLine();
				
				long t1 = System.currentTimeMillis();
				System.out.println(user.busquedaTradID(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubId(id));
				long t4 = System.currentTimeMillis();
				long busquBina  =(t4-t3);
				System.out.println("The Traditional Method has delayed:"+resul);
				System.out.println("The binary search method has delayed:"+busquBina);

				
			}else if (option ==2 ) {
				System.out.println("Please Enter Club Name");
				String name = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradName(name));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubName(name));
				long t4 =System.currentTimeMillis();
				
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}else if (option==3) {
				System.out.println("Please, the creation date of the club in YYYY / MM / DD format:");
				String date = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradCreationDate(date));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubCreationDate(date));
				long t4 =System.currentTimeMillis();
				
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}else if (option == 4){
				System.out.println("Please Type Club's pet type:");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.busquedaTradMascotsType(petType));
				long t2 =System.currentTimeMillis();
				long resul = (t2-t1);
				long  t3 =System.currentTimeMillis();
				System.out.println(user.buscarBinarioClubMascorType(petType));
				long t4 =System.currentTimeMillis();
				
				System.out.println("The Traditional Method has delayed:"+resul);
				System.out.println("The binary search method has delayed:"+(t4-t3));
				
			}
			
			
		}
		
		
		public void buscarDueno() {
			
			System.out.println("Please Select by what criteria you want to find the owner");
			System.out.println("1.ID");
			System.out.println("2.NAMES");
			System.out.println("3.LAST NAMES");
			System.out.println("4.BIRTHDATE");
			System.out.println("5.TYPE OF THE MASCOTS");
			
			int option =reader.nextInt();
			reader.nextLine();
			if (option==1) {
				
				System.out.println("Please Enter the owner ID");
				String id  =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchOwnerId(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerId(id));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed:"+resul);
				System.out.println("The binary search method has delayed:"+(t4-t3));
				
				
			}else if (option==2) {
				
				System.out.println("Please Enter the owner names");
				String names =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchNameOwner(names));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerNames(names));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed:"+(t4-t3));			
				
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
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));	
				
			}else if(option==4) {
				System.out.println("Please Enter the owner's date of birth");
				String creationDate =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.print(user.tradSearchBirthDateOwner(creationDate));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchOwnerBirthDate(creationDate);
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}else if (option ==5 ) {
				System.out.println("Please type the owner's pet type");
				String mascotType =reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchPetTypeOwner(mascotType));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchOwnerPetType(mascotType));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}
			
		}
		
		
		public void buscarMascot() {
			System.out.println("Por Favor Seleccione por que criterio desea buscar de la mascota ");
			System.out.println("1.ID");
			System.out.println("2.NAME");
			System.out.println("3.BIRTHDATE");
			System.out.println("4.TYPE OF THE MASCOTS");
			System.out.println("5.GENDER");
			
			int option =reader.nextInt();
			if (option == 1) {
				System.out.println("Please Enter Pet ID:");
				String id = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchIdPet(id));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearcIdPet(id));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				

			}else if (option==2){
				System.out.println("Please Enter the pet's name Pet:");
				String name  = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchNamePet(name));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				user.binaSearchNameMascot(name);
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed:  "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}else if (option ==3) {
				System.out.println("Please Enter the date of birth of the Pet in YYYY / MM / DDD format:");
				String creationDate = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchBirthDate(creationDate));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchBirthDate(creationDate));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
				
			}else if(option ==4) {
				System.out.println("Please type the type of the pet:");
				String petType = reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchPetType(petType));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchPetType(petType));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed: "+resul);
				System.out.println("The binary search method has delayed: "+(t4-t3));
			}else if(option==5) {
				System.out.println("Please enter the gender of the pet: ");
				
				int  gender = reader.nextInt();
				reader.nextLine();
				long t1 =System.currentTimeMillis();
				System.out.println(user.tradSearchGenderPet(gender));
				long t2 = System.currentTimeMillis();
				long resul = (t2-t1);
				long t3 = System.currentTimeMillis();
				System.out.println(user.binaSearchGender(gender));
				long t4 =System.currentTimeMillis();
				System.out.println("The Traditional Method has delayed:  "+resul);
				System.out.println("The binary search method has delayed:"+(t4-t3));
			}
			
			
			
		}
		public void init () {
			user.init();
		}
		
		
		public void Orther () {
			System.out.println("Please select what type of object you want to order");
			System.out.println("1.OWNERS");
			System.out.println("2.PETS");
			System.out.println("3.CLUBS");
			int option =reader.nextInt();
			reader.nextLine();
			if(option==1) {
				System.out.println("Please enter the criteria you wish to order");
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
						System.out.println(user.getClubs().get(i).getOwners().toString()+"\n");
					}
				}else if (seleccion==2) {
					user.ortherBubbleOwnerNames();
					for (int i = 0; i < user.getClubs().size();i++) {
						System.out.println(user.getClubs().get(i).getOwners().toString()+"\n");
					}
				}
					else if(seleccion  == 3) {
						user.ortherBubbleOwnerLastName();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString()+"\n");
						}
					}
					else if (seleccion ==4 ) {
						user.ortherBubbleOwnerMascost();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString()+"\n");
						}
					}
					else if(seleccion ==5) {
						user.ortherInsercionOwnerBirthDay();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().toString()+"\n");
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
							System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString()+"\n");
						}
						
					}else if(seleccion==2) {
						user.ortherdBirthDay();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString()+"\n");
						}
					}
					else if(seleccion == 3) {
							user.ortherdGenderPet();
							for (int i = 0; i < user.getClubs().size();i++) {
								System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString()+"\n");
							}
						}
					else if(seleccion ==4) {
						user.ortherdMascotsType();
							for (int i = 0; i < user.getClubs().size();i++) {
								System.out.println(user.getClubs().get(i).getOwners().get(i).getPets().toString()+"\n");
							}
						}
					}
				else if(option == 3) {
					System.out.println("Please enter the criteria you wish to order");
					System.out.println("1.ID");
					System.out.println("2.CREATION DATE");
					System.out.println("3.NAME");
					System.out.println("4.MASCOTS TYPES");
					int seleccion =reader.nextInt();
					reader.nextLine();
					if(seleccion ==1) {
						user.clubOrtherID();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString()+"\n");
						}
						
					}else if (seleccion ==2) {
						user.clubsOtheredComparatioDate();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString()+"\n");
						}
						
					}else if(seleccion==3) {
						user.clubBubbleName();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString()+"\n");
						}
					}else if(seleccion == 4) {
						user.clubOrtherMascotType();
						for (int i = 0; i < user.getClubs().size();i++) {
							System.out.println(user.getClubs().get(i).toString()+"\n");
						}
					}
					
				}
			}
		
		public void delateClub() {
			System.out.println("Please Enter the ID of the CLUB you want to Delete:");
			String id =reader.nextLine();
			System.out.println(user.eliminateClub(id));

		}
		public void delatePet() {
			System.out.println("Please Enter the ID of the PET you want to Delete:");
			String id =reader.nextLine();
			System.out.println(user.eliminatePet(id));

		}
		public void delateOwner() {
			System.out.println("Please Enter the ID of the owner you want to Delete:");
			String id =reader.nextLine();
			System.out.println(user.eliminateOwners(id));

		}
		
		
		
		
		
		public void addClubs() {
		//	public Club(String id, String name, String creationdate, String mascotsType) 
			System.out.println("Please enter the club ID:");
			String id = reader.nextLine();
			System.out.println("Please Enter the Club Name:");
			String name = reader.nextLine();
			System.out.println("Please enter the creation date of the club:");
			String creationDate = reader.nextLine();
			System.out.println("Please Type the Club's Pet Type: ");
			String petType = reader.nextLine();
			Club clup = new Club (id,name,creationDate,petType);
			try {
			user.addClub(clup);
			}catch(Exception e) {
				
			}
			System.out.println("The Club has been added successfully");

		
		}
		public void addPets() {
			//	public Pet(String id, String name, String birthDate, String petType, int gender) {

			System.out.println("Please type the pet ID");
			String id = reader.nextLine();
			System.out.println("Please type pet name");
			String name =reader.nextLine();
			System.out.println("Please enter the date of birth of the pet");
			String birthDate =reader.nextLine();
			System.out.println("Please type the type of pet:");
			String petType =reader.nextLine();
			System.out.println("Please Select Gender");
			System.out.println("1.Male");
			System.out.println("2.Female");
			int options =reader.nextInt();
			reader.nextLine();
			if(options ==1) {
				options = Pet.MALE;				
			}else if(options ==2) {
				options = Pet.FEMALE;
				
			}
			System.out.println("Please Enter the Pet Owner's Id:");
			String idOwner =reader.nextLine();
			
			
			Pet pet1 = new Pet(id,name,birthDate,petType,options);
			user.addPets(pet1, idOwner);
			System.out.println("The Pet has been added successfully");


			
			



			


			
		}
		
		
		
		
		
		
		
				
	}
			
			
		
		
		


