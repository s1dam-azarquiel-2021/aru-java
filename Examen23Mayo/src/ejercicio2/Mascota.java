package ejercicio2;

import java.sql.Date;

public class Mascota {
	private String numero;
	private String nombreMascota;
	private String tipoDeAnimal;
	private String raza;
	private Date fechaDeNacimiento;
	private String dniCliente;

	public Mascota(
		String numero, String nombreMascota, String tipoDeAnimal, String raza,
		Date fechaDeNacimiento, String dniCliente
	) {
		super();
		this.numero = numero;
		this.nombreMascota = nombreMascota;
		this.tipoDeAnimal = tipoDeAnimal;
		this.raza = raza;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dniCliente = dniCliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getTipoDeAnimal() {
		return tipoDeAnimal;
	}

	public void setTipoDeAnimal(String tipoDeAnimal) {
		this.tipoDeAnimal = tipoDeAnimal;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
}
