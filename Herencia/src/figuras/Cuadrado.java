package figuras;

public class Cuadrado extends Figura {
	private double lado;

	public Cuadrado(String color, double lado) {
		super(color);
		this.lado = lado;
	}

	@Override
	public double getArea() {
		return this.lado * this.lado;
	}

	@Override
	public double getPerimetro() {
		return this.lado * 4;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return super.toString() + "Lado: " + lado + "\n";
	}
}
