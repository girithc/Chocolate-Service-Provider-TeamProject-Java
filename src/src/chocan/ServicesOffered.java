package chocan;

import java.io.*;
import java.util.*;

public class ServicesOffered {
	
	
/*public void read(String string) throws Exception {
	//File providerDirectory = new File("ServicesOffered.csv");
    //Scanner sc = new Scanner(providerDirectory);
    sc.useDelimiter(",");
    while(sc.hasNext()) {
        System.out.print(sc.next());
    }
    sc.close();
}*/

public void getServiceCode() {
	
}

public String getServiceName(String serviceCode) throws Exception {
	int bool = 0;
	String returnItem = "";
	String line = "";
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("ServicesOffered.csv"));
	while((line = br.readLine())!= null) {
		String[] servicesOffered = line.split(splitBy);
		if (servicesOffered[0].equals(serviceCode)) {
			System.out.println(servicesOffered[1]);
			returnItem = servicesOffered[1];
			bool = 1;
		}
	}
	if (bool == 0) {
		System.out.println("Service code entered is invalid.");
	}
	br.close();
	return returnItem;
}

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
			System.out.println(servicesOffered[2]);
			bool = 1;
		}
	}
	if (bool == 0) {
		System.out.println("Service code entered is invalid.");
	}
	br.close();
	return returnItem;
}

}