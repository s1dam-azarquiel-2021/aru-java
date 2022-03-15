package ejercicio4;

import java.util.ArrayList;

public class Parking {
	private int capacidad;
	private ArrayList<Ticket> tickets;

	public Parking(int capacidad, ArrayList<Ticket> tickets) {
		super();
		this.capacidad = capacidad;
		this.tickets = tickets;
	}

	public Parking(int capacidad) {
		super();
		this.capacidad = capacidad;
		this.tickets = new ArrayList<Ticket>();
	}

	public void add(Ticket ticket)
		throws ParkingLlenoException, TicketDuplicadoException {
		if (this.tickets.size() >= capacidad) {
			throw new ParkingLlenoException("El parking esta lleno");
		} else if (this.tickets.contains(ticket)) {
			throw new TicketDuplicadoException("Ese ticket ya existe");
		} else {
			this.tickets.add(ticket);
		}
	}

	public void remove(Ticket ticket) throws TicketNoPagadoException {
		if (!ticket.isPagado()) {
			throw new TicketNoPagadoException("Paga el ticket primero");
		} else {
			this.tickets.remove(ticket);
		}
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public ArrayList<Ticket> getTickets() {
		return this.tickets;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(
			"capacidad: " + capacidad + "\nTickets:\n"
		);
		for (Ticket ticket : this.tickets) {
			resultado.append(ticket.toString());
			resultado.append("\n");
		}

		return resultado.toString();
	}
}
