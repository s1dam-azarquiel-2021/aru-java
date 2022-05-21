package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Alumno;

public class DAOAlumno {
	public DAOAlumno() {
	}

	public void add(Alumno alumno) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO alumnos VALUES(%d, '%s', '%s', '%s', '%s')",
					alumno.getCodigo(), alumno.getNombre(),
					alumno.getApellidos(), alumno.getTelefono(),
					alumno.getFechaNacimiento()
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

	public void delete(Alumno alumno) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM alumnos WHERE CodigoAlumno = %d",
					alumno.getCodigo()
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

	public void update(Alumno alumno) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE alumnos a SET Nombre = '%s',"
					+ "Apellido = '%s', Telefono = '%s', FechaNacimiento = '%s'"
					+ " WHERE a.CodigoAlumno = %d", alumno.getNombre(),
					alumno.getApellidos(), alumno.getTelefono(),
					alumno.getFechaNacimiento(), alumno.getCodigo()
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

	public ArrayList<Alumno> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Alumno> alumnos = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM alumnos");

			while (result.next()) {
				alumnos.add(
					new Alumno(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getDate(5)
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

		return alumnos;
	}

	public Alumno get(int id) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM alumnos WHERE CodigoAlumno = %d", id
				)
			);

			if (result.next()) {
				return new Alumno(
					result.getInt(1),
					result.getString(2),
					result.getString(3),
					result.getString(4),
					result.getDate(5)
				);
			}

			return null;
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

	public Alumno get(String nombre) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM alumnos WHERE Nombre = '%s'", nombre
				)
			);

			if (result.next()) {
				return new Alumno(
					result.getInt(1),
					result.getString(2),
					result.getString(3),
					result.getString(4),
					result.getDate(5)
				);
			}

			return null;
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
