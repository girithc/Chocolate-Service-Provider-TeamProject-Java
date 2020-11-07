package chocan;

import java.io.*;
import java.util.Scanner;

public class ServicesOffered {
public void read(String string) throws Exception {
    Scanner sc = new Scanner(new File("ProviderDirectory.csv"));
    sc.useDelimiter(",");
    while(sc.hasNext()) {
        System.out.print(sc.next());
    }
    sc.close();
}
}