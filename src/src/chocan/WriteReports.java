package chocan; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class WriteReports {
	
	//private LinkedList<ServicePerformed> ServicesPerformed;
	
		
	public WriteReports() {
		//ServicesPerformed = new LinkedList<ServicePerformed>();
	}
	
	public void writeMemberReport(String code) throws Exception {
		
		if (code != "0") {
			
			String name = ""; //place to store member name
				
			Member member = new Member(); //creating member variable of Member type
			MemberDatabase memberDatabase = new MemberDatabase();
			member = memberDatabase.getMember(code);
			name = member.getName();
			System.out.println(name);
			
			//FileWriter fw = new FileWriter("Member.txt");
			//fw.write("Member name: " + name);
			
			//fw.close();
		
		//ServicesPerformed = new LinkedList<ServicePerformed>();
		//WeeksServices weeksServices = new WeeksServices();
		//ServicesPerformed = weeksServices.getServicesByMember(code);
		//for (int i = 0; i < ServicesPerformed.size(); i++) {
			//ServicesPerformed.get(0);
			
		}
		
		
		
	}
	
	public void writeProviderReport(int code) {
		
	}
	
	public void writeSummaryReport() {
		
	}
	
	public void writeEFTReports() {
		
	}
}