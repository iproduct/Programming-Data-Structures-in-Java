package exceptions;

public class MyListException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MyListException() {
		super();
	}

	public MyListException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyListException(String message) {
		super(message);
	}

	public MyListException(Throwable cause) {
		super(cause);
	}

}
