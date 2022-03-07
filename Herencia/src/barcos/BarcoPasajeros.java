package barcos;

public class BarcoPasajeros extends Barco implements Navegable {
	protected int capacidad;

	public BarcoPasajeros(
		String nombre, String capitan, int eslora, int capacidad
	) {
		super(nombre, capitan, eslora);
		this.capacidad = capacidad;
	}

	@Override
	public String lanzarSOS() {
		return "Socorro que me hundo!";
	}

	@Override
	public void solicitarPermisoZarpar() {
		System.out.printf("Oie tu dejame ir por el agua\n");
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return super.toString() + "Capacidad: " + capacidad + "\n";
	}
}
