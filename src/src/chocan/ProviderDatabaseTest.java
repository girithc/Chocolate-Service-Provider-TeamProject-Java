package src.chocan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderDatabaseTest {

	ProviderDatabase providerDatabase;

	@BeforeEach
	void setUp() throws Exception {
		providerDatabase = new ProviderDatabase();
	}

	@Test
	void successTest1() throws Exception {
		
		 Provider mName = providerDatabase.getProvider("11862114");
		 String name =  mName.getName();
		 assertEquals("Rachel Nau", name);
	}
		
		@Test
		void failureTest() throws Exception {
			 Provider mName = providerDatabase.getProvider("1186");
			 String name =  mName.getName();
			 assertEquals("Provider not found", name);
	}
		@Test
		void successTest2() throws Exception {
			Provider mName = providerDatabase.getProvider("11547298");
			 String name =  mName.getName();
			 assertEquals("Sam Noyes", name);
			  
		}
		



}



	
