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

public void getServiceName(String serviceCode) throws Exception {
	
	ServicesOffered servicesOffered = new ServicesOffered();
	servicesOffered.getServiceName(serviceCode);
	
}

public void getServiceFee(String serviceCode) throws Exception {
	
	ServicesOffered servicesOffered = new ServicesOffered();
	servicesOffered.getServiceFee(serviceCode);	
	
}

}