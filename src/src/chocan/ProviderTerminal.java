package chocan;
import java.io.FileNotFoundException;
import java.util.*;


public class ProviderTerminal extends BillChocAn {
 
	private int IDNumber;
	
	//public void swipeCard()
	//{
		
	//}
	
	
	public void enterIdNumber(String id) throws Exception
	{
		MemberDatabase m1 = new MemberDatabase();
		m1.getMember(id);
		
	}
	public void writeNewService() throws Exception
	{
		writeServiceReport();
	}
	public void notifyProvider(char valid)
	{
		
	}
	public void getProviderDirectory() throws Exception
	{
		displayProviderDirectory();
	}
	public char verifyMember(String id) throws Exception
	{
		MemberDatabase m2 = new MemberDatabase();
	char y = 0;
	char n = 0;
	if(	m2.getMember(id) != null)
		return y;
		else
		return n;
		
	}
}

