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
	void successTest() throws Exception {
		String serviceFee;
		serviceFee = servicesOffered.getServiceFee("598470");
		assertEquals("50", serviceFee);
	}

}
