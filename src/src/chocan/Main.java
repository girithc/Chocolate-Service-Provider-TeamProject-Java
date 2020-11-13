package chocan;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String initialAction = "0";
		while(!initialAction.equals("1") && !initialAction.equals("2") && !initialAction.equals("3") && !initialAction.equals("4")) {
			System.out.println("Please indicate your role in ChocAn");
			System.out.println("Enter 1 for Manager");
			System.out.println("Enter 2 for Operator");
			System.out.println("Enter 3 for Provider");
			System.out.println("Or enter 4 to run the Main Accounting Procedure");
		
			MemberDatabase MemberDatabase = new MemberDatabase();
		
			//Scanner input = new Scanner(System.in);
			
			try {
				initialAction = input.nextLine().trim();
			}
			catch(InputMismatchException e) {
				initialAction = "0";
			}
			
			if(!initialAction.equals("1") && !initialAction.equals("2") && !initialAction.equals("3") && !initialAction.equals("4")) {
				System.out.println("Invalid entry. Please try again.");
			}
		}

		if(initialAction.equals("1")) {
			String reportType = "0";
			while(reportType != "1" && reportType != "2" && reportType != "3" && reportType != "4") {
				System.out.println("What type of report would you like to request?");
				System.out.println("Enter 1 for Member Report");
				System.out.println("Enter 2 for Provider Report");
				System.out.println("Enter 3 for Summary Report");
				System.out.println("Enter 4 for EFT Report");
				//Scanner input = new Scanner(System.in);
				
				try {
					reportType = input.nextLine().trim();
				}
				catch(InputMismatchException e) {
					reportType = "0";
				}
				
				if(reportType != "1" && reportType != "2" && reportType != "3" && reportType != "4") {
					System.out.println("Invalid entry. Please try again.");
				}
			}
			
			if(reportType == "1") {
				System.out.println("Input the ID number for the member report you would like to generate.");
				System.out.println("Enter 0 if you would like to generate all member reports.");
				
				//Scanner input = new Scanner(System.in);
				String memberID = input.nextLine().trim();
				
				WriteReports writeReports = new WriteReports();
				writeReports.writeMemberReport(memberID);
				System.out.println("Member report generated.");
			}
			else if(reportType == "2") {
				System.out.println("Input the ID number for the provider report you would like to generate.");
				System.out.println("Enter 0 if you would like to generate all provider reports.");
				
				//Scanner input = new Scanner(System.in);
				String providerID = input.nextLine().trim();
				
				WriteReports writeReports = new WriteReports();
				writeReports.writeProviderReport(providerID);
				System.out.println("Provider report generated.");
			}
			else if(reportType == "3") {
				WriteReports writeReports = new WriteReports();
				writeReports.writeSummaryReport();
				System.out.println("Summary report generated.");
			}
			else if(reportType == "4") {
				WriteReports writeReports = new WriteReports();
				writeReports.writeEFTReport();
				System.out.println("EFT report generated.");
			}
		}
		
		else if(initialAction.equals("2")) {
			InteractiveModeTerminal interactiveModeTerminal = new InteractiveModeTerminal();
			System.out.println("Welcome to Interactive Mode!");
			interactiveModeTerminal.promptForMemberOrProvider(input);
			interactiveModeTerminal.promptForAction(input);
			interactiveModeTerminal.performAction();
		}
		
		else if(initialAction.equals("3")) {
			int providerAction = 0;
			System.out.println("What action would you like to perform?");
			System.out.println("1 = Bill ChocAn");
			System.out.println("2 = Request Provider Directory");
			
			
			
			BillChocAn billChocAn = new BillChocAn();
			billChocAn.displayProviderDirectory();
		}
	}
	
	
}