package chocan;

/**
 * General class for person details
 * @author Jared Folden
 *
 */
public class Person {
	
	private String name;
	private String IDNumber;
	private String email;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	
	/**
	 * Constructor for person
	 */
	public Person() {
	}
	
	/**
	 * Used to set the name
	 * @param newName, name to be used
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Used to retrieve the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Used to set the id number
	 * @param id number
	 */
	public void setIDNumber(String id) {
		IDNumber = id;
	}
	
	/**
	 * Used to retrieve the ID Number
	 * @return IDnumber
	 */
	public String getIDNumber() {
		return IDNumber;
	}
	
	/**
	 * Used to set the email
	 * @param newEmail
	 */
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	/**
	 * Used to retrieve the email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Used to set the street address
	 * @param address
	 */
	public void setStreetAddress(String address) {
		streetAddress = address;
	}
	
	/**
	 * Used to retrieve the street address
	 * @return
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	
	/**
	 * Used to set the city
	 * @param newCity
	 */
	public void setCity(String newCity) {
		city = newCity;
	}
	
	/**
	 * Used to retrive the city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Used to set the state
	 * @param newState
	 */
	public void setState(String newState) {
		state = newState;
	}
	
	/**
	 * Used to retrieve the state
	 * @return state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Used to set the zip code
	 * @param newZip
	 */
	public void setZip(String newZip) {
		zip = newZip;
	}
	
	/**
	 * Used to retrieve the zip code
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}
}