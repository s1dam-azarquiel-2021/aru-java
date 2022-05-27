package ejercicio4;

public class TicketDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TicketDuplicadoException() {
		super();
	}

	public TicketDuplicadoException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TicketDuplicadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketDuplicadoException(String message) {
		super(message);
	}

	public TicketDuplicadoException(Throwable cause) {
		super(cause);
	}
}
