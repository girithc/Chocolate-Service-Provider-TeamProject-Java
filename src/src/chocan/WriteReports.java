package chocan; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class WriteReports {
	
	private LinkedList<ServicePerformed> ServicesPerformed;
	
		
	public WriteReports() {
		//ServicesPerformed = new LinkedList<ServicePerformed>();
	}
	
	public void writeMemberReport(String code) throws Exception {
		
		if (code != "0") {
							
			Member member = new Member(); //creating member variable of Member type
			MemberDatabase mDatabase = new MemberDatabase();
			member = mDatabase.getMember(code);
			//System.out.println(name);
			
			FileWriter fw = new FileWriter("Member.txt");
			fw.write("Member name: " + member.getName() + "\n");
			fw.write("Member number: " + code + "\n");
			fw.write("Member street address: " + member.getStreetAddress() + "\n");
			fw.write("Member city: " + member.getCity() + "\n");
			fw.write("Member state: " + member.getState() + "\n");
			fw.write("Member ZIP code: " + member.getZip() + "\n");
			
			
			WeeksServices weeksServices = new WeeksServices();
			//ServicesPerformed = new LinkedList<ServicePerformed>();
			int codeInt = Integer.parseInt(code);
			ServicePerformed[] mServices = new ServicePerformed[100];
			mServices = weeksServices.getServicesByMember(codeInt);
			
			for (int i = 0; i < mServices.length; i++) {
				fw.write("Date provided: " + mServices[i].getDateProvided() + "\n");
			}
		//ServicesPerformed = new LinkedList<ServicePerformed>();
		//WeeksServices weeksServices = new WeeksServices();
		//ServicesPerformed = weeksServices.getServicesByMember(code);
		//for (int i = 0; i < ServicesPerformed.size(); i++) {
			//ServicesPerformed.get(0);
			
			fw.close();

		}
		
		
		
	}
	
	public void writeProviderReport(String code) throws Exception {
		
		if (code != "0") {
			
			Provider provider = new Provider();
			ProviderDatabase pDatabase = new ProviderDatabase();
			provider = pDatabase.getProvider(code);
			
			FileWriter fw = new FileWriter("Provider.txt");
			fw.write("Provider name: " + provider.getName() + "\n");
			fw.write("Provider number: " + code + "\n");
			fw.write("Provider street address: " + provider.getStreetAddress() + "\n");
			fw.write("Provider city: " + provider.getCity() + "\n");
			fw.write("Provider state: " + provider.getState() + "\n");
			fw.write("Provider ZIP code: " + provider.getZip() + "\n");
			
			fw.close();
		}
	}
	
	public void writeSummaryReport() {
		
	}
	
	public void writeEFTReports() {
		
	}
}