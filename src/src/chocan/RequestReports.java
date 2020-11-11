package chocan;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * class for requesting different types of reports
 * @author Alisha
 *
 */
public class RequestReports extends WriteReports{
	private String id;
	private String request;
	 	WriteReports r1 = new WriteReports();
	/**
	 * class to find member/provider based on ID
	 * @return the ID of the member or the provider searched
	 */
	public String idPrompt() {
	 	System.out.println("Enter the user id");
	 	Scanner scanner = new Scanner (System.in);  
		String id = scanner.nextLine();
	 	return id;
	 }
		
	/**
	 * prompts for type of report
	 * Writes the appropriate report based on the type of report selected
	 * @throws Exception
	 */
	public void reportRequestPrompt() throws Exception{
	 		System.out.println("Enter the type of report to be generated.");
	 		System.out.println("1 for Member Report");
			System.out.println("2 for Provider Report");
			System.out.println("2 for Summary Report");
			System.out.println("3 for EFT Report");
	 		Scanner scanner = new Scanner (System.in);  
	 		String name = scanner.next(); 
	 		if(name.equalsIgnoreCase("member report"))
	 		{
	 			idPrompt();
		
				r1.writeMemberReport(id);
	 		}
	 		if(name.equalsIgnoreCase("provider report"))
	 		{
	 			idPrompt();
				
				r1.writeProviderReport(id);
	 		}
			if(name.equalsIgnoreCase("summary report"))
	 		{
			
				r1.writeSummaryReport();
	 		}
	 		if(name.equalsIgnoreCase("eft report"))
	 		{
				
				r1.writeEFTReports();
	 		}
	 		
	}
}
	 

