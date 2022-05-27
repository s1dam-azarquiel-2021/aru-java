package figuras;

public class Triangulo extends Figura {
	protected double base;
	protected double altura;

	public Triangulo(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double getArea() {
		return this.altura * this.base / 2;
	}

	@Override
	public double getPerimetro() {
		return this.base + this.altura + Math.sqrt(
			this.altura * this.altura + this.base * this.base
		);
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return super.toString() + "Base: " + base + "\naltura: " + altura
		+ "\n";
	}
}
