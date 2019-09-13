package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import model.*;
class testOwner {

	
	
	private Owner owner;
	
	public void setupEscenario1() {
		//public Owner(String id, String names, String lastNames, String birthDate, String mascotsType) {

		owner = new Owner("12342", "Andres", "Mayor", "2001/02/20", "Perros");
		
	}
	
	@Test
	public void testAddPets() {
	
	//	public Pet(String id, String name, String birthDate, String petType, int gender) {

		setupEscenario1();
		Pet mascot1 = new Pet("423363335", "Danger", "2018/02/21", "pitbull", 1);
		Pet mascot2 = new Pet("7466445", "Rocky", "2017/02/21", "cat",2);
		
			owner.addPets(mascot1);
			owner.addPets(mascot2);
			
	
	}
	@Test
	public void testEliminatePet(){
		setupEscenario1();
		Pet mascot1 = new Pet("423363335", "Danger", "2018/02/21", "pitbull", 1);
		Pet mascot2 = new Pet("7466445", "Rocky", "2017/02/21", "cat",2);
		owner.addPets(mascot1);
		owner.addPets(mascot2);
		
		
		
		owner.eliminatePet("423363335");
		owner.eliminatePet("7466445");
		
		assertTrue(owner.getPets().size() == 0);
	}
	@Test
	public void testOrderPetsName(){
		setupEscenario1();
		Pet mascot1 = new Pet("423363335", "Danger", "2018/02/21", "pitbull", 1);
		Pet mascot2 = new Pet("7466445", "Rocky", "2017/02/21", "cat",2);
		owner.addPets(mascot1);
		owner.addPets(mascot2);
		
		
		
		owner.ortherdNamePet();
		for (int i=0;i<owner.getPets().size()-1;i++) {
			assertTrue(owner.getPets().get(i).getName().compareTo(owner.getPets().get(i+1).getName())<=0);
		}
		
	}
		
	

}
