package banco;

public class CuentaCorriente2 {
	private long numeroCuenta;
	private String titular;
	private double saldo;

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

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Numero cuenta: " + numeroCuenta + "\nTitular: " + titular
			+ "\nSaldo: " + saldo;
	}
}
