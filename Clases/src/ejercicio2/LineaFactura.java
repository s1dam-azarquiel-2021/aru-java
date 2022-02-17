package ejercicio2;

public class LineaFactura {
	private int codigo;
	private float precio;
	private int cantidad;

	public LineaFactura(int codigo, float precio, int cantidad) {
		this.codigo = codigo;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public LineaFactura(int codigo, float precio) {
		this.codigo = codigo;
		this.precio = precio;
		this.cantidad = 1;
	}

	public int getCodigo() {
		return codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return
			"Codigo: " + codigo + "\nPrecio: " + precio
			+ "\nCantidad: " + cantidad + "\n";
	}
}
