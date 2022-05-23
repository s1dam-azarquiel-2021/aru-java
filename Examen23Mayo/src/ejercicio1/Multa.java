package ejercicio1;

public class Multa {
	private String fecha;
	private String matricula;
	private String descripcion;

	public Multa(String fecha, String residente, String descripcion) {
		super();
		this.fecha = fecha;
		this.matricula = residente;
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public String toString() {
		return "fecha: " + fecha + "\nresidente: " + matricula
		+ "\ndescripcion: " + descripcion + "\n";
	}
}
