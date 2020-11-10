package chocan;

/**
 * Class for services
 * @author Jake Bischoff
 *
 */

public class ServicePerformed {
	
	private String currDateAndTime;
	private String dateProvided;
	private int providerNumber;
	private int memberNumber;
	protected int serviceCode;
	private String comments;
	
	/**
	 * Constructor for service
	 */
	public ServicePerformed() {
		
	}
	
	/**
	 * Used to set the name
	 * @param dateAndTime, current date and time to be input
	 */
	public void setCurrDateAndTime(String dateAndTime) {
		currDateAndTime = dateAndTime;
	}
	
	/**
	 * Used to retrieve the name
	 * @return currDateAndTime, returns the current date and time
	 */
	public String getCurrDateAndTime() {
		return currDateAndTime;
	}
	
	/**
	 * Used to set the name
	 * @param date, date the service was provided on
	 */
	public void setDateProvided(String date) {
		dateProvided = date;
	}
	
	/**
	 * Used to retrieve the name
	 * @return dateProvided, returns the date of the service
	 */
	public String getDateProvided() {
		return dateProvided;
	}
	
	/**
	 * Used to set the name
	 * @param id, the provider id assigned with the service
	 */
	public void setProviderNumber(int id) {
		providerNumber = id;
	}
	
	/**
	 * Used to retrieve the name
	 * @return providerNumber, returns the id of the provider
	 */
	public int getProviderNumber() {
		return providerNumber;
	}
	
	/**
	 * Used to set the name
	 * @param id, member id who recieved the service
	 */
	public void setMemberNumber(int id) {
		memberNumber = id;
	}

	/**
	 * Used to retrieve the name
	 * @return memberNumber, returns the id of the member
	 */
	public int getMemberNumber() {
		return memberNumber;
	}
	
	/**
	 * Used to set the name
	 * @param code, code of the service being performed
	 */
	public void setServiceCode(int code) {
		serviceCode = code;
	}
	
	/**
	 * Used to retrieve the name
	 * @return serviceCode, returns the code of the service
	 */
	public int getServiceCode() {
		return serviceCode;
	}
	
	/**
	 * Used to set the name
	 * @param inputComments, comments added to teh service
	 */
	public void setComments(String inputComments) {
		comments = inputComments;
	}
	
	/**
	 * Used to retrieve the name
	 * @return comments, returns comments on the service 
	 */
	public String getComments() {
		return comments;
	}

}
