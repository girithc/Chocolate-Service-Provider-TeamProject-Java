package chocan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddServicePerformedTest {

	@Before
	public void setUp() throws Exception {
		
		WeeksServices weeksServices = new WeeksServices();
		ServicePerformed servicePerformed = new ServicePerformed();
		
		servicePerformed.setCurrDateAndTime("11-30-2020 11:33:20");
		servicePerformed.setDateProvided("11-05-2020");
		servicePerformed.setProviderNumber("11934579");
		servicePerformed.setMemberNumber("11862114");
		servicePerformed.setServiceCode("598470");
		servicePerformed.setComments("Great session");
		
		weeksServices.addService(servicePerformed);
	}

	@Test
	public void testForSuccess1() throws Exception {
		
		WeeksServices weeksServices = new WeeksServices();
		ServicePerformed[] mServices = new ServicePerformed[100];
		mServices = weeksServices.getServicesByMember("11862114");
		
		
		assertEquals("11-05-2020", mServices[mServices.length - 1].getDateProvided());
		
		/*String pID = mServices[mServices.length - 1].getProviderNumber();
		ProviderDatabase pDatabase = new ProviderDatabase();
		Provider p = new Provider();
		p = pDatabase.getProvider(pID);
		
		assertEquals("Haya Calhoun", p.getName());*/
		
		String sCode = mServices[mServices.length - 1].getServiceCode();
		ServicesOffered servicesOffered = new ServicesOffered();
		
		assertEquals("dietician", servicesOffered.getServiceName(sCode));
	}
	
	@Test
	public void testForSuccess2() throws Exception {
		
		WeeksServices weeksServices = new WeeksServices();
		ServicePerformed[] mServices = new ServicePerformed[100];
		mServices = weeksServices.getServicesByMember("11862114");
		
		String pID = mServices[mServices.length - 1].getProviderNumber();
		ProviderDatabase pDatabase = new ProviderDatabase();
		Provider p = new Provider();
		p = pDatabase.getProvider(pID);
		
		assertEquals("Haya Calhoun", p.getName());
		
	}
	
	@Test
	public void testForFailure() throws Exception {
		
		WeeksServices weeksServices = new WeeksServices();
		ServicePerformed servicePerformed = new ServicePerformed();
		
		servicePerformed.setCurrDateAndTime("11-30-2020 11:33:20");
		servicePerformed.setDateProvided("11-05-2020");
		servicePerformed.setProviderNumber("11934579");
		servicePerformed.setMemberNumber("11862114");
		servicePerformed.setServiceCode("000000");
		servicePerformed.setComments("Great session");
		
		weeksServices.addService(servicePerformed);
		
		ServicePerformed[] mServices = new ServicePerformed[100];
		mServices = weeksServices.getServicesByMember("11862114");
		
		String sCode = mServices[mServices.length - 1].getServiceCode();		
		ServicesOffered servicesOffered = new ServicesOffered();
		
		assertEquals("", servicesOffered.getServiceName(sCode));
		
	}

}
