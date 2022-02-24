package ejercicio1;

import java.util.ArrayList;

public class Comanda {
	private int nMesa;
	private int nComensales;
	private ArrayList<Plato> platos;

	public Comanda(int nMesa, int nComensales, ArrayList<Plato> platos) {
		this.nMesa = nMesa;
		this.nComensales = nComensales;
		this.platos = platos;
	}

	public boolean add(Plato plato) {
		return this.platos.add(plato);
	}

	public boolean remove(Plato plato) {
		return this.platos.remove(plato);
	}

	public float coste() {
		float resultado = 0;
		for (Plato plato : this.platos) {
			resultado += plato.getPrecio();
		}

		return resultado;
	}

	public boolean hayDiabeticosEnLaMesa() {
		for (Plato plato : this.platos) {
			if (plato instanceof Postres && !((Postres) plato).isConAzucar()) {
				return true;
			}
		}

		return false;

	}

	public int getnMesa() {
		return nMesa;
	}

	public int getnComensales() {
		return nComensales;
	}

	public ArrayList<Plato> getPlatos() {
		return platos;
	}

	public void setnMesa(int nMesa) {
		this.nMesa = nMesa;
	}

	public void setnComensales(int nComensales) {
		this.nComensales = nComensales;
	}

	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(
			"Numero pesa: " + nMesa + "\nNumero comensales: " + nComensales
				+ "\n"
		);

		for (Plato plato : this.platos) {
			resultado.append(plato.toString());
		}

		return resultado.toString();
	}
}
