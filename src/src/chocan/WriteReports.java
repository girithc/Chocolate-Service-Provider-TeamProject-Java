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
		ServicesPerformed = new LinkedList<ServicePerformed>();
	
	}
	
	public void writeMemberReport(int code) {
		ServicesPerformed = new LinkedList<ServicePerformed>();
		WeeksServices weeksServices = new WeeksServices();
		ServicesPerformed = weeksServices.getServicesByMember(code);
		for (int i = 0; i < ServicesPerformed.size(); i++) {
			ServicesPerformed.get(0);
			
		}
		
		
	}
	
	public void writeProviderReport(int code) {
		
	}
	
	public void writeSummaryReport() {
		
	}
	
	public void writeEFTReports() {
		
	}
}