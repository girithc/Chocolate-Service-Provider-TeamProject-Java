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
	}

	@Test
	public void test() throws Exception {
		
		report.writeEFTReport();							//Call writeEFTReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("Summary.txt");				//Open the provider file written by writeEFTReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertEquals("Provider name: Rachel Nau", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		//assertEquals("	Amount to be paid $: 0" , currentLine); // service: dietitian  fee: 50
		assertEquals("	Total number of consulatations with members: 0" , currentLine);
		scanSummary.close();			//Close the scanner
					
		//fail("Not yet implemented");
	}

}

