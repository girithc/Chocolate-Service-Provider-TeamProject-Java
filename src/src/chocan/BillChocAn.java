package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class BillChocAn extends ServicePerformed {
	ServicePerformed s1 = new ServicePerformed();
	ProviderDirectory p1 = new ProviderDirectory();
	public void lookUpService(String serviceCode) throws Exception 
	{
		p1.getServiceName(serviceCode);
	}
	public void displayProviderDirectory() throws Exception {
		p1.getAllServices();
	}
	public void writeServiceReport()
	{
		System.out.println("Current Date and Time:"+ s1.getCurrDateAndTime() );
		System.out.println("Date service was provided: "+ s1.getDateProvided());
		System.out.println("Provider Number: " + s1.getProviderNumber());
		System.out.println("Member number: "+ s1.getMemberNumber());
		System.out.println("Service code: "+ s1.getServiceCode());
	}
}
