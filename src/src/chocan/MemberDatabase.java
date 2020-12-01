package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MemberDatabase {
	
	private LinkedList<Member> Members;
	
	/**
	 * Constructor for the Member database
	 * @throws FileNotFoundException when the Member database .csv file cannot be found
	 */
	public MemberDatabase() throws FileNotFoundException {
		
		Members = new LinkedList<Member>(); // Creating the Members linked list
		File database = new File("MemberDatabase.csv"); //Opening the .csv file
		
		Scanner reader = new Scanner(database); // Created the scanner object to read the file
		
		
		while(reader.hasNextLine()) { // While there are still more Members
			String MemberDataLine = reader.nextLine(); //Read the whole line of data
			if (MemberDataLine.equals("\n")) {
				break;
			}
			String[] MemberData = MemberDataLine.split(",", 0); // Split line into an array along the tabs since it is a tab delimited
			// 0 = name
			// 1 = IDNumber
			// 2 = email
			// 3 = streetAddress
			// 4 = city
			// 5 = state
			// 6 = zip
			// 7 = suspended
			Member Member = new Member();
			Member.setName(MemberData[0]);
			Member.setIDNumber(MemberData[1]);
			Member.setEmail(MemberData[2]);
			Member.setStreetAddress(MemberData[3]);
			Member.setCity(MemberData[4]);
			Member.setState(MemberData[5]);
			Member.setZip(MemberData[6]);
			if(MemberData[7].equals("TRUE")) {
				Member.setSuspended(true);
			}
			else {
				Member.setSuspended(false);
			}
			
			Members.add(Member); // Adding to database
		}
		
		reader.close(); // Closing the reader object
	}
	
	/**
	 * Private method used to rewrite the MemberDatabase.csv file whenever a change is made
	 * @throws IOException
	 */
	private void updateDatabase() throws IOException {
		File database = new File("MemberDatabase.csv"); // Opening the .csv file
		FileWriter writer = new FileWriter(database, false); // Creating the writer object
		
		ListIterator<Member> listIterator = Members.listIterator(); //Creating a list iterator to go through the Members linked list
		while (listIterator.hasNext()) { // While there are still Members
			Member current = listIterator.next();
			// This will create a tab delimited list in the proper order
			writer.write(current.getName() + ",");
			writer.write(current.getIDNumber() + ",");
			writer.write(current.getEmail() + ",");
			writer.write(current.getStreetAddress() + ",");
			writer.write(current.getCity() + ",");
			writer.write(current.getState() + ",");
			writer.write(current.getZip() + ",");
			writer.write(current.getSuspended() + "\n");
		}
		writer.close(); // Closing the writer object
	}
	
	/**
	 * Used to request a Member
	 * @param id, the id of the Member being requested
	 * @return the Member object if the Member exists, 
	 * @return returns an empty Member object with the name "Member not found" if the Member does not exist
	 * @throws Exception
	 */
	public Member getMember(String id) throws Exception{
		
		ListIterator<Member> listIterator = Members.listIterator(); // Creating list iterator object
		while (listIterator.hasNext()) { // While there are still Members
			Member current = listIterator.next();
			if(current.getIDNumber().equals(id)) { //Check if that Member has the desired id
				return current; // Return if it does
			}
		}
		
		// THIS WILL ONLY HAPPEN IF THE Member WAS NOT FOUND. OTHERWISE, THE FUNCTION WOULD HAVE RETURNED BY NOW
		Member dummyMember = new Member(); 
		dummyMember.setName("Member not found");
		return dummyMember;
	}
	
	/**
	 * Used to add a Member to database
	 * @param newMember, Member object of Member to be added
	 * @throws IOException
	 */
	public void addMember(Member newMember) throws IOException {
		
		Members.add(newMember);//Adding Member to linked list
		updateDatabase(); //Rewriting .csv file with new Member
		
	}
	
	/**
	 * Used to delete a Member from database
	 * @param id, the id of the Member to be deleted
	 * @throws Exception
	 */
	public void deleteMember(String id) throws Exception{
		
		ListIterator<Member> listIterator = Members.listIterator(); //Creating list iterator
		while (listIterator.hasNext()) {//While more Members still
			Member current = listIterator.next();
			if(current.getIDNumber().equals(id)) { //If Member has the desired id
				Members.remove(current); //Removing Member
				break;
			}
		}
		
		updateDatabase(); // Rewriting .csv
	}
	
	/**
	 * Replaces a Member
	 * @param id, id of Member to be updated
	 * @param Member
	 * @throws Exception
	 */
	public void updateMember(String id, Member Member) throws Exception{
		
		deleteMember(id); //Deleting previous instance of Member
		addMember(Member); //Adding new instance
	
	}
	
	/**
	 * Used to get a list of all the Member IDs
	 * @return a string array of all the Member IDs
	 * @throws Exception
	 */
	public String[] getAllMemberID() throws Exception{
		
		ListIterator<Member> listIterator = Members.listIterator();//Creating list iterator
		int size = Members.size(); //Getting the size of the Members linked list
		String MemberID[] = new String[size]; //Creating a string array the size of the Member list
		while (listIterator.hasNext()) { //While more Members still
			Member current = listIterator.next();
			MemberID[Members.indexOf(current)] = current.getIDNumber(); //Adding their id to the linked list
		}
		
		return MemberID;
		
		
	}
	
	/**
	 * Used to find is a particular Provider exists by ID number
	 * @param id 
	 * @return a boolean returning true if found
	 */
	public Boolean searchMember(String id) {
		
		ListIterator<Member> listIterator = Members.listIterator();//Creating list iterator
		while (listIterator.hasNext()) { //While more providers still
			Member current = listIterator.next();
			if(current.getIDNumber().equals(id)) {
				return true;
			} 
		}
		return false;
	}
	
	
}
