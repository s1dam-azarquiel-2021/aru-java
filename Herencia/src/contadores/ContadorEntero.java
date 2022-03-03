package contadores;

public class ContadorEntero extends Contador {
	private int valor;

	public ContadorEntero(int valor) {
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
		this.valor = 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Valor: " + valor + "\n";
	}
}
