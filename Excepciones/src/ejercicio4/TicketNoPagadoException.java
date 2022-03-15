package ejercicio4;

public class TicketNoPagadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TicketNoPagadoException() {
		super();
	}

	public TicketNoPagadoException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TicketNoPagadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketNoPagadoException(String message) {
		super(message);
	}

	public TicketNoPagadoException(Throwable cause) {
		super(cause);
	}
}
