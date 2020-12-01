package chocan;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class SummaryReportTest {

	WriteReports report;
	
	@Before
	public void setUp() throws Exception {
		report = new WriteReports();
	}

	@Test
	public void test() throws Exception {
		
		report.writeSummaryReport();							//Call writeProviderReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("Summary.txt");				//Open the provider file written by writeSummaryReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertEquals("Provider name: Rachel Nau", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		assertEquals("	Total number of consulatations with members: 0" , currentLine); 
		currentLine = scanSummary.nextLine();
		assertEquals(" Total fee: 0", currentLine); // service: dietitian  fee: 50
		
		scanSummary.close();			//Close the scanner
					
		//fail("Not yet implemented");
	}

}

