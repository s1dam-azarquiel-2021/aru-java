package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Poblacion;

public class DAOPoblacion {
	public DAOPoblacion() {
	}

	public void add(Poblacion poblacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO poblacion VALUES('%s', '%s', %d)",
					poblacion.getNombre(), poblacion.getNumeroHabitantes()
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

	public void delete(Poblacion poblacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM poblacion WHERE Nombre = '%s'",
					poblacion.getNombre()
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

	public void update(Poblacion poblacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE poblacion p SET NumeroHabitantes = %d WHERE p.Nombre = '%s'",
					poblacion.getNombre(), poblacion.getNumeroHabitantes(),
					poblacion.getNombre()
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

	public ArrayList<Poblacion> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Poblacion> poblaciones = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM poblacion");

			while (result.next()) {
				poblaciones.add(
					new Poblacion(result.getString(1), result.getLong(2))
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

		return poblaciones;
	}

	public Poblacion get(String nombre) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM poblacion WHERE nombre = '%s'", nombre
				)
			);

			result.next();

			return new Poblacion(result.getString(1), result.getLong(2));
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
}
