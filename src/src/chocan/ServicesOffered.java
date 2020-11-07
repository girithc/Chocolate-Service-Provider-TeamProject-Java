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

public void getServiceName(String serviceCode) throws Exception {
	int bool = 0;
	String line = "";
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("ServicesOffered.csv"));
	while((line = br.readLine())!= null) {
		String[] servicesOffered = line.split(splitBy);
		if (servicesOffered[0].equals(serviceCode)) {
			System.out.println(servicesOffered[1]);
			bool = 1;
		}
	}
	if (bool == 0) {
		System.out.print("Service code entered is invalid.");
	}
	br.close();
}

public void getServiceFee(String serviceCode) throws Exception {
	int bool = 0;
	String line = "";
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("ServicesOffered.csv"));
	while((line = br.readLine())!= null) {
		String[] servicesOffered = line.split(splitBy);
		if (servicesOffered[0].equals(serviceCode)) {
			System.out.println(servicesOffered[2]);
			bool = 1;
		}
	}
	if (bool == 0) {
		System.out.print("Service code entered is invalid.");
	}
	br.close();
}

}