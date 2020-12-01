package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reset {
	
	public static void main(String[] args) throws IOException {
		File defaultDatabase = new File("MemberDatabaseDefault.csv");
		Scanner reader = new Scanner(defaultDatabase);
		
		File database = new File("MemberDatabase.csv");
		FileWriter writer = new FileWriter(database, false);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			if(line.substring(0,3).equals("﻿")) {
				line = line.substring(3);
			}
			writer.write(line + "\n");
		}
		
		reader.close();
		writer.close();

	
		defaultDatabase = new File("ProviderDatabaseDefault.csv");
		reader = new Scanner(defaultDatabase);
	
		database = new File("ProviderDatabase.csv");
		writer = new FileWriter(database, false);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			if(line.substring(0,3).equals("﻿")) {
				line = line.substring(3);
			}
			writer.write(line + "\n");
		}
		
		reader.close();
		writer.close();
	
		defaultDatabase = new File("WeeksServicesDatabaseDefault.csv");
		reader = new Scanner(defaultDatabase);
	
		database = new File("WeeksServicesDatabase.csv");
		writer = new FileWriter(database, false);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			if(line.substring(0,3).equals("﻿")) {
				line = line.substring(3);
			}
			writer.write(line + "\n");
		}
		
		reader.close();
		writer.close();
		
	}
}
