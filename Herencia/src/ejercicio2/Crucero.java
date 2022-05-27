package ejercicio2;

import java.util.ArrayList;
import java.util.Date;

public class Crucero {
	protected int cCrucero;
	protected String nombreComercial;
	protected String nombreBarco;
	protected Date fPartida;
	protected Date fRegreso;
	protected ArrayList<Escala> escalas;

	public Crucero(
		int cCrucero, String nombreComercial, String nombreBarco, Date fPartida,
		Date fRegreso, ArrayList<Escala> escalas
	) {
		super();
		this.cCrucero = cCrucero;
		this.nombreComercial = nombreComercial;
		this.nombreBarco = nombreBarco;
		this.fPartida = fPartida;
		this.fRegreso = fRegreso;
		this.escalas = escalas;
	}

	public boolean add(Escala escala) {
		return this.escalas.add(escala);
	}

	public boolean remove(Escala escala) {
		return this.escalas.remove(escala);
	}

	public float coste() {
		int resultado = 600;
		for (Escala escala : this.escalas) {
			resultado += 100;
			if (escala instanceof EscalaCultural) {
				resultado += ((EscalaCultural) escala).getPrecioGuia();
			}
		}

		return resultado;
	}

	public int getcCrucero() {
		return cCrucero;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public String getNombreBarco() {
		return nombreBarco;
	}

	public Date getfPartida() {
		return fPartida;
	}

	public Date getfRegreso() {
		return fRegreso;
	}

	public ArrayList<Escala> getEscalas() {
		return escalas;
	}

	public void setcCrucero(int cCrucero) {
		this.cCrucero = cCrucero;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public void setNombreBarco(String nombreBarco) {
		this.nombreBarco = nombreBarco;
	}

	public void setfPartida(Date fPartida) {
		this.fPartida = fPartida;
	}

	public void setfRegreso(Date fRegreso) {
		this.fRegreso = fRegreso;
	}

	public void setEscalas(ArrayList<Escala> escalas) {
		this.escalas = escalas;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(
			"Codigo crucero: " + cCrucero + "\nNombre Comercial: "
			+ nombreComercial + "\nNombre Barco: " + nombreBarco
			+ "\nFecha partida: " + fPartida + "\nFecha regreso: " + fRegreso
			+ "\n"
		);

		for (Escala escala : this.escalas) {
			resultado.append(escala.toString());
		}

		return resultado.toString();
	}
}
