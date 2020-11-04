package chocan;

public class Member extends Person {
	
	private boolean suspended;
	
	public Member() {
	}
	
	public void setSuspended(boolean newSuspended) {
		suspended = newSuspended;
	}
	
	public boolean getSuspended() {
		return suspended;
	}
}