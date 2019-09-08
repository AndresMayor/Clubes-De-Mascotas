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

}
