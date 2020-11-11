package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class RequestReports extends WriteReports{
	
	private String id;
		
	 private String request;
	 	
	
	public String idPrompt() {
	 	System.out.println("Enter the user id");
	 	Scanner scanner = new Scanner (System.in);  
		String id = scanner.nextLine();
		String id = scanner.nextLine();
	 	return id;
	 }
		
		public void reportRequestPrompt(){
	public void reportRequestPrompt() throws Exception{
	 		System.out.println("Enter the type of report to be generated.");
	 		Scanner scanner = new Scanner (System.in);  
	 		String name = scanner.next(); 
	 		if(name.equalsIgnoreCase("member"))
	 		{
				//writeMemberReport(id);
				r1.writeMemberReport(id);
	 		}
	 		if(name.equalsIgnoreCase("provider"))
	 		{
				//writeProviderReport(id);
				r1.writeProviderReport(id);
	 		}
			if(name.equalsIgnoreCase("summary"))
	 		{
				//writeSummaryReport
				r1.writeSummaryReport();
	 		}
	 		if(name.equalsIgnoreCase("eft"))
	 		{
				//writeEFTReport
				r1.writeEFTReports();
	 		}
	 		
	 }

