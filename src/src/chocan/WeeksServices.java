package chocan; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * Class for services list
 * @author Jake Bischoff
 *
 */
public class WeeksServices {
	
	private LinkedList<ServicePerformed> weeksServices;
	
	/**
	 * Constructor for services list
	 * @throws FileNotFoundException
	 */
	public WeeksServices() throws FileNotFoundException {
		
		File database = new File("WeeksServicesDatabase.csv"); //Opening the .csv file
		
		
		weeksServices = new LinkedList<ServicePerformed>();
		Scanner reader = new Scanner(database); // Created the scanner object to read the file
		
		
		while(reader.hasNextLine()) { 
			String ServiceDataLine = reader.nextLine(); //Read the whole line of data
			if (ServiceDataLine.equals("\n")) {
				break;
			}
			String[] ServiceData = ServiceDataLine.split(",", 0); // Split line into an array along the commas since it is a comma delimited
			// 0 = currDateAndTime
			// 1 = dateProvided
			// 2 = providerNumber
			// 3 = memberNumber
			// 4 = serviceCode
			// 5 = comments
			ServicePerformed serviceInput = new ServicePerformed();
			serviceInput.setCurrDateAndTime(ServiceData[0]);
			serviceInput.setDateProvided(ServiceData[1]);
			serviceInput.setProviderNumber(ServiceData[2]);
			serviceInput.setMemberNumber(ServiceData[3]);
			serviceInput.setServiceCode(ServiceData[4]);
			serviceInput.setComments(ServiceData[5]);

			
			weeksServices.add(serviceInput); // Adding to database
			
		}
		
		reader.close(); // Closing the reader object
		
	}
	
	
	private void updateDatabase() throws IOException {
		File database = new File("WeeksServicesDatabase.csv"); // Opening the .csv file
		FileWriter writer = new FileWriter(database, false); // Creating the writer object
		
		ListIterator<ServicePerformed> listIterator = weeksServices.listIterator(); //Creating a list iterator to go through the Members linked list
		while (listIterator.hasNext()) { // While there are still Members
			ServicePerformed current = listIterator.next();
			// This will create a tab delimited list in the proper order
			writer.write(current.getCurrDateAndTime() + ",");
			writer.write(current.getDateProvided() + ",");
			writer.write(current.getProviderNumber() + ",");
			writer.write(current.getMemberNumber() + ",");
			writer.write(current.getServiceCode() + ",");
			writer.write(current.getComments() + "\n");

		}
		writer.close(); // Closing the writer object
	}
	
	/**
	 * Adds a service to the list
	 * @param service, service to be added to the list
	 * @throws IOException
	 */
	public void addService(ServicePerformed service) throws IOException {
		weeksServices.add(service);
		updateDatabase();
	}
	
	/**
	 * Deletes a service from the list
	 * @param service, service to be deleted from the list
	 * @throws IOException
	 */
	public void deleteService(ServicePerformed service) throws IOException {
		if(weeksServices.remove(service)) {
			updateDatabase();
		}
	}
	
	/**
	 * Returns a list of services from a certain provider
	 * @param id, the id of the provider 
	 * @return ServicesPerformed[], list of services from the provider
	 */
	public ServicePerformed[] getServicesByProvider(String id) {
		
		ListIterator<ServicePerformed> iterator = weeksServices.listIterator();
		ServicePerformed servicePerformed = new ServicePerformed();
		
		LinkedList<ServicePerformed> servicesByProvider = new LinkedList<ServicePerformed>();
		while(iterator.hasNext()) {
			servicePerformed = iterator.next();
			if(servicePerformed.getProviderNumber().equals(id)) {
				servicesByProvider.add(servicePerformed);
			}
		}
		
	
		ServicePerformed servicesByProviderArray[] = new ServicePerformed[servicesByProvider.size()];
		ListIterator<ServicePerformed> listIterator = servicesByProvider.listIterator();
		for(int i=0;i < servicesByProvider.size();i++) {
			servicesByProviderArray[i] = listIterator.next();
		}
		
		return servicesByProviderArray;
	}
	
	/**
	 * Returns a list of services from a certain member
	 * @param id, the id of the member
	 * @return ServicesPerformed[], list of services from the member
	 */
	public ServicePerformed[] getServicesByMember(String id) {
		
		ListIterator<ServicePerformed> iterator = weeksServices.listIterator();
		ServicePerformed servicePerformed = new ServicePerformed();
		
		LinkedList<ServicePerformed> servicesByMember = new LinkedList<ServicePerformed>();
		while(iterator.hasNext()) {
			servicePerformed = iterator.next();
			if(servicePerformed.getMemberNumber().equals(id)) {
				servicesByMember.add(servicePerformed);
			}
		}
		
	
		ServicePerformed servicesByMemberArray[] = new ServicePerformed[servicesByMember.size()];
		ListIterator<ServicePerformed> listIterator = servicesByMember.listIterator();
		for(int i=0;i < servicesByMember.size();i++) {
			servicesByMemberArray[i] = listIterator.next();
		}
		
		return servicesByMemberArray;
		
	}
	
	/**
	 * Clears the list for a new week
	 * @throws IOException
	 */
	public void newWeek() throws IOException{
		weeksServices.clear();
		updateDatabase();
	}
	
	/**
	 * Prints the whole services list
	 */
	private void printList() {
		System.out.print(weeksServices);
	}
	
	/**
	 * Prints a ServicePerformed array
	 */
	private void printArray(ServicePerformed[] services, int count) {
		for(int i = 0; i < count; i++) {
			//ServicePerformed current = services[i];
			System.out.print(services[i]);
		}
	}
}


