package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class BillChocAn extends ServicePerformed {
	ServicePerformed s1 = new ServicePerformed();
	ProviderDirectory p1 = new ProviderDirectory();
	
	public BillChocAn() {
		
	}
	
	/**
	 * Prompt user for service code
	 * Display the asssociated service
	 */
	public void lookUpService() 
	{
		
	}
	
	/**
	 * Display provider directory to terminal
	 * @throws Exception
	 */
	public void displayProviderDirectory() throws Exception {
		p1.getAllServices();
	}
	
	/**
	 * Prompt user for all the information related to a provided service
	 * Add that service to the WeeksServices database
	 */
	public void writeServiceReport()
	{
		System.out.println("Current Date and Time:"+ s1.getCurrDateAndTime() );
		System.out.println("Date service was provided: "+ s1.getDateProvided());
		System.out.println("Provider Number: " + s1.getProviderNumber());
		System.out.println("Member number: "+ s1.getMemberNumber());
		System.out.println("Service code: "+ s1.getServiceCode());
	}
}