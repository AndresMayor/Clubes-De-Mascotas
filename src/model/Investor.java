package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Investor {
	
	
	public static final String ARCHIVO_PLANO = "‎⁨Macintosh HD⁩ ▸ ⁨Usuarios⁩ ▸ ⁨andresmayor⁩ ▸ ⁨Escritorio⁩ ▸ ⁨CLUBPETS▸archivosapoII.csv" ;
	
			
			
			
	private ArrayList<Club> clubs;
	
	
	
	public Investor() throws ClassNotFoundException, IOException {
		
		clubs = new ArrayList<Club>();
		loadData();
	}
	
	

	public void addOwnerClub( Owner o1 , String clu1) {
		boolean  diferent=false;
		for (int i =0;i<clubs.size()&& !diferent;i++) {
			if (clubs.get(i).equalOwner(o1)) {
				diferent=true;
				
			}
		}
		boolean equal =false;
		for (int i =0;i<clubs.size()&& !equal;i++) {
			if (clubs.get(i).getId().equals(clu1)) {
				diferent=true;
				clubs.get(i).addOwner(o1);
			}
		}
		
	}

	public ArrayList<Club> getClubs() {
    	return clubs;
    }
	
	public void addClub (Club club) {
		
		boolean diferent = false;
		for (int i =0;i<clubs.size()&& !diferent ;i++) {
			if (clubs.get(i).compareID(club)==0){
				diferent=true;
			}
			if (!diferent){
				clubs.add(club);
				
			}
		}
	}
	
	//Metodos de ordenamiento
	public void clubInsercionID() {
		for (int i =0;i<clubs.size()-1;i++) {
			Club  p = clubs.get(i);
			int cual = i;
			for (int j = i+1;j<clubs.size();j++) {
				if (p.compareID(clubs.get(j))>0) {
				p =clubs.get(j);
				cual = j ;
				}
			}
		}
	}
	
	
	
	
	public void clubBubbleName() {
	for (int i =0;i<clubs.size();i++) {
		for (int j =1;j>0;j--) {
			if(clubs.get(j-1).compareName(clubs.get(j))>0){
				
				Club temp= clubs.get(j);
				clubs.set(j, clubs.get(j+1));
				clubs.set(j+1,temp);
				
			}
		}
	}
}
	
	public void clubsOtheredComparatioDate() {
		for (int i =0;i<clubs.size();i++) {
			for (int j =0;j<clubs.size()-1-i;j++) {
				if(clubs.get(j).compareCreacionDate(clubs.get(j+1))>0){
					
					Club temp= clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1,temp);
					
				}
			}
		}
	}
	
	
	
	public void clubInsercionMascotType() {
		for (int i =0;i<clubs.size()-1;i++) {
			Club  p = clubs.get(i);
			int cual = i;
			for (int j = i+1;j<clubs.size();j++) {
				if (p.comparePetType(clubs.get(j))>0) {
				p =clubs.get(j);
				cual = j ;
				}
			}
		}
	}
	
	public void saveData() throws  FileNotFoundException ,IOException{
		for (int i =0;i<clubs.size();i++) {
			clubs.get(i).saveData();
			
		}
		
	}
	
	public void loadData() throws IOException, ClassNotFoundException{
		File file = new File (ARCHIVO_PLANO);
		BufferedReader lector = new BufferedReader(new FileReader(file));
		String line;
		while((line=lector.readLine())!=null) {
			if(!line.equals("id,name,creationdate,mascotsType")) {
			String[] array = line.split(",");
			Club e =new Club(array[0],array[1],array[2],array[3]);
			clubs.add(e);
			
			
		}
	}
	lector.close();
	
	}
	//Metodos de Busqueda Tradicional
	public String busquedaTradID(String id) {
		String msg="the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getId().equals(id) ) {
				msg= "Se ha encontrado el club por medio del id : "+clubs.get(i).getName();
				diferent = true ;
			}
		}
		return msg;
		
	}
	public String busquedaTradName(String name) {
		String msg="the club does not exist";
		
		for (int i =0;i<clubs.size()  ;i++) {
			if(clubs.get(i).getName().equals(name) ) {
				msg += "Se ha encontrado el club  : ";
				msg += clubs.get(i).getName()+"\n";
				
			}
		}
		return msg;
		
	}
	public String busquedaTradCreationDate(String creationDate) {
		String msg="the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getCreationdate().equals(creationDate)) {
				msg= "Se ha encontrado el club por medio de la fecha de cracion: "+clubs.get(i).getName();
				diferent = true ;
			}
		}
		return msg;
		
	}
	public String busquedaTradMascotsType(String petMascot) {
		String msg="the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getMascotsType().equals(petMascot) ) {
				msg= "Se ha encontrado el club por medio de las mascotas"+clubs.get(i).getName();
				diferent = true ;
			}
		}
		return msg;
		
	}
	//Metodos de busqueda Binaria 
	
	public String buscarBinarioClubId(String  iD ) {
		String  msg = "the club does not exist";
		boolean encontro = false;
		int inicio = 0;
		int fin =clubs.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(clubs.get(mitad).getId().compareTo(iD)==0){
				msg = "se ha encontrado el club por medio de la identificacion";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getId().compareTo(iD)>0) {
				fin = mitad-1;
				msg ="se ha encontrado el club por medio de la identificacion";
				
			}else {
				inicio=mitad+1;
				msg ="se ha encontrado el club por medio de la identificacion";
			}
		}
		return msg ;
	}
	
	
	public String buscarBinarioClubName(String  name ) {
		String  msg = "the club does not exist";
		boolean encontro = false;
		int inicio = 0;
		int fin =clubs.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(clubs.get(mitad).getName().compareTo(name)==0){
				msg = "se ha encontrado el club por medio del nombre";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getName().compareTo(name)>0) {
				fin = mitad-1;
				msg ="se ha encontrado el club  por medio del nombre ";
				
			}else {
				inicio=mitad+1;
				msg ="se ha encontrado el club  por medio del nombre ";
			}
		}
		return msg ;
	}
	

	public String buscarBinarioClubCreationDate(String  creationDate ) {
		String  msg = "the club does not exist";
		boolean encontro = false;
		int inicio = 0;
		int fin =clubs.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(clubs.get(mitad).getCreationdate().compareTo(creationDate)==0){
				msg = "se ha encontrado el club por medio de la fecha de creacion";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getCreationdate().compareTo(creationDate)>0) {
				fin = mitad-1;
				msg ="se ha encontrado el club  por medio de la fecha de creacion  ";
				
			}else {
				inicio=mitad+1;
				msg ="se ha encontrado el club  por de la fecha de creacion ";
			}
		}
		return msg ;
	}
	

	public String buscarBinarioClubMascorType(String  mascotType ) {
		String  msg = "the club does not exist";
		boolean encontro = false;
		int inicio = 0;
		int fin =clubs.size()-1;
		
		while (inicio<=fin&& !encontro) {
			int mitad = (inicio+fin)/2;
			if(clubs.get(mitad).getMascotsType().compareTo(mascotType)==0){
				msg = "se ha encontrado el club por medio del tipo de mascotas";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getMascotsType().compareTo(mascotType)>0) {
				fin = mitad-1;
				msg ="se ha encontrado el club  por medio del tipo de mascota ";
				
			}else {
				inicio=mitad+1;
				msg ="se ha encontrado el club  por medio del tipo de mascota ";
			}
		}
		return msg ;
	}
	//resposabilidades pet trad
	public String tradSearchNamePet(String n) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			msg=clubs.get(i).tradSearchNamePet(n);
			diferent=true;
		}
		return msg;
	}
	public String tradSearchIdPet(String id) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			msg=clubs.get(i).tradSearchID(id);
			diferent=true;
		}
		return msg;
	}
	public String tradSearchBirthDate(String creationDate) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			msg=clubs.get(i).tradSearchBirtDate(creationDate);
			diferent=true;
		}
		return msg;
	}
	public String tradSearchPetType(String petType) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			msg=clubs.get(i).tradSearchPetType(petType);
			diferent=true;
		}
		return msg;
	}
	public String tradSearchGenderPet(int gender) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			msg=clubs.get(i).tradSearchPetGender(gender);
			diferent=true;
		}
		return msg;
	}
	
	//Responsabilidades pet Binario
	public boolean binaSearchNameMascot(String name) {
		boolean diferent = false;
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			diferent= clubs.get(i).binSearchNamePet(name);
			
		}
		return diferent;
	}
	public boolean binaSearcIdPet(String id) {
		boolean diferent = false;
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			diferent= clubs.get(i).binSearchID(id);
			
		}
		return diferent;
	}
	public boolean binaSearchBirthDate(String creationDate) {
		boolean diferent = false;
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			diferent= clubs.get(i).binSearchBirthDate(creationDate);
			
		}
		return diferent;
	}
	public boolean binaSearchPetType(String petType) {
		boolean diferent = false;
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			diferent= clubs.get(i).binSearchPetType(petType);
			
		}
		return diferent;
	}
	public boolean binaSearchGender(int gender) {
		boolean diferent = false;
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			diferent= clubs.get(i).binSearchPetGender(gender);
			
		}
		return diferent;
	}
	//Responsabilidades de Owner trad
	public String  tradSearchNameOwner(String name) {
		String msg = "";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			msg = clubs.get(i).busquedaTradName(name);
			diferent=true;
		}
		return msg;
	}
	public String  tradSearchOwnerId(String id) {
		String msg = "";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			msg = clubs.get(i).busquedaTradID(id);
			diferent=true;
		}
		return msg;
	}
	public String  tradSearchLastNamesOwner(String Lastname) {
		String msg = "";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			msg = clubs.get(i).busquedaTradLastNames(Lastname);
			diferent=true;
		}
		return msg;
	}
	public String  tradSearchBirthDateOwner(String creationDate) {
		String msg = "";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			msg = clubs.get(i).busquedaTradBirthDate(creationDate);
			diferent=true;
		}
		return msg;
	}
	public String  tradSearchPetTypeOwner(String petType) {
		String msg = "";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			msg = clubs.get(i).busquedaTradOwnerMascotType(petType);
			diferent=true;
		}
		return msg;
	}
	//Responsabilidades owner binario
	public String binaSearchOwnerNames(String names) {
		boolean diferent = false;
		String msg="";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			msg= clubs.get(i).buscarBinarioPorOwnerName(names);
			diferent=true;
		}
		return msg;
	}
	public String binaSearchOwnerId(String id) {
		boolean diferent = false;
		String msg="";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			msg= clubs.get(i).buscarBinarioOwnerId(id);
			diferent=true;
		}
		return msg;
	}
	public String binaSearchOwnerLastNames(String lastnames) {
		boolean diferent = false;
		String msg="";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			msg= clubs.get(i).buscarBinarioOwnerLastName(lastnames);
			diferent=true;
		}
		return msg;
	}
	public String binaSearchOwnerBirthDate(String creationDate) {
		boolean diferent = false;
		String msg="";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			msg= clubs.get(i).buscarBinarioOwnerBirthDate(creationDate);
			diferent=true;
		}
		return msg;
	}
	public String binaSearchOwnerPetType(String macotType) {
		boolean diferent = false;
		String msg="";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			msg= clubs.get(i).buscarBinarioOwnerMascotType(macotType);
			diferent=true;
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	

}
