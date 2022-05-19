package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Grupo;

public class DAOGrupo {
	public DAOGrupo() {
	}

	public void add(Grupo grupo) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO grupos VALUES(%d, '%s')", grupo.getId(),
					grupo.getNombre()
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

	public void delete(Grupo grupo) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM grupos WHERE IdGrupo = %d", grupo.getId()
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

	public void update(Grupo grupo) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE grupos g SET NombreGrupo = '%s' WHERE g.IdGrupo = '%d'",
					grupo.getNombre(), grupo.getId()
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

	public ArrayList<Grupo> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Grupo> grupos = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM grupos");

			while (result.next()) {
				grupos.add(new Grupo(result.getInt(1), result.getString(2)));
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

		return grupos;
	}

	public Grupo get(int id) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format("SELECT * FROM grupos WHERE IdGrupo = %d", id)
			);

			if (result.next()) {
				return new Grupo(result.getInt(1), result.getString(2));
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

	public Grupo get(String nombre) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM grupos WHERE NombreGrupo = '%s'", nombre
				)
			);

			result.next();

			return new Grupo(result.getInt(1), result.getString(2));
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
