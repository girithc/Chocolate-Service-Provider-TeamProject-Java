package chocan;

import java.io.*;
import java.util.Scanner;

public class ServicesOffered {
	
public void read(String string) throws Exception {
	File providerDirectory = new File("ServicesOffered.csv");
    Scanner sc = new Scanner(providerDirectory);
    sc.useDelimiter(",");
    while(sc.hasNext()) {
        System.out.print(sc.next());
    }
    sc.close();
}

}