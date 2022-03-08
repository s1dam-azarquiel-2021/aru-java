package examenCursoPasado;

import java.util.ArrayList;

public class Vivienda {
	private ArrayList<Estancia> estancias;

	public Vivienda(ArrayList<Estancia> estancias) {
		super();
		this.estancias = estancias;
	}

	public Vivienda(Vivienda vivienda) {
		super();
		this.estancias = vivienda.getEstancias();
	}

	public Vivienda() {
		super();
		this.estancias = new ArrayList<Estancia>();
	}

	public ArrayList<Estancia> getEstancias() {
		return estancias;
	}

	public int camas() {
		int nCamas = 0;
		for (Estancia estancia : this.estancias) {
			if (estancia instanceof Dormitorio) {
				nCamas += ((Dormitorio) estancia).getnCamas();
			}
		}

		return nCamas;
	}

	public float costeTotal() {
		int total = 0;
		for (Estancia estancia : this.estancias) {
			total += estancia.precio * (1 + (estancia.nVentanas * 0.05));
		}

		return total;
	}

	public void imprimirViviendas() {
		System.out.print(this.toString());
	}

	public boolean add(Estancia estancia) {
		return this.estancias.add(estancia);
	}

	public boolean remove(Estancia estancia) {
		return this.estancias.remove(estancia);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Estancias:\n-----\n");
		for (Estancia estancia : estancias) {
			result.append(estancia.toString());
			result.append("\n");
		}

		return result.toString();
	}
}
