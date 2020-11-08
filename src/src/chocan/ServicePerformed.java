package chocan;

public class ServicePerformed {
	
	private String currDateAndTime;
	private String dateProvided;
	private int providerNumber;
	private int memberNumber;
	private int serviceCode;
	private String comments;
	
	public void setCurrDateAndTime(String dateAndTime) {
		currDateAndTime = dateAndTime;
	}
	
	public String getCurrDateAndTime() {
		return currDateAndTime;
	}
	
	public void setDateProvided(String date) {
		dateProvided = date;
	}
	
	public String getDateProvided() {
		return dateProvided;
	}
	
	public void setProviderNumber(int id) {
		providerNumber = id;
	}
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	public void setMemberNumber(int id) {
		memberNumber = id;
	}

	public int getMemberNumber() {
		return memberNumber;
	}
	
	public void setServiceCode(int code) {
		serviceCode = code;
	}
	
	public int getServiceCode() {
		return serviceCode;
	}
	
	public void setComments(String inputComments) {
		comments = inputComments;
	}
	
	public String getComments() {
		return comments;
	}

}
