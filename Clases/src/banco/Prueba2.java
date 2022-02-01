package banco;

public class Prueba2 {
	public static void main(String[] args) {
		CuentaCorriente2 cuenta = new CuentaCorriente2();
		cuenta.setNumeroCuenta(111);
		cuenta.setTitular("Pepino");
		cuenta.ingresar(1200);
		System.out.printf("%s\n", cuenta);
	}
}
