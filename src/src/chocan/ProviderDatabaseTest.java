package chocan;

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
		
		 Provider mName = providerDatabase.getProvider("11880129");
		 String name =  mName.getName();
		 assertEquals("Jared Folden", name);
	}
		
		@Test
		void failureTest1() throws Exception {
			 Provider mName = providerDatabase.getProvider("1186");
			 String name =  mName.getName();
			 assertEquals("Provider not found", name);
	}
		@Test
		void successTest2() throws Exception {
			Provider mName = providerDatabase.getProvider("87654321");
			 String name =  mName.getName();
			 assertEquals("Jake Bischoff", name);
			  
		}
		
		@Test
		void failureTest2() throws Exception {
			 Provider mName = providerDatabase.getProvider("11");
			 String name =  mName.getName();
			 assertEquals("Provider not found", name);
	}
		



}



	
