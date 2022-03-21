package ejercicio4;

import java.util.Calendar;

public class Prueba {
	public static void main(String[] args) {
		Calendar f1 = Calendar.getInstance();
		f1.set(2022, 2, 21, 12, 0);
		Calendar f2 = Calendar.getInstance();
		f2.set(2022, 2, 20, 12, 0);
		Calendar f3 = Calendar.getInstance();
		f3.set(2022, 1, 21, 12, 0);

		Parking p = new Parking(3);
		Ticket t1 = new Ticket("1234", f1, false);
		Ticket t2 = new Ticket("2345", f2, false);
		Ticket t3 = new Ticket("3456", f3, true);

		try {
			p.add(t1);
			p.add(t2);
			p.add(t3);
		} catch (ParkingLlenoException e) {
			System.out.println(e.getMessage());
		} catch (TicketDuplicadoException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.printf("Precio ticket1: %f\n", t1.calcularPrecio());
			System.out.printf("Precio ticket2: %f\n", t2.calcularPrecio());
			System.out.printf("Precio ticket3: %f\n", t3.calcularPrecio());
		} catch (DiferenciaNegativaException e) {
			System.out.println(e.getMessage());
		}
	}
}
