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
					
					if (memServices.length != 0) { //if the member has services
						int counter = 0;
						int indicator = 0;
						int exception[] = new int[memServices.length];
						exception[0] = -1;
						int bool = 0;
						String min = memServices[0].getDateProvided();
						while (counter < memServices.length) {
							
							
							for (int j = 0; j < memServices.length; j++) {
								
								int compare = memServices[j].getDateProvided().compareTo(min);
								if (compare <= 0) {
									for (int p = 0; p < counter; p++) {
										if (j == exception[p]) {
											bool = 1;
										}
									}
									if (bool != 1) {
										min = memServices[j].getDateProvided();
										indicator = j;
									}
								}
								bool = 0;
							}
							
							exception[counter] = indicator;
														
							fw.write("Date provided: " + memServices[indicator].getDateProvided() + "\n");
							String pID = memServices[indicator].getProviderNumber();
							ProviderDatabase pDatabase = new ProviderDatabase();
							Provider p = new Provider();
							p = pDatabase.getProvider(pID);
							fw.write("Provider name: " + p.getName() + "\n");
							String sCode = memServices[indicator].getServiceCode();
							ProviderDirectory providerDirectory = new ProviderDirectory();
							fw.write("Service name: " + providerDirectory.getServiceName(sCode) + "\n");
					
							counter++;
							min = "456";
						}		
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
			fw.write("Member ZIP code: " + member.getZip() + "\n\n\n");
			

			WeeksServices weeksServices = new WeeksServices();
			ServicePerformed[] mServices = new ServicePerformed[100];
			mServices = weeksServices.getServicesByMember(code);
			
			if (mServices.length != 0) {
			
				int counter = 0;
				int indicator = 0;
				int exception[] = new int[mServices.length];
				exception[0] = -1;
				int bool = 0;
				String min = mServices[0].getDateProvided();
				while (counter < mServices.length) {		
					for (int j = 0; j < mServices.length; j++) {
						int compare = mServices[j].getDateProvided().compareTo(min);
						if (compare <= 0) {	
							for (int p = 0; p < counter; p++) {	
								if (j == exception[p]) {
									bool = 1;	
								}
							}
							if (bool != 1) {	
								min = mServices[j].getDateProvided();
								indicator = j;
							}
						}
						bool = 0;
					}
					
					exception[counter] = indicator;
												
					fw.write("Date provided: " + mServices[indicator].getDateProvided() + "\n");
					String pID = mServices[indicator].getProviderNumber();
					ProviderDatabase pDatabase = new ProviderDatabase();
					Provider p = new Provider();
					p = pDatabase.getProvider(pID);
					fw.write("Provider name: " + p.getName() + "\n");
					String sCode = mServices[indicator].getServiceCode();
					ProviderDirectory providerDirectory = new ProviderDirectory();
					fw.write("Service name: " + providerDirectory.getServiceName(sCode) + "\n\n");
			
					counter++;
					min = "456";
				}
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
					fw.write("Provider ZIP code: " + provider.getZip() + "\n\n");
					
					WeeksServices weeksServices = new WeeksServices();
					ServicePerformed[] pServices = new ServicePerformed[100];
					pServices = weeksServices.getServicesByProvider(pID);
					
					int totalFee = 0;
					
					if (pServices.length != 0 ) {
					
						int counter = 0;
						int indicator = 0;
						int exception[] = new int[pServices.length];
						exception[0] = -1;
						int bool = 0;
						String min = pServices[0].getCurrDateAndTime();
						while (counter < pServices.length) {		
							for (int j = 0; j < pServices.length; j++) {
								int compare = pServices[j].getCurrDateAndTime().compareTo(min);
								if (compare <= 0) {	
									for (int p = 0; p < counter; p++) {	
										if (j == exception[p]) {
											bool = 1;	
										}
									}
									if (bool != 1) {	
										min = pServices[j].getCurrDateAndTime();
										indicator = j;
									}
								}
								bool = 0;
							}
							
							exception[counter] = indicator;
						
							fw.write("Date of service: " + pServices[indicator].getDateProvided() + "\n");
							fw.write("Date and time data were received by the computer: " + pServices[indicator].getCurrDateAndTime() + "\n");
							String mID = pServices[indicator].getMemberNumber();
							MemberDatabase mDatabase = new MemberDatabase();
							Member m = new Member();
							m = mDatabase.getMember(mID);
							fw.write("Member name: " + m.getName() + "\n");
							fw.write("Service code: " + pServices[indicator].getServiceCode() + "\n");
							String sCode = pServices[indicator].getServiceCode();
							ProviderDirectory pDirectory = new ProviderDirectory();
							fw.write("Fee to be paid: $" + pDirectory.getServiceFee(sCode) + "\n\n");
							String serviceFee = pDirectory.getServiceFee(sCode);
							int numFee = Integer.parseInt(serviceFee);
							totalFee = totalFee + numFee;
						
							counter++;
							min = "456";
						}
					}
					
					fw.write("\nTotal number of consulatations with members: " + pServices.length + "\n");
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
			fw.write("Provider ZIP code: " + provider.getZip() + "\n\n");
			
			WeeksServices weeksServices = new WeeksServices();
			ServicePerformed[] pServices = new ServicePerformed[100];
			pServices = weeksServices.getServicesByProvider(code);
			
			int totalFee = 0;
			
			if (pServices.length != 0) {
			
				int counter = 0;
				int indicator = 0;
				int exception[] = new int[pServices.length];
				exception[0] = -1;
				int bool = 0;
				String min = pServices[0].getCurrDateAndTime();
				while (counter < pServices.length) {		
					for (int j = 0; j < pServices.length; j++) {
						int compare = pServices[j].getCurrDateAndTime().compareTo(min);
						if (compare <= 0) {	
							for (int p = 0; p < counter; p++) {	
								if (j == exception[p]) {
									bool = 1;	
								}
							}
							if (bool != 1) {	
								min = pServices[j].getCurrDateAndTime();
								indicator = j;
							}
						}
						bool = 0;
					}
					
					exception[counter] = indicator;
				
							
					fw.write("Date of service: " + pServices[indicator].getDateProvided() + "\n");
					fw.write("Date and time data were received by the computer: " + pServices[indicator].getCurrDateAndTime() + "\n");
					String mID = pServices[indicator].getMemberNumber();
					MemberDatabase mDatabase = new MemberDatabase();
					Member m = new Member();
					m = mDatabase.getMember(mID);
					fw.write("Member name: " + m.getName() + "\n");
					fw.write("Service code: " + pServices[indicator].getServiceCode() + "\n");
					String sCode = pServices[indicator].getServiceCode();
					ProviderDirectory pDirectory = new ProviderDirectory();
					fw.write("Fee to be paid: $" + pDirectory.getServiceFee(sCode) + "\n\n");
					String serviceFee = pDirectory.getServiceFee(sCode);
					int numFee = Integer.parseInt(serviceFee);
					totalFee = totalFee + numFee;
					
					counter++;
					min = "456";
					
				}
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