package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Evaluacion;

public class DAOEvaluacion {
	public DAOEvaluacion() {
	}

	public void add(Evaluacion evaluacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO evaluaciones VALUES(%d, %d, %d, '%s')",
					evaluacion.getAlumno().getCodigo(),
					evaluacion.getCurso().getCodigo(),
					evaluacion.getNotaFinal(), evaluacion.getObservaciones()
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

	public void delete(Evaluacion evaluacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM evaluaciones WHERE CodigoAlumno = %d AND CodigoCurso = %d",
					evaluacion.getAlumno().getCodigo(),
					evaluacion.getCurso().getCodigo()
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

	public void update(Evaluacion evaluacion) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE evaluaciones e SET NotaFinal = %d, Observaciones = '%s'"
					+ " WHERE CodigoAlumno = %d and CodigoCurso = %d",
					evaluacion.getNotaFinal(), evaluacion.getObservaciones(),
					evaluacion.getAlumno().getCodigo(),
					evaluacion.getCurso().getCodigo()
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

	public ArrayList<Evaluacion> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				"SELECT * FROM evaluaciones"
			);

			DAOAlumno daoAlumno = new DAOAlumno();
			DAOCurso daoCurso = new DAOCurso();

			while (result.next()) {
				evaluaciones.add(
					new Evaluacion(
						daoAlumno.get(result.getInt(1)),
						daoCurso.get(result.getInt(2)),
						result.getInt(3),
						result.getString(4)
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

		return evaluaciones;
	}

	public Evaluacion get(int cAlumno, int cCurso) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM evaluaciones WHERE CodigoAlumno = %d AND CodigoCurso = %d",
					cAlumno, cCurso
				)
			);

			if (result.next()) {
				DAOAlumno daoAlumno = new DAOAlumno();
				DAOCurso daoCurso = new DAOCurso();

				return new Evaluacion(
					daoAlumno.get(result.getInt(1)),
					daoCurso.get(result.getInt(2)),
					result.getInt(3),
					result.getString(4)
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
