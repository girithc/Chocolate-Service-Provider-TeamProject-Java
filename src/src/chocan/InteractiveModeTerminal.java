package src.chocan;

import java.util.Scanner;  // Import the Scanner class


public class InteractiveModeTerminal {

	private String action;
	private String memberOrProvider;
	
	public InteractiveModeTerminal() {
		action = "0";
		memberOrProvider = "0";
	}

	  /**
	   * Prompts for user input to choose action
	   * @return String holding the action chosen by the user
	   * @author annekatherinefike
	   */
	public void promptForAction(Scanner myObj) {
		
		while(!action.equals("1") && !action.equals("2") && !action.equals("3")) {
			System.out.println("\nChoose an action to be performed");
			System.out.println("Enter 1 for Add Record");
			System.out.println("Enter 2 for Delete Record");
			System.out.println("Enter 3 for Update Record");
			action = myObj.nextLine().trim();
		
			if(!action.equals("1") && !action.equals("2") && !action.equals("3")) {
				System.out.println("Invalid entry. Please try again.");
			}
		}
		
	 }
	
	/**
	 * Prompts for user input to choose if the action is to be done for a member or provider
	 * @return String holding the user's input 
	 * @author annekatherinefike
	 */
	public void promptForMemberOrProvider(Scanner mObj) {
	
		while(!memberOrProvider.equals("1") && !memberOrProvider.equals("2")) {
			System.out.println("\nChoose to perform action for either a member or provider.");
			System.out.println("Enter 1 for member");
			System.out.println("Enter 2 for provider");
			memberOrProvider = mObj.nextLine().trim();
			
			if(!memberOrProvider.equals("1") && !memberOrProvider.equals("2")) {
				System.out.println("Invalid entry. Please try again.");
			}
		}
	
		
		
		
		
	}
		
	/**
	 * Performs action based on return values of promptForAction and promptForMemberOrProvider
	 * @author annekatherinefike
	 * @throws Exception 
	 */
	public void performAction() throws Exception {
			
		if (action.equalsIgnoreCase("1") && memberOrProvider.equalsIgnoreCase("1")) {
			
			Member member = new Member();
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			interactiveModeControl.addMember(member);
				
		}
		
		else if (action.equalsIgnoreCase("1") && memberOrProvider.equalsIgnoreCase("2")) {
			
			Provider provider = new Provider();
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			interactiveModeControl.addProvider(provider);
				
		}
		
		else if (action.equalsIgnoreCase("2") && memberOrProvider.equalsIgnoreCase("1")) {
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			interactiveModeControl.deleteMember();
				
		}
		
		else if (action.equalsIgnoreCase("2") && memberOrProvider.equalsIgnoreCase("2")) {
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			interactiveModeControl.deleteProvider();
				
		}
		
		else if (action.equalsIgnoreCase("3") && memberOrProvider.equalsIgnoreCase("1")) {
			
			String mID = "";
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			Member member = new Member();
			
			interactiveModeControl.updateMember(mID, member);
				
		}
		
		else if (action.equalsIgnoreCase("3") && memberOrProvider.equalsIgnoreCase("2")) {
			
			String pID = "";
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			Provider provider = new Provider();
			
			interactiveModeControl.updateProvider(pID, provider);
				
		}
		
		action = "0";
		memberOrProvider = "0";
		
	}
}

