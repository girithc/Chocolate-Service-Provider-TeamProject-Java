package chocan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicesOfferedDirectoryTest {

	ServicesOffered servicesOffered;
	
	@BeforeEach
	void setUp() throws Exception {
		servicesOffered = new ServicesOffered();
	}

	@Test
	void successFeeTest() throws Exception {
		String serviceFee;
		serviceFee = servicesOffered.getServiceFee("598470");
		assertEquals("50", serviceFee);
	}
	
	@Test
	void successNameTest() throws Exception {
		String serviceName;
		serviceName = servicesOffered.getServiceName("598470");
		assertEquals("dietician", serviceName);
	}
	
	@Test
	void invalidNumberFeeTest() throws Exception {
		String serviceFee;
		serviceFee = servicesOffered.getServiceFee("59470");
		assertEquals("", serviceFee);
	}
	
	@Test
	void invalidNumberNameTest() throws Exception {
		String serviceName;
		serviceName = servicesOffered.getServiceName("59470");
		assertEquals("", serviceName);
	}
	
	

}
