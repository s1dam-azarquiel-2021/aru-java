package entities;

import java.sql.Date;

public class Alumno {
	private int codigo;
	private String nombre;
	private String apellidos;
	private String telefono;
	private Date fechaNacimiento;

	public Alumno(
		int codigo, String nombre, String apellidos, String telefono,
		Date fechaNacimiento
	) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnombre: " + nombre + "\napellidos: "
		+ apellidos + "\ntelefono: " + telefono + "\nfechaNacimiento: "
		+ fechaNacimiento + "\n";
	}
}
