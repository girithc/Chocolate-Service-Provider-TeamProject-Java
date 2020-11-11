package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class RequestReports{
	private int id;
	private String request;
	public int idPrompt() {
		System.out.println("Enter the user id");
		Scanner scanner = new Scanner (System.in);  
		int id = scanner.nextInt();
		return id;
	}
	public void reportRequestPrompt(){
		System.out.println("Enter the type of report to be generated.");
		Scanner scanner = new Scanner (System.in);  
		String name = scanner.next(); 
		if(name.equalsIgnoreCase("member"))
		{
			//writeMemberReport(id);
		}
		if(name.equalsIgnoreCase("provider"))
		{
			//writeProviderReport(id);
		}
		{
			//writeSummaryReport
		}
		if(name.equalsIgnoreCase("eft"))
		{
			//writeEFTReport
		}
		
}
}