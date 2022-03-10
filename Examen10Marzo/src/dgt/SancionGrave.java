package dgt;

import java.util.GregorianCalendar;

public class SancionGrave extends SancionLeve {
	// Fields
	// ------
	protected int puntosPerdidos;
	// ------

	// Constructors
	// ------------
	public SancionGrave(
		Conductor conductor, String matricula, String descripcion,
		GregorianCalendar fechaSancion, float cuantia, int puntosPerdidos
	) {
		super(conductor, matricula, descripcion, fechaSancion, cuantia);
		this.puntosPerdidos = puntosPerdidos;
	}

	public SancionGrave(
		Conductor conductor, String matricula, String descripcion,
		float cuantia, int puntosPerdidos
	) {
		super(conductor, matricula, descripcion, cuantia);
		this.puntosPerdidos = puntosPerdidos;
	}
	// ------------

	// Getters
	// -------
	public int getPuntosPerdidos() {
		return puntosPerdidos;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		return super.toString() + "puntosPerdidos: " + puntosPerdidos + "\n";
	}
	// --------
}
