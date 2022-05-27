package ejercicio1;

public class CuentaCorrienteProfesional {
	private long numeroCuenta;
	private Cliente titular;
	private double saldo;

	public CuentaCorrienteProfesional(long numeroCuenta, Cliente titular) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = 0;
	}

	public void ingresar(double saldo) {
		this.saldo += saldo;
	}

	public void sacar(double saldo) throws SaldoInsuficienteException {
		if (saldo <= this.saldo) {
			this.saldo -= saldo;
		} else {
			throw new SaldoInsuficienteException("Estas pobre");
		}
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Numero cuenta: " + numeroCuenta + "\n\nTitular:\n" + titular
		+ "\n\nSaldo: " + saldo;
	}
}
