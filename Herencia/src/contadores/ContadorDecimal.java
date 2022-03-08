package contadores;

public class ContadorDecimal extends Contador {
	protected double valor;

	public ContadorDecimal(double valor) {
		super();
		this.valor = valor;
	}

	@Override
	public void incrementar() {
		this.valor++;
	}

	@Override
	public void decrementar() {
		this.valor--;
	}

	@Override
	public void reset() {
		this.valor = 0.0;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Valor: " + valor + "\n";
	}
}
