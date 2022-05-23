package ejercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOMascota {
	public DAOMascota() {
	}

	public void add(Mascota mascota) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO mascota VALUES('%s', '%s', '%s', '%s', '%s', '%s')",
					mascota.getNumero(), mascota.getNombreMascota(),
					mascota.getTipoDeAnimal(), mascota.getRaza(),
					mascota.getFechaDeNacimiento(), mascota.getDniCliente()
				)

			);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Mascota mascota) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE mascota m SET NombreMascota = '%s', TipoDeAnimal = '%s',"
					+ "Raza = '%s', FechaDeNacimiento = '%s', DniCliente = '%s'"
					+ " WHERE m.Numero = '%s')", mascota.getNombreMascota(),
					mascota.getTipoDeAnimal(), mascota.getRaza(),
					mascota.getFechaDeNacimiento(), mascota.getDniCliente(),
					mascota.getNumero()
				)
			);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Mascota> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Mascota> mascotas = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM mascota");

			while (result.next()) {
				mascotas.add(
					new Mascota(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getDate(5),
						result.getString(6)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mascotas;
	}
}
