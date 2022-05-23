package ejercicio2;

import java.sql.Date;

public class Cliente {
	private String dni;
	private String nombre;
	private String telefono;
	private String direccion;
	private Date fechaDeNacimiento;

	public Cliente(
		String dni, String nombre, String telefono, String direccion,
		Date fechaDeNacimiento
	) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
}
