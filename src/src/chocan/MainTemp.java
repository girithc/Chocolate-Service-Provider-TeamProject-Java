package chocan;

import java.io.*;
import java.util.Scanner;

// using this to test WriteReports

public class MainTemp {
	
	public static void main(String[] args) throws Exception {

	WriteReports writeReports = new WriteReports();
	String code = "11862114";
	//writeReports.writeMemberReport(code);
	writeReports.writeProviderReport(code);
	
	WeeksServices test = new WeeksServices();
	ServicePerformed service1 = new ServicePerformed();
	//ServicePerformed service2 = new ServicePerformed();
	service1.setCurrDateAndTime("11-10-2020");
	service1.setDateProvided("11-10-2020");
	service1.setProviderNumber(999999);
	service1.setMemberNumber(111111);
	service1.setServiceCode("893292");
	service1.setComments("Really great session!");
	test.addService(service1);
	//test.addService(service2);
	
	writeReports.writeMemberReport(code);
	
	}
}
