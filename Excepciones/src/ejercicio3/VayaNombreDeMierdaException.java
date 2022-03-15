package ejercicio3;

public class VayaNombreDeMierdaException extends Exception {
	private static final long serialVersionUID = 1L;

	public VayaNombreDeMierdaException() {
		super();
	}

	public VayaNombreDeMierdaException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VayaNombreDeMierdaException(String message, Throwable cause) {
		super(message, cause);
	}

	public VayaNombreDeMierdaException(String message) {
		super(message);
	}

	public VayaNombreDeMierdaException(Throwable cause) {
		super(cause);
	}
}
