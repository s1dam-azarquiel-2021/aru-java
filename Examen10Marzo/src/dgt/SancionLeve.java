package dgt;

import java.util.GregorianCalendar;

public class SancionLeve extends Sancion {
	// Fields
	// ------
	protected float cuantia;
	// ------

	// Constructors
	// ------------
	public SancionLeve(
		Conductor conductor, String matricula, String descripcion,
		GregorianCalendar fechaSancion, float cuantia
	) {
		super(conductor, matricula, descripcion, fechaSancion);
		this.cuantia = cuantia;
	}

	public SancionLeve(
		Conductor conductor, String matricula, String descripcion, float cuantia
	) {
		super(conductor, matricula, descripcion);
		this.cuantia = cuantia;
	}
	// ------------

	// Getters
	// -------
	public float getCuantia() {
		return cuantia;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		return super.toString() + "cuantia: " + cuantia + "\n";
	}
	// --------
}
