package chocan;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		ProviderDatabase providerDatabase = new ProviderDatabase();
		
		System.out.println(providerDatabase.getProvider("11880129").getName());
		System.out.println(providerDatabase.getProvider("11880129").getIDNumber());
		System.out.println(providerDatabase.getProvider("11880129").getStreetAddress());
		System.out.println(providerDatabase.getProvider("11880129").getCity());
		System.out.println(providerDatabase.getProvider("11880129").getState());
		System.out.println(providerDatabase.getProvider("11880129").getZip());
		System.out.println(providerDatabase.getProvider("11880129").getEmail());
		
	}
	
}