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
		
			Scanner input = new Scanner(System.in);
			initialAction = input.nextInt();
			
			if(initialAction != 1 && initialAction != 2 && initialAction != 3 && initialAction != 4) {
				System.out.println("Invalid entry. Please try again.");
			}
		}
		
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