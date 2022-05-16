package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Habitante;

public class DAOHabitante {
	public DAOHabitante() {
	}

	public void add(Habitante habitante) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO habitante VALUES('%s', '%s', %d, '%s')",
					habitante.getNombre(), habitante.getEmail(),
					habitante.getEdad(), habitante.getPoblacion().getNombre()
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

	public void delete(Habitante habitante) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM habitante WHERE Nombre = '%s'",
					habitante.getNombre()
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

	public void update(Habitante habitante) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE habitante h SET Email = '%s', Edad = %d,"
					+ "Poblacion = '%s' WHERE h.Nombre = '%s'",
					habitante.getEmail(), habitante.getEdad(),
					habitante.getPoblacion(), habitante.getNombre()
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

	public ArrayList<Habitante> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Habitante> habitantes = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM habitante");

			DAOPoblacion daoPoblacion = new DAOPoblacion();

			while (result.next()) {
				habitantes.add(
					new Habitante(
						result.getString(1),
						result.getString(2),
						result.getInt(3),
						daoPoblacion.get(result.getString(4))
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

		return habitantes;
	}

	public Habitante get(String nombre) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM habitante WHERE Nombre = '%s'", nombre
				)
			);

			result.next();

			DAOPoblacion daoPoblacion = new DAOPoblacion();

			return new Habitante(
				result.getString(1),
				result.getString(2),
				result.getInt(3),
				daoPoblacion.get(result.getString(4))
			);
		} catch (

			SQLException e
		) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public ArrayList<Habitante> getHabitantesDeUnaPoblacion(String nombre) {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Habitante> habitantes = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM habitante WHERE Poblacion = '%s'", nombre
				)
			);

			DAOPoblacion daoPoblacion = new DAOPoblacion();

			while (result.next()) {
				habitantes.add(
					new Habitante(
						result.getString(1),
						result.getString(2),
						result.getInt(3),
						daoPoblacion.get(result.getString(4))
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

		return habitantes;
	}
}
