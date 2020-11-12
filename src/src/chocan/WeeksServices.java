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
	
	private int serviceCount;
	private LinkedList<ServicePerformed> weeksServices = new LinkedList<ServicePerformed>();
	
	/**
	 * Constructor for services list
	 * @throws FileNotFoundException
	 */
	public WeeksServices() throws FileNotFoundException {
		
		File database = new File("WeeksServicesDatabase.csv"); //Opening the .csv file
		
		Scanner reader = new Scanner(database); // Created the scanner object to read the file
		
		
		while(reader.hasNextLine()) { 
			String ServiceDataLine = reader.nextLine(); //Read the whole line of data
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
			serviceInput.setProviderNumber(Integer.parseInt(ServiceData[2]));
			serviceInput.setMemberNumber(Integer.parseInt(ServiceData[3]));
			serviceInput.setServiceCode(Integer.parseInt(ServiceData[4]));
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
		serviceCount++;
		updateDatabase();
	}
	
	/**
	 * Deletes a service from the list
	 * @param service, service to be deleted from the list
	 * @throws IOException
	 */
	public void deleteService(ServicePerformed service) throws IOException {
		if(weeksServices.remove(service)) {
			serviceCount++;
			updateDatabase();
		}
	}
	
	/**
	 * Returns a list of services from a certain provider
	 * @param id, the id of the provider 
	 * @return ServicesPerformed[], list of services from the provider
	 */
	public ServicePerformed[] getServicesByProvider(int id) {
		ServicePerformed[] providerServices = new ServicePerformed[100];
		int providerServiceCount = 0;
		for(int i = 0; i < serviceCount; i++) {
			ServicePerformed current = weeksServices.get(i);
			if(current.getProviderNumber() == id) {
				providerServices[providerServiceCount] = current;
				providerServiceCount++;
			}
		}
		return providerServices;
	}
	
	/**
	 * Returns a list of services from a certain member
	 * @param id, the id of the member
	 * @return ServicesPerformed[], list of services from the member
	 */
	public ServicePerformed[] getServicesByMember(int id) {
		ServicePerformed[] memberServices = new ServicePerformed[100];
		int memberServiceCount = 0;
		for(int i = 0; i < serviceCount; i++) {
			ServicePerformed current = weeksServices.get(i);
			if(current.getMemberNumber() == id) {
				memberServices[memberServiceCount] = current;
				memberServiceCount++;
			}
		}
		return memberServices;
	}
	
	/**
	 * Clears the list for a new week
	 * @throws IOException
	 */
	public void newWeek() throws IOException{
		weeksServices.clear();
		serviceCount = 0;
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

	/**
	 * Main function for testing
	 */
	/*
	public static void main(String[] args) {
		WeeksServices test = new WeeksServices();
		ServicePerformed service1 = new ServicePerformed();
		ServicePerformed service2 = new ServicePerformed();
		ServicePerformed service3 = new ServicePerformed();
		ServicePerformed service4 = new ServicePerformed();
		service1.setProviderNumber(1234);
		service2.setProviderNumber(1234);
		service1.setServiceCode(6666);
		service2.setServiceCode(5555);
		service3.setProviderNumber(54321);
		service4.setProviderNumber(65432);
		test.addService(service1);
		test.addService(service2);
		test.addService(service3);
		test.addService(service4);
		test.printArray(test.getServicesByProvider(1234), 100);
		test.printList();
	}
	*/
}  


