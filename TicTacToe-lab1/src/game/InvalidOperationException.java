package game;

public class InvalidOperationException extends Exception {

	public InvalidOperationException() {
	}

	public InvalidOperationException(String message) {
		super(message);
	}

	public InvalidOperationException(Throwable cause) {
		super(cause);
	}

	public InvalidOperationException(String message, Throwable cause) {
		super(message, cause);
	}

}
