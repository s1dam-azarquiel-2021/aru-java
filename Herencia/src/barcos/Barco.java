package barcos;

public abstract class Barco {
	protected String nombre;
	protected String capitan;
	protected int eslora;

	public Barco(String nombre, String capitan, int eslora) {
		super();
		this.nombre = nombre;
		this.capitan = capitan;
		this.eslora = eslora;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCapitan() {
		return capitan;
	}

	public int getEslora() {
		return eslora;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public void setEslora(int eslora) {
		this.eslora = eslora;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nCapitan: " + capitan + "\nEslora: "
		+ eslora + "\n";
	}
}
