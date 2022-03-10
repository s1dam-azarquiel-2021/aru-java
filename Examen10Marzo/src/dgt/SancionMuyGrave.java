package dgt;

import java.util.GregorianCalendar;

public class SancionMuyGrave extends SancionGrave {
	// Fields
	// ------
	protected int mesesCarnetRetirado;
	// ------

	// Constructors
	// ------------
	public SancionMuyGrave(
		Conductor conductor, String matricula, String descripcion,
		GregorianCalendar fechaSancion, float cuantia, int puntosPerdidos,
		int mesesCarnetRetirado
	) {
		super(
			conductor, matricula, descripcion, fechaSancion, cuantia,
			puntosPerdidos
		);
		this.mesesCarnetRetirado = mesesCarnetRetirado;
	}

	public SancionMuyGrave(
		Conductor conductor, String matricula, String descripcion,
		float cuantia, int puntosPerdidos, int mesesCarnetRetirado
	) {
		super(conductor, matricula, descripcion, cuantia, puntosPerdidos);
		this.mesesCarnetRetirado = mesesCarnetRetirado;
	}
	// ------------

	// Getters
	// -------
	public int getMesesCarnetRetirado() {
		return mesesCarnetRetirado;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		return super.toString() + "mesesCarnetRetirado: " + mesesCarnetRetirado
			+ "\n";
	}
	// --------
}
