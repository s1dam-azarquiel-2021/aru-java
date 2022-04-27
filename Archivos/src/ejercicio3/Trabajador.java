package ejercicio3;

public class Trabajador {
	private String nombre;
	private int diasTrabajados;

	public Trabajador(String nombre) {
		super();
		this.nombre = nombre;
		this.diasTrabajados = 0;
	}

	public Trabajador(String nombre, int diasTrabajados) {
		super();
		this.nombre = nombre;
		this.diasTrabajados = diasTrabajados;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getDiasTrabajados() {
		return this.diasTrabajados;
	}

	public void aumentarDiasTrabajados() {
		this.diasTrabajados++;
	}

	@Override
	public String toString() {
		return nombre + ":" + diasTrabajados;
	}
}
