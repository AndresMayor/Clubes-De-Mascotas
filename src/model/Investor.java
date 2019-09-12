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
	
	
	
	public Investor()  {
		
		clubs = new ArrayList<Club>();
		//loadData();
	}
	
	

	public void addOwnerClub( Owner o1 , String clu1) throws EqualObject {
		boolean  diferent=false;
		for (int i =0;i<clubs.size()&& !diferent;i++) {
			if (clubs.get(i).equalOwner(o1)) {
				diferent=true; 
				
			}
		}if(!diferent) {
		boolean equal =false;
		for (int i =0;i<clubs.size()&& !equal;i++) {
			if (clubs.get(i).getId().equals(clu1)) {
				
				clubs.get(i).getOwners().add(o1);
				diferent=true;
				
			}
		}
	}else {
		String msg = "Ya existe un dueno con esa informacion o el id del club es invalido";
		throw new EqualObject(msg);
	}
	}
	
	
	

	public ArrayList<Club> getClubs() {
    	return clubs;
    }
	
	
	
	public void addClub (Club club) {
		clubs.add(club);
	}
	
	
	
	
	
	
	//Metodos de ordenamiento
	public void clubOrtherID() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j-1).compareID(clubs.get(j))>0; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	
	
	
	
	public void clubBubbleName() {
		for (int i = 0; i < clubs.size()-1; i++) {
			Club menor = clubs.get(i);
			int cual = i;
			for (int j = i+1; j < clubs.size(); j++) {
				if(clubs.get(j).compareName(menor)<0) {
					menor = clubs.get(j);
					cual = j;
				}
				
			}
			Club tmp = clubs.get(i);
			clubs.set(i, menor);
			clubs.set(cual, tmp);
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
	
	
	
	public void clubOrtherMascotType() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j-1).comparePetType(clubs.get(j))>0; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
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
		String msg= "the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getId().equals(id) ) {
				diferent = true ;
				msg = "Se ha encontrado el club por medio del id en busqueda tradicional: "+clubs.get(i).getName();
				
			}
		}
		return msg;
		
	}
	public String busquedaTradName(String name) {
		String msg=" the club does not exist";
		boolean diferent =false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).getName().equals(name) ) {
				diferent = true;
				msg = "Se ha encontrado el club por busqueda Tradicional :" + clubs.get(i).getName()+"\n";
				
			}
		}
		return msg;
		
	}
	public String busquedaTradCreationDate(String creationDate) {
		String msg="the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getCreationdate().equals(creationDate)) {
				diferent = true ;
				msg= "Se ha encontrado el club por medio de la fecha de cracion por busqueda tradicional: "+clubs.get(i).getName();
			}
		}
		return msg;
		
	}
	public String busquedaTradMascotsType(String petMascot) {
		String msg="the club does not exist";
		boolean diferent = false;
		for (int i =0;i<clubs.size() && !diferent ;i++) {
			if( clubs.get(i).getMascotsType().equals(petMascot) ) {
				diferent = true ;
				msg= "Busqueda Tradicional. Se ha encontrado el club por el tipo mascotas: "+clubs.get(i).getName();
				
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
				msg = "Se ha encontrado el club por medio de la identificacion en busqueda binaria";	
				encontro=true;
				
				
			}else if (clubs.get(mitad).getId().compareTo(iD)>0) {
				fin = mitad-1;
			
				
			}else {
				inicio=mitad+1;
			
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
				msg = "se ha encontrado el club por medio del nombre en busqueda binaria ";	
				encontro=true;
				
				
			}else if (clubs.get(mitad).getName().compareTo(name)>0) {
				fin = mitad-1;
			
				
			}else {
				inicio=mitad+1;
			
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
				msg = "se ha encontrado el club por medio de la fecha de creacion por el metodo binario";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getCreationdate().compareTo(creationDate)>0) {
				fin = mitad-1;
				
				
			}else {
				inicio=mitad+1;
			
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
				msg = "Busqueda Binaria. Se ha encontrado el club por medio del tipo de mascotas";
				
				encontro=true;
				
				
			}else if (clubs.get(mitad).getMascotsType().compareTo(mascotType)>0) {
				fin = mitad-1;
				
				
			}else {
				inicio=mitad+1;
	
			}
		}
		return msg ;
	}
	//resposabilidades pet trad
	public String tradSearchNamePet(String n) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			if(clubs.get(i).tradSearchNamePet(n).equals("La(s) Mascota(s) con el nombre Indicado son: "));
			diferent=true;
		}
		return msg;
	}
	public String tradSearchIdPet(String id) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			if(clubs.get(i).tradSearchID(id).equals("Se ha encpntrado la mascota con el Id y su nombre es: "));
			diferent=true;
		}
		return msg;
	}
	public String tradSearchBirthDate(String creationDate) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			if(clubs.get(i).tradSearchBirtDate(creationDate).equals("La(s) Mascota(s) con la fecha de nacimiento son: "));
			diferent=true;
		}
		return msg;
	}
	public String tradSearchPetType(String petType) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			if(clubs.get(i).tradSearchPetType(petType).equals("La(s) Mascota(s) del  tipo   Indicado son: "));
			diferent=true;
		}
		return msg;
	}
	public String tradSearchGenderPet(int gender) {
		String msg ="";
		boolean diferent = false;
		
		for (int i =0;i<clubs.size() && !diferent ;i++ ) {
			if(clubs.get(i).tradSearchPetGender(gender).equals("La(s) Mascota(s) del  Genero  Indicado son: "));
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
		String msg = "the owner not exist";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).busquedaTradName(name).equals("La persona con el nombre incado es : "));
			diferent=true;
			msg ="Trad. Se ha encontrado el dueno por el nombre y esta en el club : "+clubs.get(i).getName();
		}
		return msg;
	}
	public String  tradSearchOwnerId(String id) {
		String msg = "the ownert";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).busquedaTradID(id).equals("Se ha encontrado el dueno con el Id y su nombre es: ")) {
			diferent=true;	
			msg ="Trad. Se ha encontrado el dueno por el ID y esta en el club : "+clubs.get(i).getName();
			
			
		}
		}
		return msg;
	}
	public String  tradSearchLastNamesOwner(String Lastname) {
		String msg = "the owner not exist";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).busquedaTradLastNames(Lastname).equals("La persona con el apellido  incado es : ")) {
				
			
			diferent=true;
			msg ="Trad. Se ha encontrado el dueno por Los Apellidos y esta en el club : "+clubs.get(i).getName();
			}
		}
		return msg;
	}
	public String  tradSearchBirthDateOwner(String creationDate) {
		String msg = "the owner not exist";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).busquedaTradBirthDate(creationDate).equals("La persona con la fecha de naciemiento incada es : ")) {
				
			
			diferent=true;
			msg ="Trad. Se ha encontrado el dueno por la fecha de nacimiento y esta en el club : "+clubs.get(i).getName();
			}
		}
		return msg;
	}
	public String  tradSearchPetTypeOwner(String petType) {
		String msg = "the owner not exist";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).busquedaTradOwnerMascotType(petType).equals("El tipo de mascota que prefiere(n) el(los) dueno(s) es (son) : ")) {
				
			
			diferent=true;
			msg ="Trad. Se ha encontrado el dueno por el tipo de mascotas y esta en el club : "+clubs.get(i).getName();
			}
		}
		return msg;
	}
	//Responsabilidades owner binario
	public String binaSearchOwnerNames(String names) {
		boolean diferent = false;
		
		String msg="the owner not exist";
		
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			if( clubs.get(i).buscarBinarioPorOwnerName(names).equals("Bina.Se ha encontarado el dueno por medio del nombre indicado")) {
				
				msg="Bina.Se ha encontarado el dueno por medio del nombre indicado";
			diferent=true;
		
			}
		}
		return msg;
	}
	public String binaSearchOwnerId(String id) {
		boolean diferent = false;
		String msg="the owner not exist";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			if(clubs.get(i).buscarBinarioOwnerId(id).equals("Bin.se ha encontrado el dueno por medio de la identificacion")) {
				
			msg="Bin.se ha encontrado el dueno por medio de la identificacion";
			diferent=true;
			
			}
		}
		return msg;
	}
	public String binaSearchOwnerLastNames(String lastnames) {
		boolean diferent = false;
		String msg="the owner not exist";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			if(clubs.get(i).buscarBinarioOwnerLastName(lastnames).equals("Bin. Se ha encontarado el dueno por medio del los apellidos indicados")) {
				
			msg="Bin. Se ha encontarado el dueno por medio del los apellidos indicados";
			diferent=true;
			
			}
		}
		return msg;
	}
	public String binaSearchOwnerBirthDate(String creationDate) {
		boolean diferent = false;
		String msg="the owner not exist";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			if(clubs.get(i).buscarBinarioOwnerBirthDate(creationDate).equals("Bin. Se ha encontarado el dueno por medio de la fecha de nacimiento indicada")) {
				
			
			diferent=true;
			msg="Bin Se ha encontarado el dueno por medio de la fecha de nacimiento indicada";
		}
		}
		return msg;
	}
	
	public String binaSearchOwnerPetType(String macotType) {
		boolean diferent = false;
		String msg="the owner not exist";
		for(int i =0;i<clubs.size() &&!diferent ;i++) {
			if( clubs.get(i).buscarBinarioOwnerMascotType(macotType).equals("Bin. Se ha encontrado la preferencia del tipo de mascota del dueno")) {
				
			
			diferent=true;
			msg="Bin. Se ha encontrado la preferencia del tipo de mascota del dueno";
		}
		}
		return msg;
	}
	
	//eliminate club 
	

	
	//	public Club(String id, String name, String creationdate, String mascotsType) 
	
	public void init() {
		Club club1 = new Club("1929383929","Aranzazu","2017/03/20","Dogs");
		Club club2 = new Club("1233383929","Arcas","2016/07/10","cats");
		Club club3 = new Club("2344322324","Kahlua","2019/09/09","Dogs");
		Club club4 = new Club("1","Kaiser","2014/11/23","conejos");
		clubs.add(club1);
		clubs.add(club2);
		clubs.add(club3);
		clubs.add(club4);
		
	}
	//responseliminateowner
	
	public String  eliminateOwners(String id) {
		String msg = "No existe el dueno";
		boolean diferent = false;
		for (int i=0;i<clubs.size() && !diferent ;i++) {
			if(clubs.get(i).eliminateOwner(id).equals("Se ha eliminado el dueno")) {
				
				msg = "Se ha eliminado el dueno";
				diferent=true;
			}
		}
		return msg;
	}
	public String eliminateClub(String id) {
		String msg ="El Id del club no existe";
		boolean diferent =false;
		for (int i=0;i<clubs.size() && !diferent;i++ ) {
			if (clubs.get(i).getId().equals(id)){
			   clubs.remove(i);
			   msg ="Se ha eliminado el club";
			   diferent=true;
			}
		}
		return msg;
	}
	public String eliminatePet(String id) {
		String msg ="El Id de la mascota  no existe";
		boolean diferent =false;
		for (int i=0;i<clubs.size() && !diferent;i++ ) {
			if (clubs.get(i).eliminatePet(id).equals("Se ha eliminado la mascota")){
			   clubs.remove(i);
			   msg ="Se ha eliminado el La mascota";
			   diferent=true;
			}
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Responsabilidades de Orden Pet
	
	public void ortherdtNamesPet() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherdtNamesPet();
		}
	}
	public void ortherdID() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherdID();;
		}
	}
	public void ortherdGenderPet() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherdGenderPet();;
		}
	}
	public void ortherdBirthDay() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherdBirthDay();
		}
	}
	public void ortherdMascotsType() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherdMascotsType();
		}
	}
	
	
	
	//Responsabilidades de ordenamiento de owner
	public void ortherBubbleOwnerNames() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherBubbleOwnerName();
		}
	}
	public void ortherBubbleOwnerLastName() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherBubbleOwnerLastName();
		}
	}
	public void ortherBubbleOwnerID(){
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherBubbleOwnerID();
		}
	}
	public void ortherBubbleOwnerMascost(){
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherOwnerMascost();
		}
	}
	public void ortherInsercionOwnerBirthDay(){
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ortherInsercionOwnerBirthDay();
		}
	}
	
	
	public void addPets(Pet mascots, String idOwner) {
		boolean equal =false;
		for(int i=0; i<clubs.size() && !equal ; i++) {
			if(clubs.get(i).getOwners().get(i).getId().equals(idOwner)) {
				clubs.get(i).addPets(mascots, idOwner);
				equal=true;
			}
		}
	}
}
	
	
	
	
	
	
	


