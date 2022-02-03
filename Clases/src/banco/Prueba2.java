package banco;

public class Prueba2 {
	public static void main(String[] args) {
		CuentaCorriente2 cuenta = new CuentaCorriente2(111, "Pepino");
		cuenta.ingresar(2200);
		System.out.printf("%s\n", cuenta);
	}
}
