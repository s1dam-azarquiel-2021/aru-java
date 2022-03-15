package ejercicio3;

public class PandillaCompletaException extends Exception {
	private static final long serialVersionUID = 1L;

	public PandillaCompletaException() {
		super();
	}

	public PandillaCompletaException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PandillaCompletaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PandillaCompletaException(String message) {
		super(message);
	}

	public PandillaCompletaException(Throwable cause) {
		super(cause);
	}
}
