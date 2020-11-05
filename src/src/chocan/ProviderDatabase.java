package chocan;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ProviderDatabase {
	
	private LinkedList<Provider> providers;
	
	public ProviderDatabase() throws FileNotFoundException {
		
		providers = new LinkedList<Provider>();
		File database = new File("ProviderDatabase.csv");
		
		Scanner reader = new Scanner(database);
		
		
		while(reader.hasNextLine()) {
			String providerDataLine = reader.nextLine();
			String[] providerData = providerDataLine.split("\t", 0);
			// 0 = name
			// 1 = IDNumber
			// 2 = email
			// 3 = streetAddress
			// 4 = city
			// 5 = state
			// 6 = zip
			Provider provider = new Provider();
			provider.setName(providerData[0]);
			provider.setIDNumber(providerData[1]);
			provider.setEmail(providerData[2]);
			provider.setStreetAddress(providerData[3]);
			provider.setCity(providerData[4]);
			provider.setState(providerData[5]);
			provider.setZip(providerData[6]);
			
			providers.add(provider);
			
		}
		
		reader.close();
	}
	
	private void updateDatabase() throws IOException {
		File database = new File("ProviderDatabase.csv");
		FileWriter writer = new FileWriter(database, false);
		
		ListIterator<Provider> listIterator = providers.listIterator();
		while (listIterator.hasNext()) {
			Provider current = listIterator.next();
			writer.write(current.getName() + "\t");
			writer.write(current.getIDNumber() + "\t");
			writer.write(current.getEmail() + "\t");
			writer.write(current.getStreetAddress() + "\t");
			writer.write(current.getCity() + "\t");
			writer.write(current.getState() + "\t");
			writer.write(current.getZip() + "\n");
		}
		writer.close();
	}
	
	public Provider getProvider(String id) throws Exception{
		
		ListIterator<Provider> listIterator = providers.listIterator();
		while (listIterator.hasNext()) {
			Provider current = listIterator.next();
			if(current.getIDNumber().equals(id)) {
				return current;
			}
		}
		
		Provider dummyProvider = new Provider();
		dummyProvider.setName("Provider not found");
		return dummyProvider;
	}
	
	public void addProvider(Provider newProvider) {
		
		providers.add(newProvider);
		
	}
	
}