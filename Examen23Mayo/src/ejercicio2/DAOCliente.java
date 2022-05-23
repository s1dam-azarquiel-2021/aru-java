package ejercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCliente {
	public DAOCliente() {
	}

	public ArrayList<Cliente> get() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery("SELECT * FROM cliente");

			while (result.next()) {
				clientes.add(
					new Cliente(
						result.getString(1),
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

		return clientes;
	}

	public Cliente get(String dni) {
		Connection connection = new DBConnection().getConnection();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				String.format("SELECT * FROM cliente WHERE DNI = '%s'", dni)
			);

			if (result.next()) {
				return new Cliente(
					result.getString(1),
					result.getString(2),
					result.getString(3),
					result.getString(4),
					result.getDate(5)
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

		return null;
	}

	public ArrayList<Cliente> getClientesVariasMascotas() {
		Connection connection = new DBConnection().getConnection();
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			Statement platform = connection.createStatement();
			ResultSet result = platform.executeQuery(
				"SELECT * FROM cliente WHERE dni IN"
				+ "( SELECT DniCliente FROM mascota"
				+ "  GROUP BY DniCliente HAVING count(DniCliente) > 1 )"
			);

			while (result.next()) {
				clientes.add(
					new Cliente(
						result.getString(1),
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

		return clientes;
	}
}
