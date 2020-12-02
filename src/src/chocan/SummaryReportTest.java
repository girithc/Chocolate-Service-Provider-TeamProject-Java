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
	public void validReport() throws Exception {
		
		report.writeSummaryReport();							//Call writeProviderReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("Summary.txt");				//Open the provider file written by writeSummaryReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertEquals("Provider name: Jared Folden", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		assertEquals("	Total number of consulatations with members: 3" , currentLine); 
		currentLine = scanSummary.nextLine();
		assertEquals("	Total fee: $160", currentLine); // service: dietitian  fee: 50
		
		scanSummary.close();			//Close the scanner
					
		//fail("Not yet implemented");
	}
	
	@Test
	public void invalidReport() throws Exception {
		
		report.writeSummaryReport();							//Call writeProviderReport. Test with a predetermined entry in provider database
										
		
		File summaryReport = new File("Summary.txt");				//Open the provider file written by writeSummaryReport
		Scanner scanSummary = new Scanner(summaryReport);
		String currentLine;
		currentLine = scanSummary.nextLine();
		assertNotEquals("Should not be equal", "", currentLine);		//Scan each line of the file to match the test input
		currentLine = scanSummary.nextLine();
		assertNotEquals("Should not be equal", "", currentLine);
		currentLine = scanSummary.nextLine();
		assertNotEquals("Should not be equal", "", currentLine); // service: dietitian  fee: 50
		
		scanSummary.close();			//Close the scanner
					
		
	}

}

