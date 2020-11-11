package chocan;
import java.io.File;
import java.util.*;


/**
 * Class for services list
 * @author Jake Bischoff
 *
 */
public class WeeksServices {
	
	private int serviceCount;
	private LinkedList<ServicePerformed> weeksServices;
	
	/**
	 * Constructor for services list
	 */
	public WeeksServices() {
		/*
		Members = new LinkedList<Member>(); // Creating the Members linked list
		File database = new File("MemberDatabase.csv"); //Opening the .csv file
		
		Scanner reader = new Scanner(database); // Created the scanner object to read the file
		
		
		while(reader.hasNextLine()) { // While there are still more Members
			String MemberDataLine = reader.nextLine(); //Read the whole line of data
			String[] MemberData = MemberDataLine.split(",", 0); // Split line into an array along the tabs since it is a tab delimited
			// 0 = name
			// 1 = IDNumber
			// 2 = email
			// 3 = streetAddress
			// 4 = city
			// 5 = state
			// 6 = zip
			// 7 = suspended
			Member Member = new Member();
			Member.setName(MemberData[0]);
			Member.setIDNumber(MemberData[1]);
			Member.setEmail(MemberData[2]);
			Member.setStreetAddress(MemberData[3]);
			Member.setCity(MemberData[4]);
			Member.setState(MemberData[5]);
			Member.setZip(MemberData[6]);
			if(MemberData[7].equals("T")) {
				Member.setSuspended(true);
			}
			else {
				Member.setSuspended(false);
			}
			
			Members.add(Member); // Adding to database
			
		}
		
		reader.close(); // Closing the reader object
		*/
	}
	
	/**
	 * Adds a service to the list
	 * @param service, service to be added to the list
	 */
	public void addService(ServicePerformed service) {
		weeksServices.add(service);
		serviceCount++;
	}
	
	/**
	 * Deletes a service from the list
	 * @param service, service to be deleted from the list
	 */
	public void deleteService(ServicePerformed service) {
		if(weeksServices.remove(service)) {
			serviceCount++;
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
	 */
	public void newWeek() {
		weeksServices.clear();
		serviceCount = 0;
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
//<<<<<<< HEAD
	/*
	public static int main(String[] args) {
=======
	public static void main(String[] args) {
>>>>>>> branch 'master' of https://jhbischoff@bitbucket.org/popoola/fall2020team11.git
		WeeksServices test = new WeeksServices();
		ServicePerformed service1 = new ServicePerformed();
		ServicePerformed service2 = new ServicePerformed();
		ServicePerformed service3 = new ServicePerformed();
		ServicePerformed service4 = new ServicePerformed();
		service1.setProviderNumber(1234);
		service2.setProviderNumber(1234);
		service1.setServiceCode("6666");
		service2.setServiceCode("5555");
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


