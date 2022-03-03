package figuras;

public abstract class Figura {
	protected String color;

	public Figura(String color) {
		this.color = color;
	}

	public abstract double getArea();

	public abstract double getPerimetro();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Color: " + color + "\n";
	}
}
