package chocan;

import java.io.*;
import java.util.Scanner;

// using this to test WriteReports

public class MainTemp {
	
	public static void main(String[] args) throws Exception {
		
	Scanner myObj = new Scanner(System.in);
	BillChocAn billchocan = new BillChocAn();
	billchocan.writeServiceReport(myObj);
	
	WriteReports writeReports = new WriteReports();
	String code = "11547298";
	writeReports.writeMemberReport(code);
	
	}
}