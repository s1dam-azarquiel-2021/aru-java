package ejercicio3;

import java.util.ArrayList;

public class Pandilla {
	private int capacidad;
	private ArrayList<Amigo> amigos;

	public Pandilla(int capacidad, ArrayList<Amigo> amigos) {
		super();
		this.capacidad = capacidad;
		this.amigos = amigos;
	}

	public Pandilla(int capacidad) {
		super();
		this.capacidad = capacidad;
		this.amigos = new ArrayList<Amigo>();
	}

	public void add(Amigo amigo)
		throws PandillaCompletaException, VayaNombreDeMierdaException {
		if (this.amigos.size() == this.capacidad) {
			throw new PandillaCompletaException(
				"Esto ta lleno, buscate otro lao"
			);
		} else if (amigo.getNombre().endsWith("s")) {
			throw new VayaNombreDeMierdaException("Cambiate el nombre");
		} else {
			this.amigos.add(amigo);
		}
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public ArrayList<Amigo> getAmigos() {
		return this.amigos;
	}

	@Override
	public String toString() {
		return "capacidad: " + capacidad + "\namigos: " + amigos + "\n";
	}
}
