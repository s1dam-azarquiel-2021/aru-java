package ejercicio2;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private static int nFactura = 1;
	private Date fecha;
	private int numeroFactura;
	private ArrayList<LineaFactura> lineasFacturas;
	private boolean pagada;

	public Factura(
		Date fecha,
		int numeroFactura,
		ArrayList<LineaFactura> lineasFacturas,
		boolean pagada
	) {
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.lineasFacturas = lineasFacturas;
		this.pagada = pagada;
	}

	public Factura(Date fecha, boolean pagada) {
		this.fecha = fecha;
		this.numeroFactura = nFactura++;
		this.lineasFacturas = new ArrayList<LineaFactura>();
		this.pagada = pagada;
	}

	public Factura(Date fecha) {
		this.fecha = fecha;
		this.numeroFactura = nFactura++;
		this.lineasFacturas = new ArrayList<LineaFactura>();
		this.pagada = false;
	}

	public Factura(ArrayList<LineaFactura> lineasFacturas, boolean pagada) {
		this.fecha = new Date();
		this.numeroFactura = nFactura++;
		this.lineasFacturas = lineasFacturas;
		this.pagada = pagada;
	}

	public Factura(boolean pagada) {
		this.fecha = new Date();
		this.numeroFactura = nFactura++;
		this.lineasFacturas = new ArrayList<LineaFactura>();
		this.pagada = pagada;
	}

	public Factura() {
		this.fecha = new Date();
		this.numeroFactura = nFactura++;
		this.lineasFacturas = new ArrayList<LineaFactura>();
		this.pagada = false;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public ArrayList<LineaFactura> getLineasFacturas() {
		return lineasFacturas;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public void setLineasFacturas(ArrayList<LineaFactura> lineasFacturas) {
		this.lineasFacturas = lineasFacturas;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public int nLineasFacturas() {
		return this.lineasFacturas.size();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(
			"Factura:\nFecha: " + fecha + "Numero de factura: " + numeroFactura
			+ "\nPagada: " + pagada + "\n"
		);
		for (int i = 0; i < this.nLineasFacturas(); i++) {
			if (this.lineasFacturas.get(i) != null) {
				resultado.append(
					"Linea factura " + (i + 1) + "\n"
					+ this.lineasFacturas.get(i).toString()
				);
			}
		}

		return resultado.toString();
	}
}
