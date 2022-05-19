package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DBConnection;
import entities.Producto;

public class DAOProducto {
	public DAOProducto() {
	}

	public void add(Producto producto) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"INSERT INTO productos VALUES(%d, '%s', %d, %f)",
					producto.getId(), producto.getNombre(),
					producto.getGrupo().getId(), producto.getPrecio()
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

	public void delete(Producto producto) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"DELETE FROM productos WHERE NomProducto = '%s'",
					producto.getNombre()
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

	public void update(Producto producto) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			platform.executeUpdate(
				String.format(
					"UPDATE productos p SET"
					+ " NomProducto = '%s', IdGrupo = %d, Precio = %f"
					+ " WHERE p.IdProducto = %d", producto.getNombre(),
					producto.getGrupo().getId(), producto.getPrecio(),
					producto.getId()
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

	public ArrayList<Producto> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Producto> productos = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM productos");

			DAOGrupo daoGrupo = new DAOGrupo();

			while (result.next()) {
				productos.add(
					new Producto(
						result.getInt(1),
						result.getString(2),
						daoGrupo.get(result.getInt(3)),
						result.getDouble(4)
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

		return productos;
	}

	public Producto get(int id) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format(
					"SELECT * FROM productos WHERE IdProducto = %d", id
				)
			);

			if (result.next()) {
				DAOGrupo daoGrupo = new DAOGrupo();

				return new Producto(
					result.getInt(1),
					result.getString(2),
					daoGrupo.get(result.getInt(3)),
					result.getDouble(4)
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
