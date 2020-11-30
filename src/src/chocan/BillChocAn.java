package src.chocan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class BillChocAn {
	
	ServicePerformed s1 = new ServicePerformed();
	ProviderDirectory p1 = new ProviderDirectory();
	
	public BillChocAn() {
		
	}
	
	/**
	 * Prompt user for service code
	 * Display the associated service
	 * @throws Exception 
	 */
	public void lookUpService(Scanner input) throws Exception 
	{
		ProviderDirectory providerDirectory = new ProviderDirectory();
		
		System.out.println("\nEnter the service code:");
		providerDirectory.getServiceName(input.nextLine().trim());
		
	}
	
	/**
	 * Prompt user for all the information related to a provided service
	 * Add that service to the WeeksServices database
	 * @throws Exception 
	 */
	public void writeServiceReport(Scanner input) throws Exception
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-DD-YYYY HH:MM:SS");
		LocalDateTime now = LocalDateTime.now();
		
		
		WeeksServices weeksServices = new WeeksServices();
		ServicePerformed servicePerformed = new ServicePerformed();
		
		servicePerformed.setCurrDateAndTime(dtf.format(now));
		
		//using this for testing purposes
		//servicePerformed.setCurrDateAndTime("11-30-2020 11:33:20");
		
		System.out.println("Enter the date the service was provided (MM-DD-YYYY):");
		servicePerformed.setDateProvided(input.nextLine().trim());
		
		System.out.println("Enter the provider number:");
		servicePerformed.setProviderNumber(input.nextLine().trim());
		
		System.out.println("Enter the member number:)");
		servicePerformed.setMemberNumber(input.nextLine().trim());
		
		System.out.println("Enter the service code:");
		String serviceCode = input.nextLine().trim();
		servicePerformed.setServiceCode(serviceCode);
		
		System.out.println("Enter any additional comments:");
		servicePerformed.setComments(input.nextLine().trim());
		
		weeksServices.addService(servicePerformed);
		
		ProviderDirectory providerDirectory =  new ProviderDirectory();
		System.out.println("The fee for this service is $" + providerDirectory.getServiceFee(serviceCode));
		
	}
}