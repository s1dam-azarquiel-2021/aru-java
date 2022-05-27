package ejercicio2;

import java.util.ArrayList;

public class CajonFacturas {
	private ArrayList<Factura> facturas;

	public CajonFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public CajonFacturas() {
		this.facturas = new ArrayList<>();
	}

	public boolean add(Factura factura) {
		return this.facturas.add(factura);
	}

	public Factura find(int numeroFactura) {
		for (Factura factura : this.facturas) {
			if (factura.getNumeroFactura() == numeroFactura) {
				return factura;
			}
		}

		return null;
	}

	public ArrayList<Factura> notPaidInvoices() {
		ArrayList<Factura> result = new ArrayList<>();
		for (Factura factura : this.facturas) {
			if (!factura.isPagada()) {
				result.add(factura);
			}
		}

		return result;
	}

	public int size() {
		return this.facturas.size();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Cajon de facturas:\n");
		for (int i = 0; i < this.size(); i++) {
			if (this.facturas.get(i) != null) {
				resultado.append(this.facturas.get(i).toString());
			}
		}

		return resultado.toString();
	}
}
