package chocan;

import java.util.Scanner;
import java.io.*;

public class ProviderDirectory {
	
/**
 * Prints out the provider directory
 * @throws Exception
 */
public String[] getAllServices() throws Exception {
	
	Scanner sc = new Scanner(new File("ServicesOffered.csv"));
	String[] services = new String[100];
	int count = 0;
	sc.useDelimiter(",");
	while (sc.hasNext()) {
		String temp = sc.next();
		System.out.print(temp);
		services[count] = temp;
		count++;
	}
	sc.close();
	return services;
	
}

public String[][] returnAllServices() throws Exception {
	
	Scanner sc = new Scanner(new File("ServicesOffered.csv"));
	String[][] services = new String[10][3];
	int count = 0;
	//sc.useDelimiter(",");
	while (sc.hasNextLine()) {
		String line = sc.nextLine();
		String[] temp = line.split(",", 0);
		services[count]= temp;
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		count++;
	}
	sc.close();
	return services;
	
}

/**
 * Returns a service name given the service code
 * @param serviceCode
 * @return service name
 * @throws Exception
 */
public String getServiceName(String serviceCode) throws Exception {
	String returnItem = "";
	ServicesOffered servicesOffered = new ServicesOffered();
	returnItem = servicesOffered.getServiceName(serviceCode);
	return returnItem;
}

/**
 * Returns a service fee given the service code
 * @param serviceCode
 * @return service fee
 * @throws Exception
 */
public String getServiceFee(String serviceCode) throws Exception {
	String returnItem = "";
	ServicesOffered servicesOffered = new ServicesOffered();
	returnItem = servicesOffered.getServiceFee(serviceCode);	
	return returnItem;
}

}