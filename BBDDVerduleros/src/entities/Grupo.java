package entities;

public class Grupo {
	private int id;
	private String nombre;

	public Grupo(int idGrupo, String nombreGrupo) {
		super();
		this.id = idGrupo;
		this.nombre = nombreGrupo;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "idGrupo: " + id + "\nnombreGrupo: " + nombre + "\n";
	}
}
