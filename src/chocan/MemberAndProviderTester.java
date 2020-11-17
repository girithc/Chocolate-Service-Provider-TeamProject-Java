package chocan;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class MemberAndProviderTester {

	WriteReports report;
	
	@Before
	public void setUp() throws Exception {
		report = new WriteReports();
	}

	@Test
	public void test() throws Exception {
		
		report.writeProviderReport("0");							//Call writeProviderReport. Test with a predetermined entry in provider database
		report.writeMemberReport("0");								//Call writeMemberReport. Test with a predetermined entry in member database
		
		
		File providerReport = new File("Provider.txt");				//Open the provider file written by writeProviderReport
		Scanner scanProvider = new Scanner(providerReport);
		String currentLine;
		
		currentLine = scanProvider.nextLine();
		assertEquals("Provider name: Sam Noyes", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanProvider.nextLine();
		assertEquals("Provider number: 11547298", currentLine);
		currentLine = scanProvider.nextLine();
		assertEquals("Provider street address: 608 6th Avenue", currentLine);
		currentLine = scanProvider.nextLine();
		assertEquals("Provider state: AL", currentLine);
		currentLine = scanProvider.nextLine();
		assertEquals("Provider ZIP code: 35404", currentLine);
		
		scanProvider.close();			//Close the scanner
		
		File memberReport = new File("Member.txt");				//Open the provider file written by writeMemberReport
		Scanner scanMember = new Scanner(memberReport);
		
		currentLine = scanMember.nextLine();
		assertEquals("Member name: Sam Noyes", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanMember.nextLine();
		assertEquals("Member number: 11547298", currentLine);
		currentLine = scanMember.nextLine();
		assertEquals("Member street address: 608 6th Avenue", currentLine);
		currentLine = scanMember.nextLine();
		assertEquals("Member state: AL", currentLine);
		currentLine = scanMember.nextLine();
		assertEquals("Member ZIP code: 35404", currentLine);
		
		scanMember.close();			//Close the scanner
		
		fail("Not yet implemented");
	}

}
