package dgt;

import java.util.GregorianCalendar;

public class Prueba {
	public static void main(String[] args) {
		Conductor juan = new Conductor(
			"105020826B",
			"Juan",
			"del Castillo otra vez",
			new GregorianCalendar(2022, 4, 4)
		);

		SancionLeve leve = new SancionLeve(
			juan,
			"1234A",
			"Saltarse un semaforo",
			100
		);
		SancionGrave grave = new SancionGrave(
			juan,
			"1234A",
			"Ir a 150",
			500,
			2
		);
		SancionMuyGrave muyGrave = new SancionMuyGrave(
			juan,
			"5678B",
			"Atropello a 10 personas",
			80000,
			10,
			24
		);

		AlmacenDeMultas multas = new AlmacenDeMultas();
		multas.add(leve);
		multas.add(grave);
		multas.add(muyGrave);

		System.out.println(multas);

		System.out.printf(
			"Malos conductores:\n%s\n", multas.getMalosConductores()
		);

		System.out.printf(
			"\nPuntos Restados: %d\n", multas.getPuntosRestados()
		);

		System.out.printf(
			"\nSanciones de 1234A:\n%s\n", multas.getSanciones("1234A")
		);
	}
}
