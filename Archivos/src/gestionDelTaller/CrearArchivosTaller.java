package gestionDelTaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrearArchivosTaller {
	public static void main(String[] args) throws FileNotFoundException,
		IOException, ParseException {
		File archivoVehiculos = new File("vehiculos.obj");
		File archivoIntervenciones = new File("intervenciones.obj");

		ObjectOutputStream oos = new ObjectOutputStream(
			new FileOutputStream(archivoVehiculos)
		);
		oos.writeObject(
			new Vehiculo("7463HFW", "CITROEN", "C4", "JORGE RODRIGUEZ")
		);
		oos.writeObject(
			new Vehiculo("1093BMR", "FORD", "KUGA", "MARTA SOLANO")
		);
		oos.writeObject(
			new Vehiculo("4738CIP", "HYUNDAI", "IX35", "LUIS GOMEZ")
		);
		oos.writeObject(
			new Vehiculo("3320GSR", "PEUGEOT", "3008", "JUAN MORENO")
		);
		oos.writeObject(
			new Vehiculo("8584DDZ", "CITROEN", "C3", "CECILIA MARTIN")
		);
		oos.writeObject(
			new Vehiculo("5874FGM", "OPEL", "ASTRA", "FRANCISCO PARDO")
		);
		oos.close();

		oos = new ObjectOutputStream(
			new FileOutputStream(archivoIntervenciones)
		);
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		oos.writeObject(
			new Intervencion(
				fecha.parse("17/02/2022"),
				"7463HFW",
				123.68F,
				"Cambio de aceite"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("17/02/2022"),
				"4738CIP",
				159.99F,
				"Cambio de neumatico"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("20/02/2022"),
				"1093BMR",
				292.99F,
				"Revisi�n general"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("23/02/2022"),
				"7463HFW",
				45.90F,
				"Filtro del aire"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("22/03/2022"),
				"3320GSR",
				123.68F,
				"Cambio de aceite"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("24/03/2022"),
				"5874FGM",
				110.00F,
				"Cambio de neumatico"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("06/04/2022"),
				"3320GSR",
				489.00F,
				"Sustitucion Correa de distribuci�n"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("15/04/2022"),
				"4738CIP",
				1240.00F,
				"Sustitucion embrague"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("28/04/2022"),
				"8584DDZ",
				16.00F,
				"Reponer lampara fundida"
			)
		);
		oos.writeObject(
			new Intervencion(
				fecha.parse("10/05/2022"),
				"8584DDZ",
				99.99F,
				"Cambio de neumatico"
			)
		);
		oos.close();

		System.out.println("Archivos creados");
	}
}
