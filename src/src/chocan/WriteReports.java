package chocan; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class WriteReports {
	
		
	public WriteReports() {
		
	}
	
	public void writeMemberReport(String code) throws Exception {
		
		if (code.equals("0")) {
		
			MemberDatabase memDatabase = new MemberDatabase();
			String[] allMemIDs = new String[100];
			allMemIDs = memDatabase.getAllMemberID();
			ServicePerformed[] memServices = new ServicePerformed[100];
			
			WeeksServices wServices = new WeeksServices();
			
			for (int i = 0; i < allMemIDs.length; i++) {
				
				String mID = allMemIDs[i];
				int mIDNum = Integer.parseInt(mID);
				memServices = wServices.getServicesByMember(mIDNum);
				
				if (!(memServices.equals(null))) { // if the list is not empty
					Member member = new Member();
					MemberDatabase mDatabase = new MemberDatabase();
					member = mDatabase.getMember(code);
				
					FileWriter fw = new FileWriter("Member.txt");
					fw.write("Member name: " + member.getName() + "\n");
					fw.write("Member number: " + mID + "\n");
					fw.write("Member street address: " + member.getStreetAddress() + "\n");
					fw.write("Member city: " + member.getCity() + "\n");
					fw.write("Member state: " + member.getState() + "\n");
					fw.write("Member ZIP code: " + member.getZip() + "\n");

					WeeksServices weeksServices = new WeeksServices();
					int codeInt = Integer.parseInt(mID);
					ServicePerformed[] mServices = new ServicePerformed[100];
					mServices = weeksServices.getServicesByMember(codeInt);
					
					for (int j = 0; j < mServices.length; j++) {
						//System.out.println(mServices[i].getDateProvided());
						fw.write("Date provided: " + mServices[j].getDateProvided() + "\n");
						int pID = mServices[j].getProviderNumber();
						String pIDString = Integer.toString(pID);
						ProviderDatabase pDatabase = new ProviderDatabase();
						Provider p = new Provider();
						p = pDatabase.getProvider(pIDString);
						fw.write("Provider name: " + p.getName() + "\n");
						int sCode = mServices[j].getServiceCode();
						String serviceCode = Integer.toString(sCode);
						ServicesOffered servicesOffered = new ServicesOffered();
						fw.write("Service name: " + servicesOffered.getServiceName(serviceCode) + "\n");
					}
					
					fw.close();
				}
			}
		}	
		
		else {
			
			Member member = new Member();
			MemberDatabase mDatabase = new MemberDatabase();
			member = mDatabase.getMember(code);
		
			FileWriter fw = new FileWriter("Member.txt");
			fw.write("Member name: " + member.getName() + "\n");
			fw.write("Member number: " + code + "\n");
			fw.write("Member street address: " + member.getStreetAddress() + "\n");
			fw.write("Member city: " + member.getCity() + "\n");
			fw.write("Member state: " + member.getState() + "\n");
			fw.write("Member ZIP code: " + member.getZip() + "\n");

			WeeksServices weeksServices = new WeeksServices();
			int codeInt = Integer.parseInt(code);
			ServicePerformed[] mServices = new ServicePerformed[100];
			mServices = weeksServices.getServicesByMember(codeInt);
			
			for (int i = 0; i < mServices.length; i++) {
				//System.out.println(mServices[i].getDateProvided());
				fw.write("Date provided: " + mServices[i].getDateProvided() + "\n");
				int pID = mServices[i].getProviderNumber();
				String pIDString = Integer.toString(pID);
				ProviderDatabase pDatabase = new ProviderDatabase();
				Provider p = new Provider();
				p = pDatabase.getProvider(pIDString);
				fw.write("Provider name: " + p.getName() + "\n");
				int sCode = mServices[i].getServiceCode();
				String serviceCode = Integer.toString(sCode);
				ServicesOffered servicesOffered = new ServicesOffered();
				fw.write("Service name: " + servicesOffered.getServiceName(serviceCode) + "\n");
			}
			
			fw.close();
		
			
		}	
		
		
	}
	
	public void writeProviderReport(String code) throws Exception {
		
	 	if (code.equals("0")) {
	 		
	 		ProviderDatabase proDatabase = new ProviderDatabase();
			String[] allProIDs = new String[100];
			allProIDs = proDatabase.getAllProviderID();
			ServicePerformed[] proServices = new ServicePerformed[100];
			
			WeeksServices wServices = new WeeksServices();
			
			for (int i = 0; i < allProIDs.length; i++) {
				
				String pID = allProIDs[i];
				int pIDNum = Integer.parseInt(pID);
				proServices = wServices.getServicesByProvider(pIDNum);
				
				if (!(proServices.equals(null))) { // if the list is not empty
					
					Provider provider = new Provider();
					ProviderDatabase pDatabase = new ProviderDatabase();
					provider = pDatabase.getProvider(pID);			
					FileWriter fw = new FileWriter("Provider.txt");
					fw.write("Provider name: " + provider.getName() + "\n");
					fw.write("Provider number: " + code + "\n");
					fw.write("Provider street address: " + provider.getStreetAddress() + "\n");
					fw.write("Provider city: " + provider.getCity() + "\n");
					fw.write("Provider state: " + provider.getState() + "\n");
					fw.write("Provider ZIP code: " + provider.getZip() + "\n");
					fw.close();
					
					WeeksServices weeksServices = new WeeksServices();
					int codeInt = Integer.parseInt(pID);
					ServicePerformed[] pServices = new ServicePerformed[100];
					pServices = weeksServices.getServicesByProvider(codeInt);
					
					int totalFee = 0;
					
					for (int j = 0; j < pServices.length; j++) {
						fw.write("Date of service: " + pServices[j].getDateProvided() + "\n");
						fw.write("Date and time data were received by the computer: " + pServices[i].getCurrDateAndTime() + "\n");
						int mID = pServices[j].getMemberNumber();
						String mIDString = Integer.toString(mID);
						MemberDatabase mDatabase = new MemberDatabase();
						Member m = new Member();
						m = mDatabase.getMember(mIDString);
						fw.write("Member name: " + m.getName() + "\n");
						fw.write("Service code: " + pServices[j].getServiceCode() + "\n");
						int sCode = pServices[j].getServiceCode();
						String stringCode = Integer.toString(sCode);
						ProviderDirectory pDirectory = new ProviderDirectory();
						fw.write("Fee to be paid: $" + pDirectory.getServiceFee(stringCode) + "\n");
						String serviceFee = pDirectory.getServiceFee(stringCode);
						int numFee = Integer.parseInt(serviceFee);
						totalFee = totalFee + numFee;
					}
					
					fw.write("Total number of consulatations with members: " + pServices.length + "\n");
					fw.write("Total fee for week: $" + totalFee + "\n");
					
				}	
			}
			
	 	}
	 	
	 	else {
	 		
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
			
			WeeksServices weeksServices = new WeeksServices();
			int codeInt = Integer.parseInt(code);
			ServicePerformed[] pServices = new ServicePerformed[100];
			pServices = weeksServices.getServicesByProvider(codeInt);
			
			int totalFee = 0;
			
			for (int i = 0; i < pServices.length; i++) {
				fw.write("Date of service: " + pServices[i].getDateProvided() + "\n");
				fw.write("Date and time data were received by the computer: " + pServices[i].getCurrDateAndTime() + "\n");
				int mID = pServices[i].getMemberNumber();
				String mIDString = Integer.toString(mID);
				MemberDatabase mDatabase = new MemberDatabase();
				Member m = new Member();
				m = mDatabase.getMember(mIDString);
				fw.write("Member name: " + m.getName() + "\n");
				fw.write("Service code: " + pServices[i].getServiceCode() + "\n");
				int sCode = pServices[i].getServiceCode();
				String stringCode = Integer.toString(sCode);
				ProviderDirectory pDirectory = new ProviderDirectory();
				fw.write("Fee to be paid: $" + pDirectory.getServiceFee(stringCode) + "\n");
				String serviceFee = pDirectory.getServiceFee(stringCode);
				int numFee = Integer.parseInt(serviceFee);
				totalFee = totalFee + numFee;
			}
			
			fw.write("Total number of consulatations with members: " + pServices.length + "\n");
			fw.write("Total fee for week: $" + totalFee + "\n");
			
			
	 	}
	}
	
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
			int pIDNum = Integer.parseInt(pID);
			proServices = wServices.getServicesByProvider(pIDNum);
			
			if (!(proServices.equals(null))) { // if the list is not empty, get ServicePerformed information
				
				Provider provider = new Provider();
				ProviderDatabase pDatabase = new ProviderDatabase();
				provider = pDatabase.getProvider(pID);			
				fw.write("Provider name: " + provider.getName() + "\n");
				
				WeeksServices weeksServices = new WeeksServices();
				int codeInt = Integer.parseInt(pID);
				ServicePerformed[] pServices = new ServicePerformed[100];
				pServices = weeksServices.getServicesByProvider(codeInt);
				
				int totalFee = 0;
				
				fw.write("	Total number of consulatations with members: " + pServices.length + "\n");
				
				for (int j = 0; j < pServices.length; j++) { //loops through every service
				
					int sCode = pServices[j].getServiceCode();
					String stringCode = Integer.toString(sCode);
					ProviderDirectory pDirectory = new ProviderDirectory();
					String serviceFee = pDirectory.getServiceFee(stringCode);
					int numFee = Integer.parseInt(serviceFee);
					totalFee = totalFee + numFee;
					
				}
				
				fw.write("	Total fee: " + totalFee + "\n");
				
				overallFee = overallFee + totalFee;
				
			}
		}
				
		fw.write("Overall total fee: " + overallFee + "\n");
		fw.close();
		
	}
	
	public void writeEFTReports() {
		
		
		
	}
}