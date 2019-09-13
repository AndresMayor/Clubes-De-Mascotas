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
	
	
	
	public Club(String id, String name, String creationdate, String mascotsType)  {
		
		this.id = id;
		this.name = name;
		this.creationdate = creationdate;
		this.mascotsType = mascotsType;
		owners = new ArrayList<Owner>();
		if(!new File(id).exists()) {
			try {
				new File(id).createNewFile();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}try {
			loadData();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException x) {
			x.printStackTrace();
		}catch(IOException v) {
			v.printStackTrace();
		}
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

	
	/*public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(id + ".csv");
		BufferedReader breader = new BufferedReader(new FileReader(file));
		String line;
		File f1 = new File(id);
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream(f1));
		try {
			//String id, String names, String lastNames, String birthDate, String mascotsType,//String id, String name, String birthDate, String petType, int gender
			while((line = breader.readLine()) != null) {
				if(!line.equals("name,lastName,id,birth,typPet,idPet,namePet,bithPet,petType,gender")) {
					String[] s = line.split(",");
					Owner o = new Owner(s[2], s[0], s[1], s[3], s[4]);
					//Pet np = new Pet(s[5],s[6],s[7],s[8],Integer.parseInt(s[9]));
				
					//o.addPets(np);
					owners.add(o);
					object.writeObject(o);
				}
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		object.close();
		breader.close();
	}*/
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(id);
		ObjectInputStream object = new ObjectInputStream(new FileInputStream(file));
		Owner aux = (Owner)object.readObject();
		try {
			while(aux != null) {
				owners.add(aux);
				aux = (Owner)object.readObject();
			}
		} catch(Exception e) {
			
		}
		object.close();
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
			for (int i = 1; i < owners.size(); i++) {
				for (int j = i; j > 0 && owners.get(j-1).compareID(owners.get(j))>0; j--) {
					Owner tmp = owners.get(j);
					owners.set(j, owners.get(j-1));
					owners.set(j-1, tmp);
				}
			}
		}
	

		public void ortherBubbleOwnerName() {
			for (int i = 0; i < owners.size()-1; i++) {
				Owner o1 = owners.get(i);
				int cual = i;
				for (int j = i+1; j < owners.size(); j++) {
					if(owners.get(j).compareNames(o1)<0) {
						o1 = owners.get(j);
						cual = j;
					}
					
				}
				Owner tmp = owners.get(i);
				owners.set(i, o1);
				owners.set(cual, tmp);
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
			
			
			public void ortherOwnerMascost() {
				for (int i = 0; i < owners.size()-1; i++) {
					Owner menor = owners.get(i);
					int cual = i;
					for (int j = i+1; j < owners.size(); j++) {
						if(owners.get(j).comparePetType(menor)<0) {
							menor = owners.get(j);
							cual = j;
						}
						
					}
					Owner tmp = owners.get(i);
					owners.set(i, menor);
					owners.set(cual, tmp);
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
			
			
			
			
			
			
			//Metodos de Busqueda Tradicional
			
			
			
			public String busquedaTradID(String id) {
				String msg="the owner does not exist";
				boolean diferent = false;
				for (int i =0;i<owners.size() && !diferent ;i++) {
					if( owners.get(i).getId().equals(id) ) {
						diferent = true ;
						msg= "Se ha encontrado el dueno con el Id y su nombre es: ";
						
						
					}
				}
				return msg;
				
			}
			public String busquedaTradName(String name) {
				String msg="the owner does not exist";
				
				for (int i =0;i<owners.size()  ;i++) {
					if(owners.get(i).getNames().equals(name) ) {
						msg = "La persona con el nombre incado es : ";
						//msg += owners.get(i).getNames()+"\n";
						
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
						encontro=true;
						msg = "Bina.Se ha encontarado el dueno por medio del nombre indicado";
						
						
						
						
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
						msg = "Bin.se ha encontrado el dueno por medio de la identificacion";
						
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
						msg = "Bin. Se ha encontrado la preferencia del tipo de mascota del dueno";
						
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
				String  msg = "the owner not exist";
				boolean encontro = false;
				int inicio = 0;
				int fin =owners.size()-1;
				
				while (inicio<=fin&& !encontro) {
					int mitad = (inicio+fin)/2;
					if(owners.get(mitad).getId().compareTo(iD)==0){
						
						msg = "Bin.se ha encontrado el dueno por medio de la identificacion";
						
						encontro=true;
						
						
					}else if (owners.get(mitad).getId().compareTo(iD)>0) {
						fin = mitad-1;
						msg = "Bin.se ha encontrado el dueno por medio de la identificacion";
				
			
						
					}else {
						inicio=mitad+1;
						msg = "Bin.se ha encontrado el dueno por medio de la identificacion";
						
						
					}
				}
				return msg ;
			}
			
			//responsabilidades pet trad 
			public String  tradSearchNamePet(String name) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if(owners.get(i).busquedaTradName(name).equals("La(s) Mascota(s) con el nombre Indicado son: "));
					diferent=true;
				}
				return msg;
			}
			
			public String  tradSearchID(String id) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if(owners.get(i).busquedaTradID(id).equals("Se ha encpntrado la mascota con el Id y su nombre es: "));
					diferent=true;
				}
				return msg;
			}
			public String  tradSearchBirtDate(String birthDate) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if(owners.get(i).busquedaTradBirthDate(birthDate).equals("La(s) Mascota(s) con la fecha de nacimiento son: "));
					diferent=true;
				}
				return msg;
			}
			public String  tradSearchPetType(String petType) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if( owners.get(i).busquedaTradPettype(petType).equals("La(s) Mascota(s) del  tipo   Indicado son: "));
					diferent=true;
				}
				return msg;
			}
		
			
					
			public String  tradSearchPetGender(int gender) {
				String msg = "";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if(owners.get(i).busquedaTradGender(gender).equals("La(s) Mascota(s) del  Genero  Indicado son: "));
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
			
			//eliminateOwner
			
			public String eliminateOwner(String id) {
				String msg ="El Id del dueno no existe";
				boolean diferent =false;
				for (int i=0;i<owners.size() && !diferent;i++ ) {
					if (owners.get(i).getId().equals(id)){
					   owners.remove(i);
					   msg ="Se ha eliminado el dueno";
					   diferent=true;
					}
				}
				return msg;
			}
			
			//elimanteRespoPet
			public String  eliminatePet(String id) {
				String msg = "No existe la mascota";
				boolean diferent = false;
				for (int i=0;i<owners.size() && !diferent ;i++) {
					if(owners.get(i).eliminatePet(id).equals("Se ha eliminado la mascota")) {
						
						msg = "Se ha eliminado la mascota";
						diferent=true;
					}
				}
				return msg;
			}
			
			
			
			
			
			
			//Responsabilidades de Ordenamiento de pets
			
			
			public void ortherdtNamesPet() {
				for (int i = 0; i < owners.size(); i++) {
					owners.get(i).ortherdNamePet();;
				}
			}
			public void ortherdID() {
				for (int i = 0; i < owners.size(); i++) {
					owners.get(i).ortherdID();;
				}
			}
			public void ortherdGenderPet() {
				for (int i = 0; i < owners.size(); i++) {
					owners.get(i).ortherdGenderPet();;
				}
			}
			public void ortherdBirthDay() {
				for (int i = 0; i < owners.size(); i++) {
					owners.get(i).ortherdBirthDay();
				}
			}
			public void ortherdMascotsType() {
				for (int i = 0; i < owners.size(); i++) {
					owners.get(i).ortherdMascotsType();
				}
			}



			@Override
			public String toString() {
				return "Club [id=" + id + ", name=" + name + ", creationdate=" + creationdate + ", mascotsType="
						+ mascotsType + ", owners=" + owners + "]";
			}
			
			
			
			
			public void addPets(Pet p, String idOwner) {
				boolean founded = false;
				for(int i=0; i < owners.size() && !founded; i++) {
					if(owners.get(i).getId().equals(idOwner)) {
						founded = true;
						owners.get(i).addPets(p);
					}
				}
			}
			
			
			
			
			
			}
		
			
			
			
		
			
			

			
			
			
			

			
			
	
			

	

		
