package banco;

public class CuentaCorriente2 {
	private long numeroCuenta;
	private String titular;
	private double saldo;

	public CuentaCorriente2(long numeroCuenta, String titular) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = 0;
	}

	public void ingresar(double saldo) {
		this.saldo += saldo;
	}

	public void sacar(double saldo) {
		if (saldo <= this.saldo) {
			this.saldo -= saldo;
		} else {
			System.out.printf("No tienes suficiente dinero.\n");
		}
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Numero cuenta: " + numeroCuenta + "\nTitular: " + titular
		+ "\nSaldo: " + saldo;
	}
}
