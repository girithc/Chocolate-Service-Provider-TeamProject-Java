package chocan;

import java.util.Scanner;
import java.io.*;

public class ProviderDirectory {
	

public void getAllServices() throws Exception {
	
	Scanner sc = new Scanner(new File("ServicesOffered.csv"));
	sc.useDelimiter(",");
	while (sc.hasNext()) {
		System.out.print(sc.next());
	}
	sc.close();
	
}

public String getServiceName(String serviceCode) throws Exception {
	String returnItem = "";
	ServicesOffered servicesOffered = new ServicesOffered();
	returnItem = servicesOffered.getServiceName(serviceCode);
	return returnItem;
}

public String getServiceFee(String serviceCode) throws Exception {
	String returnItem = "";
	ServicesOffered servicesOffered = new ServicesOffered();
	returnItem = servicesOffered.getServiceFee(serviceCode);	
	return returnItem;
}

}