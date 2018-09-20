package addressbook.exceptions;

public class EntityExistsException extends Exception {

	public EntityExistsException() {
		super();
	}

	public EntityExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityExistsException(String arg0) {
		super(arg0);
	}

	public EntityExistsException(Throwable arg0) {
		super(arg0);
	}
	
}
