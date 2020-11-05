package chocan;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		ProviderDatabase providerDatabase = new ProviderDatabase();
		
		//providerDatabase.deleteProvider("11880129");
		
		Provider Jared = new Provider();
		Jared.setCity("Oxford");
		Jared.setEmail("jtfolden@crimson.ua.edu");
		Jared.setIDNumber("11880129");
		Jared.setName("Jared Folden");
		Jared.setState("MI");
		Jared.setStreetAddress("34 Spring Lake Drive");
		Jared.setZip("48371");
		providerDatabase.addProvider(Jared);
		String[] providerID = providerDatabase.getAllProviderID();
		for (int i=0; i < providerID.length; i++) {
			System.out.println(providerID[i]);
		}
		
	}
	
}