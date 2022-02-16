package ejercicio1;

public class Rectangulo {
	private int width;
	private int height;

	public Rectangulo() {
		this.width = 0;
		this.height = 0;
	}

	public Rectangulo(int width, int height) {
		this.width = width > 0 ? width : 0;
		this.height = height > 0 ? height : 0;
	}

	public int area() {
		return this.width * this.height;
	}

	public int perimeter() {
		return (this.height + this.width) * 2;
	}

	public boolean isHorizontal() {
		return this.width > this.height;
	}

	public void draw() {
		for (int i = 0; i < this.height; i++) {
			System.out.printf("%s\n", "*".repeat(this.width));
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Ancho: " + width + "\nAlto: " + height + "\n";
	}
}
