package chocan;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class MemberandProviderTest {
	
	MemberDatabase members;
	ProviderDatabase providers;
	
	@Before
	public void setUp() throws Exception {
		members = new MemberDatabase();
		providers = new ProviderDatabase();
	}
	
	@Test
	public void providerNameSuccessTest() throws Exception {
		String name = providers.getProvider("11880129").getName();
		assertEquals("Jared Folden", name);
	}
	
	@Test
	public void memberNameSuccessTest() throws Exception {
		String name = members.getMember("11926699").getName();
		assertEquals("Anne Fike", name);
	}
	
	@Test
	public void providerNameFailureTest() throws Exception {
		String name = providers.getProvider("a").getName();
		assertEquals("Provider not found", name);
	}
	
	@Test
	public void memberNameFailureTest() throws Exception {
		String name = members.getMember("a").getName();
		assertEquals("Member not found", name);
	}

}
