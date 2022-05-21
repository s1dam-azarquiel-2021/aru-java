package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Curso;

public class DAOCurso {
	public DAOCurso() {
	}

	public void add(Curso curso) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO cursos VALUES(%d, '%s', '%s', '%s', '%s', '%s')",
					curso.getCodigo(), curso.getCurso(), curso.getFechaInicio(),
					curso.getFechaFin(), curso.getHoraInicio(),
					curso.getHoraFin()
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

	public void delete(Curso curso) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM cursos WHERE CodigoCurso = %d",
					curso.getCodigo()
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

	public void update(Curso curso) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE cursos c SET Curso = '%s',"
					+ "FechaInicio = '%s', FechaFin = '%s', HoraInicio = '%s', HoraFin = '%s'"
					+ " WHERE c.CodigoCurso = %d", curso.getCurso(),
					curso.getFechaInicio(), curso.getFechaFin(),
					curso.getHoraInicio(), curso.getHoraFin(), curso.getCodigo()
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

	public ArrayList<Curso> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Curso> cursos = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM cursos");

			while (result.next()) {
				cursos.add(
					new Curso(
						result.getInt(1),
						result.getString(2),
						result.getDate(3),
						result.getDate(3),
						result.getString(3),
						result.getString(3)
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

		return cursos;
	}

	public Curso get(int id) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format("SELECT * FROM cursos WHERE CodigoCurso = %d", id)
			);

			if (result.next()) {
				return new Curso(
					result.getInt(1),
					result.getString(2),
					result.getDate(3),
					result.getDate(3),
					result.getString(3),
					result.getString(3)
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

	public Curso get(String curso) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format("SELECT * FROM cursos WHERE Curso = '%s'", curso)
			);

			if (result.next()) {
				return new Curso(
					result.getInt(1),
					result.getString(2),
					result.getDate(3),
					result.getDate(3),
					result.getString(3),
					result.getString(3)
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
