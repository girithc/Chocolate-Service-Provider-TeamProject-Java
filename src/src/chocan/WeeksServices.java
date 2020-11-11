package chocan;
import java.util.*;

public class WeeksServices {
	
	private int serviceCount;
	private LinkedList<ServicePerformed> weeksServices;
	
	public void addService(ServicePerformed service) {
		weeksServices.add(service);
		serviceCount++;
	}
	
	
	public void deleteService(ServicePerformed service) {
		if(weeksServices.remove(service)) {
			serviceCount++;
		}
	}
	
	
	public ServicePerformed[] getServicesByProvider(int id) {
		ServicePerformed[] providerServices = new ServicePerformed[100];
		int providerServiceCount = 0;
		for(int i = 0; i < serviceCount; i++) {
			ServicePerformed current = weeksServices.get(i);
			if(current.getProviderNumber() == id) {
				providerServices[providerServiceCount] = current;
				providerServiceCount++;
			}
		}
		return providerServices;
	}
	
	
	public ServicePerformed[] getServicesByMember(int id) {
		ServicePerformed[] memberServices = new ServicePerformed[100];
		int memberServiceCount = 0;
		for(int i = 0; i < serviceCount; i++) {
			ServicePerformed current = weeksServices.get(i);
			if(current.getMemberNumber() == id) {
				memberServices[memberServiceCount] = current;
				memberServiceCount++;
			}
		}
		return memberServices;
	}
	
	
	public void newWeek() {
		weeksServices.clear();
		serviceCount = 0;
	}
	
	private void printList() {
		System.out.print(weeksServices);
	}
	
	private void printArray(ServicePerformed[] services, int count) {
		for(int i = 0; i < count; i++) {
			//ServicePerformed current = services[i];
			System.out.print(services[i]);
		}
	}
	
	//public static in
		
	//}

}
