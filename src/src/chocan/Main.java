package chocan;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		int initialAction = 0;
		while(initialAction != 1 && initialAction != 2 && initialAction != 3 && initialAction != 4) {
			System.out.println("Please indicate your role in ChocAn");
			System.out.println("1 = Manager");
			System.out.println("2 = Operator");
			System.out.println("3 = Provider");
			System.out.println("Or enter 4 to run the Main Accounting Procedure");
		

		MemberDatabase MemberDatabase = new MemberDatabase();

			Scanner input = new Scanner(System.in);
			initialAction = input.nextInt();
			
			if(initialAction != 1 && initialAction != 2 && initialAction != 3 && initialAction != 4) {
				System.out.println("Invalid entry. Please try again.");
			}
		}

		MemberDatabase.deleteMember("11880129");
		
		Member Jared = new Member();
		Jared.setCity("Oxford");
		Jared.setEmail("jtfolden@crimson.ua.edu");
		Jared.setIDNumber("11880129");
		Jared.setName("Jared Folden");
		Jared.setState("MI");
		Jared.setStreetAddress("34 Spring Lake Drive");
		Jared.setZip("48371");
		Jared.setSuspended(false);
		MemberDatabase.addMember(Jared);
		String[] MemberID = MemberDatabase.getAllMemberID();
		for (int i=0; i < MemberID.length; i++) {
			System.out.println(MemberID[i]);
		}
		
		ProviderDirectory providerDirectory = new ProviderDirectory();
		String serviceName = "";
		String serviceFee = "";
		
		serviceName = providerDirectory.getServiceName("598470");
		serviceFee = providerDirectory.getServiceFee("598470");
		
		System.out.println("Service Name: " + serviceName);
		System.out.println("Service Fee: " + serviceFee);
		providerDirectory.getAllServices();

		if(initialAction == 1) {
			System.out.println("Request Reports stub");
		}
		else if(initialAction == 2) {
			InteractiveModeTerminal interactiveModeTerminal = new InteractiveModeTerminal();
			System.out.println("Interactive mode stub");
		}
		else if(initialAction == 3) {
			int providerAction = 0;
			System.out.println("What action would you like to perform?");
			System.out.println("1 = Bill ChocAn");
			System.out.println("2 = Request Provider Directory");
			
			
			
			BillChocAn billChocAn = new BillChocAn();
			billChocAn.displayProviderDirectory();
		}

	}
	
	
}