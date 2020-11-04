package chocan;


public class Person {
	
	private String name;
	private String IDNumber;
	private String email;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	
	public Person() {
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setIDNumber(String id) {
		IDNumber = id;
	}
	
	public String getIDNumber() {
		return IDNumber;
	}
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setStreetAddress(String address) {
		streetAddress = address;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setCity(String newCity) {
		city = newCity;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setState(String newState) {
		state = newState;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZip(String newZip) {
		zip = newZip;
	}
	
	public String getZip() {
		return zip;
	}
}