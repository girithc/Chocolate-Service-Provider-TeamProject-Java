package chocan; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class WriteReports {
	
	/**
	 * 	Constructor
	 */
	public WriteReports() {
		
	}
	
	/**
	 * Writes individual member report based on given member code or writes weekly member reports
	 * @param code
	 * @throws Exception
	 * @author annekatherinefike
	 */
	public void writeMemberReport(String code) throws Exception {
		
		if (code.equals("0")) {
		
			MemberDatabase memDatabase = new MemberDatabase();
			String[] allMemIDs = new String[100];
			allMemIDs = memDatabase.getAllMemberID();
			ServicePerformed[] memServices = new ServicePerformed[100];
			
			WeeksServices wServices = new WeeksServices();
			
			for (int i = 0; i < allMemIDs.length; i++) {
				
				String mID = allMemIDs[i];
				memServices = wServices.getServicesByMember(mID);
				
				if (!(memServices.equals(null))) { // if the list is not empty
					Member member = new Member();
					member = memDatabase.getMember(mID);
					String fileName = mID + ".txt";
					FileWriter fw = new FileWriter(fileName);
					fw.write("Member name: " + member.getName() + "\n");
					fw.write("Member number: " + mID + "\n");
					fw.write("Member street address: " + member.getStreetAddress() + "\n");
					fw.write("Member city: " + member.getCity() + "\n");
					fw.write("Member state: " + member.getState() + "\n");
					fw.write("Member ZIP code: " + member.getZip() + "\n");
					
					
					//String[] date = new String[memServices.length];
					//String min = memServices[0].getDateProvided();
					//int counter = 1;
					//System.out.println(memServices[counter].getDateProvided());
					/*
					while (counter < memServices.length) {
						for (int j = 0 + counter; j < memServices.length; j++) {
							int compare = memServices[j].getDateProvided().compareTo(min);
							if (compare < 0) {
								min = memServices[j].getDateProvided();
							}
						}
						date[counter] = min;
						counter++;
						min = memServices[counter].getDateProvided();
					}
					
					for (int r = 0; r < memServices.length; r++) {
						System.out.println(date[r]);
					}
					*/
					
					
					for (int j = 0; j < memServices.length; j++) {
						//System.out.println(memServices[j].getDateProvided());
						//System.out.println(j);
						fw.write("Date provided: " + memServices[j].getDateProvided() + "\n");
						String pID = memServices[j].getProviderNumber();
						ProviderDatabase pDatabase = new ProviderDatabase();
						Provider p = new Provider();
						p = pDatabase.getProvider(pID);
						fw.write("Provider name: " + p.getName() + "\n");
						String sCode = memServices[j].getServiceCode();
						ProviderDirectory providerDirectory = new ProviderDirectory();
						fw.write("Service name: " + providerDirectory.getServiceName(sCode) + "\n");
					}
					
					fw.close();
				}
			}
		}	
		
		else {
			
			Member member = new Member();
			MemberDatabase mDatabase = new MemberDatabase();
			member = mDatabase.getMember(code);
			
			String fileName = code + ".txt";
			FileWriter fw = new FileWriter(fileName);
			fw.write("Member name: " + member.getName() + "\n");
			fw.write("Member number: " + code + "\n");
			fw.write("Member street address: " + member.getStreetAddress() + "\n");
			fw.write("Member city: " + member.getCity() + "\n");
			fw.write("Member state: " + member.getState() + "\n");
			fw.write("Member ZIP code: " + member.getZip() + "\n");
			

			WeeksServices weeksServices = new WeeksServices();
			ServicePerformed[] mServices = new ServicePerformed[100];
			mServices = weeksServices.getServicesByMember(code);
			

			
			for (int i = 0; i < mServices.length; i++) {
				fw.write("Date provided: " + mServices[i].getDateProvided() + "\n");
				String pID = mServices[i].getProviderNumber();
				ProviderDatabase pDatabase = new ProviderDatabase();
				Provider p = new Provider();
				p = pDatabase.getProvider(pID);
				fw.write("Provider name: " + p.getName() + "\n");
				String sCode = mServices[i].getServiceCode();
				ServicesOffered servicesOffered = new ServicesOffered();
				fw.write("Service name: " + servicesOffered.getServiceName(sCode) + "\n");
			}
			
			fw.close();
		
			
		}	
		
		
	}
	
	/**
	 * Writes individual provider report based on given provider code or writes weekly provider reports
	 * @param code
	 * @throws Exception
	 * @author annekatherinefike
	 */
	public void writeProviderReport(String code) throws Exception {
		
	 	if (code.equals("0")) {
	 		
	 		ProviderDatabase proDatabase = new ProviderDatabase();
			String[] allProIDs = new String[100];
			allProIDs = proDatabase.getAllProviderID();
			ServicePerformed[] proServices = new ServicePerformed[100];
			
			WeeksServices wServices = new WeeksServices();
			
			for (int i = 0; i < allProIDs.length; i++) {
				
				String pID = allProIDs[i];
				proServices = wServices.getServicesByProvider(pID);
				
				if (!(proServices.equals(null))) { // if the list is not empty
					
					Provider provider = new Provider();
					ProviderDatabase pDatabase = new ProviderDatabase();
					provider = pDatabase.getProvider(pID);	
					String fileName = "p" + pID + ".txt";
					FileWriter fw = new FileWriter(fileName);
					fw.write("Provider name: " + provider.getName() + "\n");
					fw.write("Provider number: " + pID + "\n");
					fw.write("Provider street address: " + provider.getStreetAddress() + "\n");
					fw.write("Provider city: " + provider.getCity() + "\n");
					fw.write("Provider state: " + provider.getState() + "\n");
					fw.write("Provider ZIP code: " + provider.getZip() + "\n");
					
					WeeksServices weeksServices = new WeeksServices();
					ServicePerformed[] pServices = new ServicePerformed[100];
					pServices = weeksServices.getServicesByProvider(pID);
					
					int totalFee = 0;
					
					for (int j = 0; j < pServices.length; j++) {
						fw.write("Date of service: " + pServices[j].getDateProvided() + "\n");
						fw.write("Date and time data were received by the computer: " + pServices[j].getCurrDateAndTime() + "\n");
						String mID = pServices[j].getMemberNumber();
						MemberDatabase mDatabase = new MemberDatabase();
						Member m = new Member();
						m = mDatabase.getMember(mID);
						fw.write("Member name: " + m.getName() + "\n");
						fw.write("Service code: " + pServices[j].getServiceCode() + "\n");
						String sCode = pServices[j].getServiceCode();
						ProviderDirectory pDirectory = new ProviderDirectory();
						fw.write("Fee to be paid: $" + pDirectory.getServiceFee(sCode) + "\n");
						String serviceFee = pDirectory.getServiceFee(sCode);
						int numFee = Integer.parseInt(serviceFee);
						totalFee = totalFee + numFee;
					}
					
					fw.write("Total number of consulatations with members: " + pServices.length + "\n");
					fw.write("Total fee for week: $" + totalFee + "\n");
					
					fw.close();
					
				}	
			}
						
	 	}
	 	
	 	else {
	 		
	 		
	 		Provider provider = new Provider();
			ProviderDatabase pDatabase = new ProviderDatabase();
			provider = pDatabase.getProvider(code);	
			String fileName = "p" + code + ".txt";
			FileWriter fw = new FileWriter(fileName);
			fw.write("Provider name: " + provider.getName() + "\n");
			fw.write("Provider number: " + code + "\n");
			fw.write("Provider street address: " + provider.getStreetAddress() + "\n");
			fw.write("Provider city: " + provider.getCity() + "\n");
			fw.write("Provider state: " + provider.getState() + "\n");
			fw.write("Provider ZIP code: " + provider.getZip() + "\n");
			
			WeeksServices weeksServices = new WeeksServices();
			ServicePerformed[] pServices = new ServicePerformed[100];
			pServices = weeksServices.getServicesByProvider(code);
			
			int totalFee = 0;
			
			System.out.println(pServices.length);
						
			for (int i = 0; i < pServices.length; i++) {
				System.out.println("inside for loop");
				System.out.println(i);
				fw.write("Date of service: " + pServices[i].getDateProvided() + "\n");
				fw.write("Date and time data were received by the computer: " + pServices[i].getCurrDateAndTime() + "\n");
				String mID = pServices[i].getMemberNumber();
				MemberDatabase mDatabase = new MemberDatabase();
				Member m = new Member();
				m = mDatabase.getMember(mID);
				fw.write("Member name: " + m.getName() + "\n");
				fw.write("Service code: " + pServices[i].getServiceCode() + "\n");
				String sCode = pServices[i].getServiceCode();
				ProviderDirectory pDirectory = new ProviderDirectory();
				fw.write("Fee to be paid: $" + pDirectory.getServiceFee(sCode) + "\n");
				String serviceFee = pDirectory.getServiceFee(sCode);
				int numFee = Integer.parseInt(serviceFee);
				totalFee = totalFee + numFee;
			}
			
			fw.write("Total number of consulatations with members: " + pServices.length + "\n");
			fw.write("Total fee for week: $" + totalFee + "\n");
			
			fw.close();	
			
	 	}
	}
	
	/**
	 * Writes summary report for the week
	 * @throws Exception
	 * @author annekatherinefike
	 */
	public void writeSummaryReport() throws Exception {
		
		FileWriter fw = new FileWriter("Summary.txt");
		
		ProviderDatabase proDatabase = new ProviderDatabase();
		String[] allProIDs = new String[100];
		allProIDs = proDatabase.getAllProviderID();
		ServicePerformed[] proServices = new ServicePerformed[100];
		
		WeeksServices wServices = new WeeksServices();
		
		int overallFee = 0;
		
		for (int i = 0; i < allProIDs.length; i++) { // loops through every provider in provider database
			
			String pID = allProIDs[i];
			//int pIDNum = Integer.parseInt(pID);
			proServices = wServices.getServicesByProvider(pID);
			
			if (!(proServices.equals(null))) { // if the list is not empty, get ServicePerformed information
				
				Provider provider = new Provider();
				ProviderDatabase pDatabase = new ProviderDatabase();
				provider = pDatabase.getProvider(pID);			
				fw.write("Provider name: " + provider.getName() + "\n");
				
				WeeksServices weeksServices = new WeeksServices();
				//int codeInt = Integer.parseInt(pID);
				ServicePerformed[] pServices = new ServicePerformed[100];
				pServices = weeksServices.getServicesByProvider(pID);
				
				int totalFee = 0;
				
				fw.write("	Total number of consulatations with members: " + pServices.length + "\n");
				
				for (int j = 0; j < pServices.length; j++) { //loops through every service
				
					String stringCode  = pServices[j].getServiceCode();
					ProviderDirectory pDirectory = new ProviderDirectory();
					String serviceFee = pDirectory.getServiceFee(stringCode);
					int numFee = Integer.parseInt(serviceFee);
					totalFee = totalFee + numFee;
					
				}
				
				fw.write("	Total fee: $" + totalFee + "\n");
				
				overallFee = overallFee + totalFee;
				
			}
		}
				
		fw.write("Overall total fee: $" + overallFee + "\n");
		fw.close();
		
	}
	
	/**
	 * Writes EFT Report for the week
	 * @throws Exception
	 * @author annekatherinefike
	 */
	public void writeEFTReport() throws Exception {
		
		FileWriter fw = new FileWriter("EFT.txt");
		
		ProviderDatabase proDatabase = new ProviderDatabase();
		String[] allProIDs = new String[100];
		allProIDs = proDatabase.getAllProviderID();
		ServicePerformed[] proServices = new ServicePerformed[100];
		
		WeeksServices wServices = new WeeksServices();
		
		for (int i = 0; i < allProIDs.length; i++) { // loops through every provider in provider database
			
			String pID = allProIDs[i];
			//int pIDNum = Integer.parseInt(pID);
			proServices = wServices.getServicesByProvider(pID);
			
			if (!(proServices.equals(null))) { // if the list is not empty, get ServicePerformed information
				
				Provider provider = new Provider();
				ProviderDatabase pDatabase = new ProviderDatabase();
				provider = pDatabase.getProvider(pID);			
				fw.write("Provider name: " + provider.getName() + "\n");
				
				WeeksServices weeksServices = new WeeksServices();
				//int codeInt = Integer.parseInt(pID);
				ServicePerformed[] pServices = new ServicePerformed[100];
				pServices = weeksServices.getServicesByProvider(pID);
				
				int totalFee = 0;
				
				for (int j = 0; j < pServices.length; j++) { //loops through every service
					
					String stringCode = pServices[j].getServiceCode();
					ProviderDirectory pDirectory = new ProviderDirectory();
					String serviceFee = pDirectory.getServiceFee(stringCode);
					int numFee = Integer.parseInt(serviceFee);
					totalFee = totalFee + numFee;
					
				}
				
				fw.write("	Amount to be paid $: " + totalFee + "\n");
				fw.write("\n");
		
			
			}
		}
		
	fw.close();
		
	}
}