package src.chocan;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;  // Import the Scanner class


public class InteractiveModeControl {
	
	public InteractiveModeControl(){
		
	}
	
	public Member getMember(String id) throws Exception {
		MemberDatabase memberDatabase = new MemberDatabase();
		return memberDatabase.getMember(id);
	}
	
	public Provider getProvider(String id) throws Exception {
		ProviderDatabase providerDatabase = new ProviderDatabase();
		return providerDatabase.getProvider(id);
	}
	

	public void addMember(Member newMember) throws Exception{
		
		MemberDatabase mbase =  new MemberDatabase();

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
		
		mbase.addMember(newMember);
		
		System.out.println("Member added.");
		
	}
	
	public void deleteMember() throws Exception{
		MemberDatabase mbase =  new MemberDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		String Id = sc.nextLine();
		
		System.out.println("The details for the member you would like to delete are given below:\n");
		printMember(mbase.getMember(Id));
		System.out.println("\nAre you sure would like to delete this member?");
		System.out.println("Enter 1 for yes");
		System.out.println("Enter 2 for no");
		
		String confirmation = sc.nextLine().trim();
		
		if(confirmation.equals("1")) {
			mbase.deleteMember(Id);
			System.out.println("Member deleted.");
		}
		
	}
	
	public void updateMember(String IdMember, Member temp) throws Exception{
		
		MemberDatabase mbase =  new MemberDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		IdMember = sc.nextLine();
		temp = mbase.getMember(IdMember);
		
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
		
		mbase.updateMember(IdMember, temp);
		
		System.out.println("Member updated.");
		
		
	}

	
public void addProvider(Provider newProvider) throws Exception{
		
		ProviderDatabase pbase =  new ProviderDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name:");
		String name = sc.nextLine();
		
		newProvider.setName(name);
		
		System.out.println("Enter Id:");
		String Id = sc.nextLine();
		
		newProvider.setIDNumber(Id);
		
		System.out.println("Enter email:");
		String email = sc.nextLine();
		
		newProvider.setEmail(email);
		
		System.out.println("Enter street Address:");
		String streetAddress = sc.nextLine();
		
		newProvider.setStreetAddress(streetAddress);
		
		System.out.println("Enter city:");
		String city = sc.nextLine();
		
		newProvider.setCity(city);
		
		System.out.println("Enter state:");
		String state = sc.nextLine();
		
		newProvider.setState(state);
		
		System.out.println("Enter Zip code:");
		String zip = sc.nextLine();
		
		newProvider.setZip(zip);
		
		pbase.addProvider(newProvider);

		System.out.print("Provider added");
		
	}
	
	public void deleteProvider() throws Exception{
		ProviderDatabase pbase =  new ProviderDatabase();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		String Id = sc.nextLine().trim();
		
		
		System.out.println("The details for the provider you would like to delete are given below:\n");
		printProvider(pbase.getProvider(Id));
		System.out.println("\nAre you sure would like to delete this provider?");
		System.out.println("Enter 1 for yes");
		System.out.println("Enter 2 for no");
		
		String confirmation = sc.nextLine().trim();
		
		if(confirmation.equals("1")) {
			pbase.deleteProvider(Id);
			System.out.println("Provider deleted.");
		}
		
	}
	
	public void updateProvider(String IdProvider, Provider temp) throws Exception{
		
		ProviderDatabase pbase =  new ProviderDatabase();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		IdProvider = sc.nextLine();
		temp = pbase.getProvider(IdProvider);
		
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
		
		pbase.updateProvider(IdProvider, temp);
		System.out.println("Provider updated");
		
	}
	
	
	public void printMember(Member p) {
		

		System.out.println("Name: "+ p.getName());
		System.out.println("Id: " + p.getIDNumber());
		System.out.println("Email: "+ p.getEmail());
		System.out.println("Street Address: "+ p.getStreetAddress());
		System.out.println("City: "+ p.getCity());
		System.out.println("State: "+ p.getState());
		System.out.println("Zip Code: "+ p.getZip());


	}
	
public void printProvider(Provider p) {
		

		System.out.println("Name: "+ p.getName());
		System.out.println("Id: " + p.getIDNumber());
		System.out.println("Email: "+ p.getEmail());
		System.out.println("Street Address: "+ p.getStreetAddress());
		System.out.println("City: "+ p.getCity());
		System.out.println("State: "+ p.getState());
		System.out.println("Zip Code: "+ p.getZip());


	}
}
