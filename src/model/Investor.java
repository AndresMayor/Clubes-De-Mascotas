package model;

import java.util.ArrayList;

public class Investor {
	
	
	public static final String ARCHIVO_PLANO = "‎⁨Macintosh HD⁩ ▸ ⁨Usuarios⁩ ▸ ⁨andresmayor⁩ ▸ ⁨Escritorio⁩ ▸ ⁨CLUBPETS ▸clubs.txt⁩" ;
	public static final String ARCHIVO_SERIALIZABLE = "‎⁨Macintosh HD⁩ ▸ ⁨Usuarios⁩ ▸ ⁨andresmayor⁩ ▸ ⁨Escritorio⁩ ▸ ⁨CLUBPETS ▸ownerpet.txt⁩" ;
			
			
			
	private ArrayList<Club> clubs;
	
	
	
	public Investor() {
		
		clubs = new ArrayList<Club>();
	}
	public void addOwnerClub( Owner o1 , Club clu1) {
		boolean  diferent=false;
		for (int i =0;i<clubs.size()&& !diferent;i++) {
			if (clubs.get(i).equalOwner(o1)) {
				diferent=true;
				
			}
		}
		boolean equal =false;
		for (int i =0;i<clubs.size()&& !equal;i++) {
			if (clubs.get(i).getId().equals(clu1.getId())) {
				diferent=true;
				clubs.get(i).addOwner(o1);
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
	
	


}
