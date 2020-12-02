package chocan;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class EFTReportTest {

	WriteReports report;
	
	@Before
	public void setUp() throws Exception {
		report = new WriteReports();
		Reset.main(null);
	}

	@Test
	public void eftReportSuccessTest() throws Exception {
		
		report.writeEFTReport();							//Call writeEFTReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("EFT.txt");				//Open the provider file written by writeEFTReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertEquals("Provider name: Jared Folden", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		//assertEquals("	Amount to be paid $: 0" , currentLine); // service: dietitian  fee: 50
		assertEquals("	Amount to be paid $: 160" , currentLine);
		scanSummary.close();			//Close the scanner
					
		//fail("Not yet implemented");
	}
	
	@Test
	public void eftReportFailureTest() throws Exception {
		
		report.writeEFTReport();							//Call writeEFTReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("EFT.txt");				//Open the provider file written by writeEFTReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertNotEquals("Should not be equal", "", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		assertNotEquals("Should not be equal", "", currentLine);
		scanSummary.close();			//Close the scanner
					
		//fail("Not yet implemented");
	}

}

