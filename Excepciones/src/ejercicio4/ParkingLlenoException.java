package ejercicio4;

public class ParkingLlenoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ParkingLlenoException() {
		super();
	}

	public ParkingLlenoException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParkingLlenoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingLlenoException(String message) {
		super(message);
	}

	public ParkingLlenoException(Throwable cause) {
		super(cause);
	}
}
