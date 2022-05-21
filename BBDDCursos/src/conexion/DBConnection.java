package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cursos";

			this.connection = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Error cargando el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion sql");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}
}
