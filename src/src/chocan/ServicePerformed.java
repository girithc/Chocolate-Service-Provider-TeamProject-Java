package src.chocan; 

/**
 * Class for services
 * @author Jake Bischoff
 *
 */

public class ServicePerformed {
	
	private String currDateAndTime;
	private String dateProvided;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	
	/** 
	 * Constructor for service
	 */
	public ServicePerformed() {
		
	}
	
	/**
	 * 
	 * @param dateAndTime, current date and time to be input
	 */
	public void setCurrDateAndTime(String dateAndTime) {
		currDateAndTime = dateAndTime;
	}
	
	/**
	 * 
	 * @return currDateAndTime, returns the current date and time
	 */
	public String getCurrDateAndTime() {
		return currDateAndTime;
	}
	
	/**
	 * 
	 * @param date, date the service was provided on
	 */
	public void setDateProvided(String date) {
		dateProvided = date;
	}
	
	/**
	 * 
	 * @return dateProvided, returns the date of the service
	 */
	public String getDateProvided() {
		return dateProvided;
	}
	
	/**
	 * 
	 * @param id, the provider id assigned with the service
	 */
	public void setProviderNumber(String id) {
		providerNumber = id;
	}
	
	/**
	 * 
	 * @return providerNumber, returns the id of the provider
	 */
	public String getProviderNumber() {
		return providerNumber;
	}
	
	/**
	 * 
	 * @param id, member id who received the service
	 */
	public void setMemberNumber(String id) {
		memberNumber = id;
	}

	/**
	 * 
	 * @return memberNumber, returns the id of the member
	 */
	public String getMemberNumber() {
		return memberNumber;
	}
	
	/**
	 * 
	 * @param code, code of the service being performed
	 */
	public void setServiceCode(String code) {
		serviceCode = code;
	}
	
	/**
	 * 
	 * @return serviceCode, returns the code of the service
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	
	/**
	 * 
	 * @param inputComments, comments added to the service
	 */
	public void setComments(String inputComments) {
		comments = inputComments;
	}
	
	/**
	 * 
	 * @return comments, returns comments on the service 
	 */
	public String getComments() {
		return comments;
	}

}
