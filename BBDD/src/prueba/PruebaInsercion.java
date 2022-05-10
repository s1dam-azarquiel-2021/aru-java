package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaInsercion {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";

			Connection conexion = DriverManager.getConnection(url, "root", "");

			System.out.println("Conectado");

			Statement plataforma = conexion.createStatement();

			String sql;

			sql =
				"INSERT INTO personas VALUES('54212216Q', 'Manolo', 662391045)";
			plataforma.executeUpdate(sql);

			sql =
				"INSERT INTO personas VALUES('43889012P', 'Maria', 688072917)";
			plataforma.executeUpdate(sql);

			sql =
				"INSERT INTO personas VALUES('43814012L', 'Luisa', 688072917)";
			plataforma.executeUpdate(sql);

			sql = "INSERT INTO personas VALUES('12573212R', 'Jose', 615289932)";
			plataforma.executeUpdate(sql);

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
