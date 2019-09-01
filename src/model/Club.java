package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Club implements Comparable<Club>{
	
	
	private String id;
	private String name;
	private String creationdate;
	private String mascotsType;
	
	
	private ArrayList<Owner> owners;
	
	
	public Club(String id, String name, String creationdate, String mascotsType) {
		
		this.id = id;
		this.name = name;
		this.creationdate = creationdate;
		this.mascotsType = mascotsType;
		owners = new ArrayList<Owner>();
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
	
	
	
	
	

}
