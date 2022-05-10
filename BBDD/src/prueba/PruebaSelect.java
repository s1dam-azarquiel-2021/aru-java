package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaSelect {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";

			Connection conexion = DriverManager.getConnection(url, "root", "");

			System.out.println("Conectado");

			Statement plataforma = conexion.createStatement();

			String sql;

			sql = "SELECT * FROM personas";
			ResultSet resultado = plataforma.executeQuery(sql);

			while (resultado.next()) {
				System.out.printf(
					"%s | %s | %s\n", resultado.getString(1),
					resultado.getString(2), resultado.getLong(3)
				);
			}

			System.out.println("Trabajo terminado");
		} catch (ClassNotFoundException e) {
			System.out.println("Error cargando el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion sql");
			e.printStackTrace();
		}
	}
}
