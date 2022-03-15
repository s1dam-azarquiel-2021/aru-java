package ejercicio2;

public class ContadorException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContadorException() {
		super();
	}

	public ContadorException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ContadorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContadorException(String message) {
		super(message);
	}

	public ContadorException(Throwable cause) {
		super(cause);
	}
}
