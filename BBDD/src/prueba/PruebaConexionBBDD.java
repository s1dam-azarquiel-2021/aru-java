package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexionBBDD {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";

			Connection conexion = DriverManager.getConnection(url, "root", "");

			System.out.println("Conectado");
		} catch (ClassNotFoundException e) {
			System.out.println("Error cargando el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion sql");
			e.printStackTrace();
		}
	}
}
