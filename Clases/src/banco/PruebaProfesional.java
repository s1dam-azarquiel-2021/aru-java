package banco;

public class PruebaProfesional {
	public static void main(String[] args) {
		Cliente pepino = new Cliente("123456789Z", "Pepino", 123456789);
		System.out.printf("%s\n", pepino);

		CuentaCorrienteProfesional cuenta = new CuentaCorrienteProfesional(
			123456789, pepino
		);
		cuenta.ingresar(1200);
		System.out.printf("\n%s\n", cuenta);
	}
}
