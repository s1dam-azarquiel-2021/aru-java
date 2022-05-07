package gestionDelTaller;

import java.io.Serializable;
import java.util.Date;

public class Intervencion implements Serializable {
	private Date fecha;
	private String matricula;
	private float coste;
	private String descripcion;

	public Intervencion(
		Date fecha, String matricula, float coste, String descripcion
	) {
		this.fecha = fecha;
		this.matricula = matricula;
		this.coste = coste;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
