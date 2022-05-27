package ejercicio2;

public class Contador {
	private int valor;
	private int minimo;
	private int maximo;

	public Contador(int valor, int minimo, int maximo) {
		super();
		this.valor = minimo;
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public void incrementar() throws ContadorException {
		if (this.valor < this.maximo) {
			this.valor++;
		} else {
			throw new ContadorException("El contador ya llego al maximo");
		}
	}

	public void decrementar() throws ContadorException {
		if (this.valor > this.maximo) {
			this.valor--;
		} else {
			throw new ContadorException("El contador ya llego al minimo");
		}
	}

	public void reset() {
		this.valor = this.minimo;
	}

	public int getValor() {
		return this.valor;
	}

	public int getMinimo() {
		return this.minimo;
	}

	public int getMaximo() {
		return this.maximo;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	@Override
	public String toString() {
		return "valor: " + valor + "\nminimo: " + minimo + "\nmaximo: " + maximo
		+ "\n";
	}
}
