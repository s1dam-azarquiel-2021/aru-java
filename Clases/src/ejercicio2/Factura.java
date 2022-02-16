package ejercicio2;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
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

	public Factura(Date fecha, int numeroFactura, boolean pagada) {
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.lineasFacturas = new ArrayList<LineaFactura>();
		this.pagada = pagada;
	}

	public Factura(Date fecha, int numeroFactura) {
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
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
}
