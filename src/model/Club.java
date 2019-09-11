package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Club implements Comparable<Club>{
	
	 
	private String id;
	private String name;
	private String creationdate;
	private String mascotsType;
	
	
	private ArrayList<Owner> owners;
	
	
	public Club(String id, String name, String creationdate, String mascotsType) throws IOException  {
		
		this.id = id;
		this.name = name;
		this.creationdate = creationdate;
		this.mascotsType = mascotsType;
		owners = new ArrayList<Owner>();
		if(!new File(id).exists()) {
			new File(id).createNewFile();
		}
		loadData();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCreationdate() {
		return creationdate;
	}



	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}



	public String getMascotsType() {
		return mascotsType;
	}



	public void setMascotsType(String mascotsType) {
		this.mascotsType = mascotsType;
	}
	
    public ArrayList<Owner> getOwners() {
    	return owners;
    }


	@Override
	public int compareTo(Club o) {
		return owners.size()-o.getOwners().size();
	}
	public int compareID(Club club) {
		return id.compareTo(club.getId());
	}
	public int compareName(Club club) {
		return name.compareTo(club.getName());
	}
	public int compareCreacionDate(Club club) {
		return creationdate.compareTo(club.getCreationdate());
	}
	public int comparePetType(Club club) {
		return mascotsType.compareTo(club.getMascotsType());
	}

	
	public void addOwner(Owner owner) {
		boolean diferen = false;
			for (int i = 0 ;i<owners.size() && !diferen;i++) {
				if (owners.get(i).getId().equals(owner.getId())) {
					diferen=true;
					}
					if (!diferen) {
				owners.add(owner);
			}
		}
	}
	
	
	
	
	public boolean equalOwner (Owner o1) {
		 boolean diferent = false;
		 for (int i=0;i<owners.size() && !diferent; i++) {
			 if (owners.get(i).compareID(o1)==0) {
				 diferent=true;
			 }
			
	}
		 return diferent;
	
	}
	//Metodos de Ordenamiento
		public void ortherBubbleOwnerID() {
		for (int i =0;i<owners.size();i++) {
			for (int j =1;j>0;j--) {
				if(owners.get(j-1).compareID(owners.get(j))>0){
					
					Owner temp= owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1,temp);
					
				}
			}
		}
	}
	

		public void ortherBubbleOwnerName() {
		for (int i =0;i<owners.size();i++) {
			for (int j =1;j>0;j--) {
				if(owners.get(j-1).compareNames(owners.get(j))>0){
					
					Owner temp= owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1,temp);
					
				}
			}
		}
	}

		public void ortherInsercionOwnerBirthDay() {
			for (int i =0;i<owners.size()-1;i++) {
				Owner  p = owners.get(i);
				int cual = i;
				for (int j = i+1;j<owners.size();j++) {
					if (p .compare(p, owners.get(j))>0) {
					p =owners.get(j);
					cual = j ;
					}
				}
			}
		}
			
			
			public void ortherBubbleOwnerMascost() {
				for (int i =0;i<owners.size();i++) {
					for (int j =1;j>0;j--) {
						if(owners.get(j-1).comparePetType(owners.get(j))>0){
							
							Owner temp= owners.get(j);
							owners.set(j, owners.get(j+1));
							owners.set(j+1,temp);
							
						}
					}
				}
			}
			public void ortherBubbleOwnerLastName() {
				for (int i =0;i<owners.size();i++) {
					for (int j =1;j>0;j--) {
						if(owners.get(j-1).compareLastNames(owners.get(j))>0){
							
							Owner temp= owners.get(j);
							owners.set(j, owners.get(j+1));
							owners.set(j+1,temp);
							
						}
					}
				}
			}
			//Metodos de busqueda tradicional y binario 
			
			
			
			//guarda los dueno y sus mascotas en un archivo que tiene el id del club 
			
			
			
			public void saveData() throws FileNotFoundException ,IOException{
				File file = new File (id);
				BufferedWriter lector = new BufferedWriter(new FileWriter(file));
				lector.write("");
				lector.close();
				ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
				for (int i =0;i<owners.size();i++) {
					o.writeObject(owners.get(i));
					
				}
				o.close();
				
			}
			
			
			
			public void loadData() {
				File file = new File(id);
				if(file.exists()) {
					try {
						ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
						owners =(ArrayList<Owner>)o.readObject();
						o.close();
					}catch(Exception e) {
						
					}
				}
			}
			
			
			//Metodos de Busqueda Tradicional
			
			
			
			public String busquedaTradID(String id) {
				String msg="the owner does not exist";
				boolean diferent = false;
				for (int i =0;i<owners.size() && !diferent ;i++) {
					if( owners.get(i).getId().equals(id) ) {
						msg= "Se ha encontrado el dueno con el Id y su nombre es: "+owners.get(i).getNames();
						diferent = true ;
					}
				}
				return msg;
				
			}
			public String busquedaTradName(String name) {
				String msg="the owner does not exist";
				
				for (int i =0;i<owners.size()  ;i++) {
					if(owners.get(i).getNames().equals(name) ) {
						msg += "La persona con el nombre incado es : ";
						msg += owners.get(i).getNames()+"\n";
						
					}
				}
				return msg;
				
			}
			public String busquedaTradLastNames(String lastName) {
				String msg="the owner does not exist";
				
				for (int i =0;i<owners.size()  ;i++) {
					if(owners.get(i).getLastNames().equals(lastName) ) {
						msg += "La persona con el apellido  incado es : ";
						msg += owners.get(i).getLastNames()+"\n";
						
					}
				}
				return msg;
				
			}
			public String busquedaTradBirthDate(String birthDate) {
				String msg="the owner does not exist";
				
				for (int i =0;i<owners.size()  ;i++) {
					if(owners.get(i).getBirthDate().equals(birthDate) ) {
						msg += "La persona con la fecha de naciemiento incada es : ";
						msg += owners.get(i).getNames()+" "+"\n";
						
					}
				}
				return msg;
				
			}
			public String busquedaTradOwnerMascotType(String petType) {
				String msg="the owner does not exist";
				
				for (int i =0;i<owners.size()  ;i++) {
					if(owners.get(i).getMascotsType().equals(petType) ) {
						msg += "El tipo de mascota que prefiere(n) el(los) dueno(s) es (son) : ";
						msg += owners.get(i).getMascotsType()+"\n";
						
					}
				}
				return msg;
				
			}
			
			
			//Busqueda Binaria
			
			public String buscarBinarioPorOwnerName(String  name ) {
				String  msg = "the owner does not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getNames().compareTo(name)==0){
						msg = "Se ha encontarado el dueno por medio del nombre indicado";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getNames().compareTo(name)>0) {
						fin = mitad-1;
						
						
					}else {
						inicio=mitad+1;
						
					}
				}
				return msg ;
			}
			
			public String buscarBinarioOwnerLastName(String  lastName ) {
				String  msg = "the owner does not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getLastNames().compareTo(lastName)==0){
						msg = "Se ha encontarado el dueno por medio del los apellidos indicados";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getLastNames().compareTo(lastName)>0) {
						fin = mitad-1;
					
						
					}else {
						inicio=mitad+1;
						
					}
				}
				return msg ;
			}
			
			public String buscarBinarioOwnerBirthDate(String  birthDate ) {
				String  msg = "the owner does not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getBirthDate().compareTo(birthDate)==0){
						msg = "Se ha encontarado el dueno por medio de la fecha de nacimiento indicada";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getBirthDate().compareTo(birthDate)>0) {
						fin = mitad-1;
					
						
					}else {
						inicio=mitad+1;
						
					}
				}
				return msg ;
			}
			
			
			public String buscarBinarioOwnerMascotType(String  petType ) {
				String  msg = "the owner does not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getMascotsType().compareTo(petType)==0){
						msg = "Se ha encontrado la preferencia del tipo de mascota del dueno";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getMascotsType().compareTo(petType)>0) {
						fin = mitad-1;
						
						
					}else {
						inicio=mitad+1;
						
					}
				}
				return msg ;
			}
			
			
			public String buscarBinarioOwnerId(String  iD ) {
				String  msg = "the owner does not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getId().compareTo(iD)==0){
						msg = "se ha encontrado el dueno por medio de la identificacion";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getId().compareTo(iD)>0) {
						fin = mitad-1;
			
						
					}else {
						inicio=mitad+1;
						
					}
				}
				return msg ;
			}
			
			//responsabilidades pet trad 
			public String  tradSearchNamePet(String name) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					msg = owners.get(i).busquedaTradName(name);
					diferent=true;
				}
				return msg;
			}
			
			public String  tradSearchID(String id) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					msg = owners.get(i).busquedaTradID(id);
					diferent=true;
				}
				return msg;
			}
			public String  tradSearchBirtDate(String birthDate) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					msg = owners.get(i).busquedaTradBirthDate(birthDate);
					diferent=true;
				}
				return msg;
			}
			public String  tradSearchPetType(String petType) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					msg = owners.get(i).busquedaTradPettype(petType);
					diferent=true;
				}
				return msg;
			}
			public String  tradSearchPetGender(int gender) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					msg = owners.get(i).busquedaTradGender(gender);
					diferent=true;
				}
				return msg;
			}
			//Responsabilidades de Metodo binario 
			public boolean binSearchNamePet(String name) {
				boolean diferent =false;
				for(int i = 0;i<owners.size() && !diferent ; i++) {
					diferent = owners.get(i).buscarBinarioPorNombre(name);
				}
				return diferent;
			}
			
			
			public boolean binSearchID(String id) {
				boolean diferent =false;
				for(int i = 0;i<owners.size() && !diferent ; i++) {
					diferent = owners.get(i).buscarBinarioPorID(id);
				}
				return diferent;
			}
			public boolean binSearchBirthDate(String birthDate) {
				boolean diferent =false;
				for(int i = 0;i<owners.size() && !diferent ; i++) {
					diferent = owners.get(i).buscarBinarioPorFechaDeNacimiento(birthDate);
				}
				return diferent;
			}
			public boolean binSearchPetType(String petType) {
				boolean diferent =false;
				for(int i = 0;i<owners.size() && !diferent ; i++) {
					diferent = owners.get(i).buscarBinarioPorFechaDeNacimiento(petType);
				}
				return diferent;
			}
			public boolean binSearchPetGender(int gender) {
				boolean diferent =false;
				for(int i = 0;i<owners.size() && !diferent ; i++) {
					diferent = owners.get(i).buscarBinarioGender(gender);
				}
				return diferent;
			}
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			
			

			
			
	
			

	
}
		
