package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class ProviderTerminal {
 
	private int IDNumber;
	
		
	}
	public void writeNewService(Scanner input) throws Exception
	{
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
		
		if(decision.equals("1")) {
			billChocAn.lookUpService();
		}
		
		
		
		billChocAn.writeServiceReport(input);
	}
	public void notifyProvider(String message)
	{
			System.out.println(message);
		
	}
	public void getProviderDirectory() throws Exception
	{
		ProviderDirectory providerDirectory = new ProviderDirectory();
		providerDirectory.getAllServices();
	}
	public char verifyMember(String id) throws Exception
	{
		MemberDatabase m2 = new MemberDatabase();
	char y = 0;
	char n = 0;
	if(	m2.getMember(id) != null)
		return y;
		else
		return n;
		
	}
}

