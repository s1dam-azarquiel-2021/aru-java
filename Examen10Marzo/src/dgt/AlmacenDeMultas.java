package dgt;

import java.util.ArrayList;

public class AlmacenDeMultas {
	// Fields
	// ------
	private ArrayList<Sancion> sanciones;
	// ------

	// Constructors
	// ------------
	public AlmacenDeMultas(ArrayList<Sancion> sanciones) {
		super();
		this.sanciones = sanciones;
	}

	public AlmacenDeMultas() {
		super();
		this.sanciones = new ArrayList<Sancion>();
	}
	// ------------

	// Main functions
	// --------------
	public boolean add(Sancion sancion) {
		return this.sanciones.add(sancion);
	}

	public boolean remove(Sancion sancion) {
		return this.sanciones.remove(sancion);
	}
	// --------------

	// Getters
	// -------
	public ArrayList<Sancion> getSanciones() {
		return sanciones;
	}

	public ArrayList<Sancion> getSanciones(String matricula) {
		ArrayList<Sancion> resultado = new ArrayList<Sancion>();
		for (Sancion sancion : this.sanciones) {
			if (sancion.getMatricula().equals(matricula)) {
				resultado.add(sancion);
			}
		}

		return resultado;
	}

	public ArrayList<Conductor> getMalosConductores() {
		ArrayList<Conductor> resultado = new ArrayList<Conductor>();
		for (Sancion sancion : this.sanciones) {
			if (sancion instanceof SancionGrave) {
				Conductor conductor = sancion.getConductor();
				if (!resultado.contains(conductor)) {
					resultado.add(conductor);
				}
			}
		}

		return resultado;
	}

	public int getPuntosRestados() {
		int resultado = 0;
		for (Sancion sancion : this.sanciones) {
			if (sancion instanceof SancionGrave) {
				resultado += ((SancionGrave) sancion).getPuntosPerdidos();
			}
		}

		return resultado;
	}
	// -------

	// toString
	// --------
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Sanciones:\n-----\n\n");
		for (Sancion sancion : this.sanciones) {
			resultado.append(sancion.toString());
			resultado.append("\n");
		}

		return resultado.toString();
	}
	// --------
}
