package ejercicio5;

public class Jugador {
	private String nombre;
	private Demarcacion demarcacion;
	private Seleccion seleccion;

	public Jugador(
		String nombre, Demarcacion demarcacion, Seleccion seleccion
	) {
		super();
		this.nombre = nombre;
		this.demarcacion = demarcacion;
		this.seleccion = seleccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Demarcacion getDemarcacion() {
		return this.demarcacion;
	}

	public Seleccion getSeleccion() {
		return this.seleccion;
	}
}
