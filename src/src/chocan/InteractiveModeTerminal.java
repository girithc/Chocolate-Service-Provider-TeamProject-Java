package chocan;

import java.util.Scanner;  // Import the Scanner class


public class InteractiveModeTerminal {

  public InteractiveModeTerminal() {

  }

  /**
   * Prompts for user input to choose action
   * @return String holding the action chosen by the user
   * @author annekatherinefike
   */
  public String promptForAction() {

    System.out.println("Choose an action to be performed");
	System.out.println("Enter '1' for Add Record");
	System.out.println("Enter '2' for Delete Record");
	System.out.println("Enter '3' for Update Record");
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	String action = myObj.nextLine();
	myObj.close();
	return action;
	
  }
	/**
	 * Prompts for user input to choose if the action is to be done for a member or provider
	 * @return String holding the user's input 
	 * @author annekatherinefike
	 */
  public String promptForMemberOrProvider() {

    System.out.println("Choose to perform action for either a member or provider.");
    System.out.println("Enter '1' to choose member");
	System.out.println("Enter '2' to choose provider");
	
	Scanner mObj = new Scanner(System.in);
	
	String action = mObj.nextLine();
	mObj.close();
	return action;
	
	}
	
  /**
   * Performs action based on return values of promptForAction and promptForMemberOrProvider
   * @param action
   * @param memberOrProvider
   * @author annekatherinefike
 * @throws Exception 
   */
  public void performAction(String action, String memberOrProvider) throws Exception {
		
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
		
	}

}
