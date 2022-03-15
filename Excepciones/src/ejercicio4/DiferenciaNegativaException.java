package ejercicio4;

public class DiferenciaNegativaException extends Exception {
	private static final long serialVersionUID = 1L;

	public DiferenciaNegativaException() {
		super();
	}

	public DiferenciaNegativaException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DiferenciaNegativaException(String message, Throwable cause) {
		super(message, cause);
	}

	public DiferenciaNegativaException(String message) {
		super(message);
	}

	public DiferenciaNegativaException(Throwable cause) {
		super(cause);
	}
}
