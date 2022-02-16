package ejercicio2;

import java.util.ArrayList;

public class CajonFacturas {
	private ArrayList<Factura> facturas;

	public CajonFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public CajonFacturas() {
		this.facturas = new ArrayList<Factura>();
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
		ArrayList<Factura> result = new ArrayList<Factura>();
		for (Factura factura : this.facturas) {
			if (!factura.isPagada()) {
				result.add(factura);
			}
		}

		return result;
	}
}
