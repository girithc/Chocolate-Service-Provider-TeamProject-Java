package chocan;
import java.io.BufferedReader;
import java.util.Scanner;  // Import the Scanner class
import java.io.InputStreamReader;

public class InteractiveModeTerminal {

	
	public InteractiveModeTerminal() {
		
	}
	
	public String promptForAction() {
		
		System.out.println("Choose an action to be performed");
		System.out.println("Enter '1' for Add Record");
		System.out.println("Enter '2' for Delete Record");
		System.out.println("Enter '3' for Update Record");
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object

	    String action = myObj.nextLine();
	    
	    return action;
		
	}
	
	public String promptForMemberOrProvider() {
		
		System.out.println("Choose to perform action for either a member or provider.");
		System.out.println("Enter '1' to choose member");
		System.out.println("Enter '2' to choose provider");
		
		Scanner mObj = new Scanner(System.in);
		
		String action = mObj.nextLine();
		
		return action;
		
	}
	
	public void performAction(String action, String memberOrProvider) {
		
		if (action.equalsIgnoreCase("1") && memberOrProvider.equalsIgnoreCase("1")) {
			
			Member member = new Member();
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			//interactiveModeControl.addMember(member);
				
		}
		
		else if (action.equalsIgnoreCase("1") && memberOrProvider.equalsIgnoreCase("2")) {
			
			Provider provider = new Provider();
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			//interactiveModeControl.addProvider(provider);
				
		}
		
		else if (action.equalsIgnoreCase("2") && memberOrProvider.equalsIgnoreCase("1")) {
			
			Scanner mObj = new Scanner(System.in);
			System.out.println("Enter member ID of member to be deleted: ");
			
			String mID = mObj.nextLine();
			int mIDNum = Integer.parseInt(mID);
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			//interactiveModeControl.deleteMember(mIDNum);
				
		}
		
		else if (action.equalsIgnoreCase("2") && memberOrProvider.equalsIgnoreCase("2")) {
			
			Scanner mObj = new Scanner(System.in);
			System.out.println("Enter provider ID of provider to be deleted: ");
			
			String pID = mObj.nextLine();
			int pIDNum = Integer.parseInt(pID);
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			
			//interactiveModeControl.deleteProvider(pIDNum);
				
		}
		
		else if (action.equalsIgnoreCase("3") && memberOrProvider.equalsIgnoreCase("1")) {
			
			Scanner mObj = new Scanner(System.in);
			System.out.println("Enter member ID of member to be updated: ");
			
			String mID = mObj.nextLine();
			int mIDNum = Integer.parseInt(mID);
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			Member member = new Member();
			
			//member = interactiveModeControl.getMember(mIDNum);
			//interactiveModeControl.updateMember(mIDNum, member);
				
		}
		
		else if (action.equalsIgnoreCase("3") && memberOrProvider.equalsIgnoreCase("2")) {
			
			Scanner mObj = new Scanner(System.in);
			System.out.println("Enter provider ID of provider to be updated: ");
			
			String pID = mObj.nextLine();
			int pIDNum = Integer.parseInt(pID);
			
			InteractiveModeControl interactiveModeControl = new InteractiveModeControl();
			Provider provider = new Provider();
			
			//provider = interactiveModeControl.getProvider(pIDNum);
			//interactiveModeControl.updateMember(pIDNum, provider);
				
		}
		
		
		
		
	}
	

	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Select an action to be performed");
		System.out.println("Enter:");
		System.out.println("1 for Add Record");
		System.out.println("2 for Delete Record");
		System.out.println("3 for Update Record");
		
		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);

		int cType = 0; // Add / Edit / Delete
		int cRecord = 0; // Member / Provider
		try {
			String line = br.readLine();
			cType = Integer.parseInt(line);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong.");
		}
		
		//System.out.println("Thank you " + choice);

		
		if(cType > 0 && cType < 4) {
			
			System.out.println("Select record type");
			System.out.println("Enter:");
			System.out.println("1 for Member");
			System.out.println("2 for Provider");
			
			try {
				String line = br.readLine();
				cRecord = Integer.parseInt(line);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Something went wrong!!.");
			}
			
			
			
			if(cRecord == 1){ // Member
				if(cType == 1) {
					Member newMember = new Member();
					InteractiveModeControl.addMember(newMember);
				}
				else if(cType == 2) {
					
					InteractiveModeControl.deleteMember();
				}
				else {
					Member temp;
					String Id;
					InteractiveModeControl.updateMember(Id, temp);
				}
				
			}
			else if(cRecord == 2) {
				if(cType == 1) {
					Provider newProvider = new Provider();
					InteractiveModeControl.addProvider(newProvider);
				}
				else if(cType == 2) {
					
					InteractiveModeControl.deleteProvider();
				}
				else {
					Provider temp;
					String Id;
					InteractiveModeControl.updateProvider(Id, temp);
				}
			}
			
			
			
		}

		
		

	}*/

}
