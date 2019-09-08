package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Owner  implements Serializable ,Comparator<Owner>,Comparable<Owner>{

	
	private String id;
	private String names;
	private String lastNames;
	private String birthDate;
	private String mascotsType;
	
	private ArrayList<Pet> pets;

	public Owner(String id, String names, String lastNames, String birthDate, String mascotsType) {
		
		this.id = id;
		this.names = names;
		this.lastNames = lastNames;
		this.birthDate = birthDate;
		this.mascotsType = mascotsType;
		pets = new ArrayList<Pet>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMascotsType() {
		return mascotsType;
	}

	public void setMascotsType(String mascotsType) {
		this.mascotsType = mascotsType;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int compareTo(Owner o) {
		return pets.size()-o.getPets().size();
	}
	public int compareNames(Owner owner) {
		return names.compareTo(owner.getNames());
	}
	public int compareID(Owner owner) {
		return id.compareTo(owner.getId());
	}
	public int compareLastNames(Owner owner) {
		return lastNames.compareTo(owner.getLastNames());
	}
	public int comparePetType(Owner owner) {
		return mascotsType.compareTo(owner.getMascotsType());
	}
	@Override
	public int compare(Owner o1, Owner o2) {
		return o1.getBirthDate().compareTo(o2.getBirthDate());
	}
	
	
	public void addPets(Pet mascot) {
		//que no tenga el mismo nombre para un dueno 
		boolean diferent = false;
		for (int i =0;i<pets.size()&& !diferent ;i++) {
			if (pets.get(i).getName().equals(mascot.getName())){
				diferent=true;
			}
			if (!diferent){
				pets.add(mascot);
				
			}
		}
	}
	
	
	
	public void ortherdNamePet() {
		for (int i =0;i<pets.size();i++) {
			for (int j =0;j<pets.size()-1-i;j++) {
				if(pets.get(j).compareNames(pets.get(j),pets.get(j+1))>0){
					
					
					Pet temp= pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,temp);
					
				}
			}
		}
	}
	
	public void ortherdID() {
		for (int i =0;i<pets.size();i++) {
			for (int j =0;j<pets.size()-1-i;j++) {
				if(pets.get(j).compareID(pets.get(j),pets.get(j+1))>0){
					
					Pet temp= pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,temp);
					
				}
			}
		}
	}
	
	
	public void ortherdBirthDay() {
		for (int i =0;i<pets.size();i++) {
			for (int j =0;j<pets.size()-1-i;j++) {
				if(pets.get(j).compareBirthDay(pets.get(j+1))>0){
					
					Pet temp= pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,temp);
					
				}
			}
		}
		
}
	public void ortherdMascotsType() {
		for (int i =0;i<pets.size();i++) {
			for (int j =0;j<pets.size()-1-i;j++) {
				if(pets.get(j).comparePetType(pets.get(j+1))>0){
					
					Pet temp= pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,temp);
					
				}
			}
		}
	}
	
	
	public void ortherdGenderPet() {
		for (int i =0;i<pets.size();i++) {
			for (int j =0;j<pets.size()-1-i;j++) {
				if(pets.get(j).compareGender(pets.get(j+1))>0){
					
					
					Pet temp= pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,temp);
					
				}
			}
		}
	}
	
	//Metodos de busqueda de tradicinal  
	
	public String busquedaTradID(String id) {
		String msg="La Mascota no existe";
		boolean diferent = false;
		for (int i =0;i<pets.size() && !diferent ;i++) {
			if( pets.get(i).getId().equals(id) ) {
				msg= "Se ha encpntrado la mascota con el Id y su nombre es: "+pets.get(i).getName();
				diferent = true ;
			}
		}
		return msg;
		
	}
	public String busquedaTradName(String name) {
		String msg="La Mascota no existe";
		
		for (int i =0;i<pets.size()  ;i++) {
			if( pets.get(i).getName().equals(name) ) {
				msg += "La(s) Mascota(s) con el nombre Indicado son: ";
				msg += pets.get(i).getName()+"\n";
				
			}
		}
		return msg;
		
	}
	public String busquedaTradBirthDate(String mascotType) {
		String msg="no hay macotas del  tipo indicado ";
		
		for (int i =0;i<pets.size() ;i++) {
			if( pets.get(i).getPetType().equals(mascotType) ) {
				msg = "La(s) Mascota(s) del  Tipo Indicado son: ";
			    msg += pets.get(i).getName()+"\n";
			
			}
		}
		return msg;
		
	}
	public String busquedaTradGender(int mascotType) {
		String msg="no hay macotas del genero indicado ";
		
		for (int i =0;i<pets.size() ;i++) {
			if( pets.get(i).getGender()==(mascotType) ) {
				msg = "La(s) Mascota(s) del  Genero  Indicado son: ";
			    msg += pets.get(i).getName()+"\n";
			
			}
		}
		return msg;
		
	}
	//Metdos de busqueda Binaria 
	public int buscarBinarioPorNombre(String  name ) {
		int position= -1;
		boolean encontro = false;
		int inicio = 0;
		int fin =pets.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(pets.get(mitad).getName().compareTo(name)==0){
				position = mitad;
				encontro=true;
				
				
			}else if (pets.get(mitad).getName().compareTo(name)>0) {
				fin = mitad-1;
				
			}else {
				inicio=mitad+1;
			}
		}
		return position;
	}
	
	
	public int buscarBinarioPorID(String   id ) {
		int position= -1;
		boolean encontro = false;
		int inicio = 0;
		int fin =pets.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(pets.get(mitad).getId().compareTo(id)==0){
				position = mitad;
				encontro=true;
				
				
			}else if (pets.get(mitad).getId().compareTo(id)>0) {
				fin = mitad-1;
				
			}else {
				inicio=mitad+1;
			}
		}
		return position;
	}
	
	
	
	public int buscarBinarioPorFechaDeNacimiento(String  crationDate ) {
		int position= -1;
		boolean encontro = false;
		int inicio = 0;
		int fin =pets.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(pets.get(mitad).getBirthDate().compareTo(crationDate)==0){
				position = mitad;
				encontro=true;
				
				
			}else if (pets.get(mitad).getBirthDate().compareTo(crationDate)>0) {
				fin = mitad-1;
				
			}else {
				inicio=mitad+1;
			}
		}
		return position;
	}
	
	
	public int buscarBinarioPorPetType(String  petType ) {
		int position= -1;
		boolean encontro = false;
		int inicio = 0;
		int fin =pets.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(pets.get(mitad).getPetType().compareTo(petType)==0){
				position = mitad;
				encontro=true;
				
				
			}else if (pets.get(mitad).getPetType().compareTo(petType)>0) {
				fin = mitad-1;
				
			}else {
				inicio=mitad+1;
			}
		}
		return position;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
}