package chocan;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class to manage the provider database
 * @author Jared Folden
 *
 */
public class ProviderDatabase {
	
	private LinkedList<Provider> providers;
	
	/**
	 * Constructor for the provider database
	 * @throws FileNotFoundException when the provider database .csv file cannot be found
	 */
	public ProviderDatabase() throws FileNotFoundException {
		
		providers = new LinkedList<Provider>(); // Creating the providers linked list
		File database = new File("ProviderDatabase.csv"); //Opening the .csv file
		
		Scanner reader = new Scanner(database); // Created the scanner object to read the file
		
		
		while(reader.hasNextLine()) { // While there are still more providers
			String providerDataLine = reader.nextLine(); //Read the whole line of data
			String[] providerData = providerDataLine.split(",", 0); // Split line into an array along the tabs since it is a tab delimited
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
			
			providers.add(provider); // Adding to database
			
		}
		
		reader.close(); // Closing the reader object
	}
	
	/**
	 * Private method used to rewrite the ProviderDatabase.csv file whenever a change is made
	 * @throws IOException
	 */
	private void updateDatabase() throws IOException {
		File database = new File("ProviderDatabase.csv"); // Opening the .csv file
		FileWriter writer = new FileWriter(database, false); // Creating the writer object
		
		ListIterator<Provider> listIterator = providers.listIterator(); //Creating a list iterator to go through the providers linked list
		while (listIterator.hasNext()) { // While there are still providers
			Provider current = listIterator.next();
			// This will create a tab delimited list in the proper order
			writer.write(current.getName() + ",");
			writer.write(current.getIDNumber() + ",");
			writer.write(current.getEmail() + ",");
			writer.write(current.getStreetAddress() + ",");
			writer.write(current.getCity() + ",");
			writer.write(current.getState() + ",");
			writer.write(current.getZip() + "\n");
		}
		writer.close(); // Closing the writer object
	}
	
	/**
	 * Used to request a provider
	 * @param id, the id of the provider being requested
	 * @return the provider object if the provider exists, 
	 * @return returns an empty provider object with the name "Provider not found" if the provider does not exist
	 * @throws Exception
	 */
	public Provider getProvider(String id) throws Exception{
		
		ListIterator<Provider> listIterator = providers.listIterator(); // Creating list iterator object
		while (listIterator.hasNext()) { // While there are still providers
			Provider current = listIterator.next();
			if(current.getIDNumber().equals(id)) { //Check if that provider has the desired id
				return current; // Return if it does
			}
		}
		
		// THIS WILL ONLY HAPPEN IF THE PROVIDER WAS NOT FOUND. OTHERWISE, THE FUNCTION WOULD HAVE RETURNED BY NOW
		Provider dummyProvider = new Provider(); 
		dummyProvider.setName("Provider not found");
		return dummyProvider;
	}
	
	/**
	 * Used to add a provider to database
	 * @param newProvider, provider object of provider to be added
	 * @throws IOException
	 */
	public void addProvider(Provider newProvider) throws IOException {
		
		providers.add(newProvider);//Adding provider to linked list
		updateDatabase(); //Rewriting .csv file with new provider
		
	}
	
	/**
	 * Used to delete a provider from database
	 * @param id, the id of the provider to be deleted
	 * @throws Exception
	 */
	public void deleteProvider(String id) throws Exception{
		
		ListIterator<Provider> listIterator = providers.listIterator(); //Creating list iterator
		while (listIterator.hasNext()) {//While more providers still
			Provider current = listIterator.next();
			if(current.getIDNumber().equals(id)) { //If provider has the desired id
				providers.remove(current); //Removing provider
				break;
			}
		}
		
		updateDatabase(); // Rewriting .csv
	}
	
	/**
	 * Replaces a provider
	 * @param id, id of provider to be updated
	 * @param provider
	 * @throws Exception
	 */
	public void updateProvider(String id, Provider provider) throws Exception{
		
		deleteProvider(id); //Deleting previous instance of provider
		addProvider(provider); //Adding new instance
	
	}
	
	/**
	 * Used to get a list of all the provider IDs
	 * @return a string array of all the provider IDs
	 * @throws Exception
	 */
	public String[] getAllProviderID() throws Exception{
		
		ListIterator<Provider> listIterator = providers.listIterator();//Creating list iterator
		int size = providers.size(); //Getting the size of the providers linked list
		String providerID[] = new String[size]; //Creating a string array the size of the provider list
		while (listIterator.hasNext()) { //While more providers still
			Provider current = listIterator.next();
			providerID[providers.indexOf(current)] = current.getIDNumber(); //Adding their id to the linked list
		}
		
		return providerID;
		
		
	}
	
	/**
	 * Used to find is a particular Provider exists by ID number
	 * @param id 
	 * @return a boolean returning true if found
	 */
	public Boolean searchProvider(String id) {
		
		ListIterator<Provider> listIterator = providers.listIterator();//Creating list iterator
		while (listIterator.hasNext()) { //While more providers still
			Provider current = listIterator.next();
			if(current.getIDNumber().equals(id)) {
				return true;
			} 
		}
		return false;
	}
	
	
}