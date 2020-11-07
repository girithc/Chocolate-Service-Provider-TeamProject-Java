package chocan;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//MemberDatabase MemberDatabase = new MemberDatabase();
		
		//MemberDatabase.deleteMember("11880129");
		
		/*Member Jared = new Member();
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
			System.out.println(MemberID[i]);*/
		//}
		
		ProviderDirectory providerDirectory = new ProviderDirectory();
		String serviceName = "";
		String serviceFee = "";
		
		serviceName = providerDirectory.getServiceName("598470");
		serviceFee = providerDirectory.getServiceFee("598470");
		
		System.out.println("Service Name: " + serviceName);
		System.out.println("Service Fee: " + serviceFee);
		providerDirectory.getAllServices();
	}
	
}