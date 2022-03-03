package figuras;

public class Circulo extends Figura {
	private double radio;

	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radio * this.radio;
	}

	@Override
	public double getPerimetro() {
		return 2 * Math.PI * this.radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return super.toString() + "Radio: " + radio + "\n";
	}
}
