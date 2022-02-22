package vehiculo;

public abstract class Vehiculo {
	protected String marca;
	protected String modelo;
	protected String color;
	protected float precio;

	public Vehiculo(String marca, String modelo, String color, float precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public float getPrecio() {
		return precio;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + "\nModelo: " + modelo + "\nColor: " + color
			+ "\nPrecio: " + precio + "\n";
	}
}
