package chocan;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * class for the terminal that uses different functions used by provider.
 * @author Alisha
 *
 */

public class ProviderTerminal {
 
	private int IDNumber;
	
		/**
		 * prompts for input.
		 * writes the services to the report based on input.
		 * @param input
		 * @throws Exception
		 */
	public void writeNewService(Scanner input) throws Exception {
		BillChocAn billChocAn = new BillChocAn();
		
		String decision = "0";
		
		while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3")) {
			System.out.println("Please select an option:");
			System.out.println("Enter 1 for look up service name with its code:");
			System.out.println("Enter 2 to see the provider directory");
			System.out.println("Enter 3 to skip");
			
			decision = input.nextLine().trim();
			
			if(!decision.equals("1") && !decision.equals("2") && !decision.equals("3")) {
				System.out.println("Invalid input. Please try again.");
			}
				
		}
		
		if(decision.equals("1")) {
			billChocAn.lookUpService(input);
		}
		else if(decision.equals("2")) {
			getProviderDirectory();
		}
		
		billChocAn.writeServiceReport(input);
	}
		
	/**
	 * notify the provider with the desired message.
	 * @param message
	 */
	public void notifyProvider(String message)
	{
			System.out.println(message);
		
	}
	
	/**
	 * gets services from the provider directory.
	 * display provider directory
	 * @throws Exception
	 */
	public void getProviderDirectory() throws Exception {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		providerDirectory.getAllServices();
	}
	
	/**
	 * prompts for member id
	 * verifies member status based on member id
	 * returns a value based on member status
	 * @param id
	 * @return char
	 * @throws Exception
	 */
	public char verifyMember(String id) throws Exception {
		MemberDatabase m2 = new MemberDatabase();
	char y = 0;
	char n = 0;
	if(	m2.getMember(id) != null)
		return y;
		else
		return n;
		
	}
}

