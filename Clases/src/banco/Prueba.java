package banco;

public class Prueba {
	public static void main(String[] args) {
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.ingresar(1100);
		cuenta.asignarNumeroCuenta(111);
		cuenta.asignarTitulo("Pepino");
		cuenta.mostrarDatosCuenta();
	}
}
