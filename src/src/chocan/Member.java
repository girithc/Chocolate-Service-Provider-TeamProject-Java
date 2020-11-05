package chocan;

/**
 * Class for member details
 * inherited from person class with suspended attributes and methods
 * @author folde
 *
 */
public class Member extends Person {
	
	private boolean suspended;
	
	/**
	 * Constructor for member
	 */
	public Member() {
	}
	
	/**
	 * Used to set the suspended status
	 * @param newSuspended
	 */
	public void setSuspended(boolean newSuspended) {
		suspended = newSuspended;
	}
	
	/**
	 * Used to retrieve the suspended status
	 * @return suspended status
	 */
	public boolean getSuspended() {
		return suspended;
	}
}