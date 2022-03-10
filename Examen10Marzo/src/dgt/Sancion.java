package dgt;

import java.util.GregorianCalendar;

public abstract class Sancion {
	// Fields
	// ------
	protected Conductor conductor;
	protected String matricula;
	protected String descripcion;
	protected GregorianCalendar fechaSancion;
	// ------

	// Constructors
	// ------------
	public Sancion(
		Conductor conductor, String matricula, String descripcion,
		GregorianCalendar fechaSancion
	) {
		super();
		this.conductor = conductor;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.fechaSancion = fechaSancion;
	}

	public Sancion(Conductor conductor, String matricula, String descripcion) {
		super();
		this.conductor = conductor;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.fechaSancion = new GregorianCalendar();
	}
	// ------------

	// Getters
	// -------
	public Conductor getConductor() {
		return conductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public GregorianCalendar getFechaSancion() {
		return fechaSancion;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		return "conductor:\n-----\n" + conductor + "-----\nmatricula: "
			+ matricula + "\ndescripcion: " + descripcion + "\nfechaSancion: "
			+ fechaSancion + "\n";
	}
	// --------
}
