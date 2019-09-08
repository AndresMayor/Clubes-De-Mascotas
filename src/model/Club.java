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
			
			
			
			

			
			
			
			

			
			
	
			

	
}
		
