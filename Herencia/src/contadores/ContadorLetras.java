package contadores;

public class ContadorLetras extends Contador {
	private char valor;

	public ContadorLetras(char valor) {
		this.valor = valor;
	}

	@Override
	public void incrementar() {
		if (this.valor == 'z' || this.valor == 'Z') {
			this.valor -= 'z' - 'a';
		} else {
			this.valor++;
		}
	}

	@Override
	public void decrementar() {
		if (this.valor == 'a' || this.valor == 'A') {
			this.valor += 'z' - 'a';
		} else {
			this.valor--;
		}
	}

	@Override
	public void reset() {
		if (this.valor >= 'A') {
			this.valor = 'A';
		} else {
			this.valor = 'a';
		}
	}

	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "valor: " + valor + "\n";
	}
}
