package chocan;
import java.io.FileNotFoundException;
import java.util.Scanner;  // Import the Scanner class


public class InteractiveModeControl {
	
	public static void addMember() throws Exception{
		
		MemberDatabase mbase =  new MemberDatabase();

		Member newMember = new Member();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name:");
		String name = sc.nextLine();
		
		newMember.setName(name);
		
		System.out.println("Enter Id:");
		String Id = sc.nextLine();
		
		newMember.setIDNumber(Id);
		
		System.out.println("Enter email:");
		String email = sc.nextLine();
		
		newMember.setEmail(email);
		
		System.out.println("Enter street Address:");
		String streetAddress = sc.nextLine();
		
		newMember.setStreetAddress(streetAddress);
		
		System.out.println("Enter city:");
		String city = sc.nextLine();
		
		newMember.setCity(city);
		
		System.out.println("Enter state:");
		String state = sc.nextLine();
		
		newMember.setState(state);
		
		System.out.println("Enter Zip code:");
		String zip = sc.nextLine();
		
		newMember.setZip(zip);
		newMember.setSuspended(false);
		
		sc.close();
		
		//mbase.addMember(newMember);
		//String[] MemberID = mbase.getAllMemberID();
		//for (int i=0; i < MemberID.length; i++) {
		//	System.out.println(MemberID[i]);
		//}
		
		
		//printMember(newMember);	
		
	}
	
	public static void deleteMember() throws Exception{
		MemberDatabase mbase =  new MemberDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		String Id = sc.nextLine();
		
		sc.close();
		
		mbase.deleteMember(Id);
		//String[] MemberID = mbase.getAllMemberID();
		//for (int i=0; i < MemberID.length; i++) {
		//	System.out.println(MemberID[i]);
		//}
		
		
	}
	
	public static void updateMember() throws Exception{
		
		MemberDatabase mbase =  new MemberDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		String IdMember = sc.nextLine();
		Member temp = mbase.getMember(IdMember);
		
		System.out.println("Update Record:");
		
		System.out.println("Enter name:(" + temp.getName() + ")");
		String name = sc.nextLine();
		
		temp.setName(name);
		
		System.out.println("Enter Id:(" + temp.getIDNumber() + ")");
		String Id = sc.nextLine();
		
		temp.setIDNumber(Id);
		
		System.out.println("Enter email:(" + temp.getEmail() + ")");
		String email = sc.nextLine();
		
		temp.setEmail(email);
		
		System.out.println("Enter street Address:(" + temp.getStreetAddress() + ")");
		String streetAddress = sc.nextLine();
		
		temp.setStreetAddress(streetAddress);
		
		System.out.println("Enter city:(" + temp.getCity() + ")");
		String city = sc.nextLine();
		
		temp.setCity(city);
		
		System.out.println("Enter state:(" + temp.getState() + ")");
		String state = sc.nextLine();
		
		temp.setState(state);
		
		System.out.println("Enter Zip code:(" + temp.getZip() + ")");
		String zip = sc.nextLine();
		
		temp.setZip(zip);
		
		sc.close();
		
		mbase.updateMember(IdMember, temp);
		//String[] MemberID = mbase.getAllMemberID();
		//for (int i=0; i < MemberID.length; i++) {
		//	System.out.println(MemberID[i]);
		//}
		
		
	}

	
	public static void printMember(Member p) {
		

		System.out.println("Member added:");
		System.out.println("Name: "+ p.getName());
		System.out.println("Id: " + p.getIDNumber());
		System.out.println("Email: "+ p.getEmail());
		System.out.println("Street Address: "+ p.getStreetAddress());
		System.out.println("City: "+ p.getCity());
		System.out.println("State: "+ p.getState());
		System.out.println("Zip Code: "+ p.getZip());


	}

}
