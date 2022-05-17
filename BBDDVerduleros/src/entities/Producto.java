package entities;

public class Producto {
	private int id;
	private String nombre;
	private Grupo grupo;
	private double precio;

	public Producto(int id, String nombre, Grupo grupo, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grupo = grupo;
		this.precio = precio;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public double getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "id: " + id + "\nnombre: " + nombre + "\nprecio: " + precio
		+ "\ngrupo: " + grupo + "\n";
	}
}
