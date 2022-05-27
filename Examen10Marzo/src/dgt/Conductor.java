package dgt;

import java.util.GregorianCalendar;

public class Conductor {
	// Fields
	// ------
	private String dni;
	private String nombre;
	private String apellidos;
	private GregorianCalendar fechaObtencionCarnet;
	// ------

	// Constructors
	// ------------
	public Conductor(
		String dni, String nombre, String apellidos,
		GregorianCalendar fechaObtencionCarnet
	) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaObtencionCarnet = fechaObtencionCarnet;
	}
	// ------------

	// Getters
	// -------
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public GregorianCalendar getFechaObtencionCarnet() {
		return fechaObtencionCarnet;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		return "dni: " + dni + "\nnombre: " + nombre + "\napellidos: "
		+ apellidos + "\nfechaObtencionCarnet: " + fechaObtencionCarnet + "\n";
	}
	// --------
}
