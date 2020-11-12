package chocan;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InteractiveModeTerminal {

	
	public InteractiveModeTerminal() {
		
	}
	
	public void promptForAction() {
		
	}
	
	public void promptForMemberOrProvider() {
		
	}
	
	public void performAction() {
		
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
