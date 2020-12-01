package chocan;

import java.io.*;

public class ServicesOffered {
	
/**
 * Gets a service name given a service code
 * @param serviceCode
 * @return service name
 * @throws Exception
 */
public String getServiceName(String serviceCode) throws Exception {
	int bool = 0;
	String returnItem = "";
	String line = "";
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("ServicesOffered.csv"));
	while((line = br.readLine())!= null) {
		String[] servicesOffered = line.split(splitBy);
		if (servicesOffered[0].equals(serviceCode)) {
			returnItem = servicesOffered[1];
			//System.out.println("Debug: " + returnItem); //debug statement
			bool = 1;
		}
	}
	if (bool == 0) {
		ProviderTerminal pTerminal = new ProviderTerminal();
		pTerminal.notifyProvider("Service code entered is invalid.");
	}
	br.close();
	return returnItem;
}

/**
 * Gets a service fee given a service code
 * @param serviceCode
 * @return service fee
 * @throws Exception
 */
public String getServiceFee(String serviceCode) throws Exception {
	int bool = 0;
	String returnItem = "";
	String line = "";
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("ServicesOffered.csv"));
	while((line = br.readLine())!= null) {
		String[] servicesOffered = line.split(splitBy);
		if (servicesOffered[0].equals(serviceCode)) {
			returnItem = servicesOffered[2];
			//System.out.println(servicesOffered[2]); //debug statement
			bool = 1;
		}
	}
	if (bool == 0) {
		ProviderTerminal pTerminal = new ProviderTerminal();
		pTerminal.notifyProvider("Service code entered is invalid.");
	}
	br.close();
	return returnItem;
}

}