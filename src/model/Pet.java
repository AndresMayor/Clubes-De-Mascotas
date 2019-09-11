package model;

import java.io.Serializable;
import java.util.Comparator;

public class Pet {
	
	
	

	
	
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
	
	private String id;
	private String name;
	private String birthDate;
	private String petType;
	private int gender;
	
	public Pet(String id, String name, String birthDate, String petType, int gender) {
	
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.petType = petType;
		this.gender = gender;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int compareID(Pet  mascot,Pet mascot2) {
		return mascot.getId().compareTo(mascot.getId());
	}
	
	public int compareNames(Pet mascot,Pet mascot2) {
		return mascot.getName().compareTo(mascot.getName());
	}
	
	public int compareBirthDay(Pet mascot) {
		return birthDate.compareTo(mascot.getBirthDate());
	}
	public int comparePetType(Pet mascot) {
		return petType.compareTo(mascot.getPetType());
	}
	public int compareGender(Pet mascot) {
		return gender-mascot.getGender();
	}
	
	
	

}
