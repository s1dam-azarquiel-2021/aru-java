package entities;

public class Poblacion {
	private String nombre;
	private long numeroHabitantes;

	public Poblacion(String nombre, long numeroHabitantes) {
		super();
		this.nombre = nombre;
		this.numeroHabitantes = numeroHabitantes;
	}

	public String getNombre() {
		return this.nombre;
	}

	public long getNumeroHabitantes() {
		return this.numeroHabitantes;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\nnumeroHabitantes: " + numeroHabitantes
		+ "\n";
	}
}
