package ejercicio2;

import java.util.ArrayList;

public class Stock {
	private ArrayList<Producto> productos;

	public Stock(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public Stock() {
		this.productos = new ArrayList<Producto>();
	}

	public boolean add(Producto producto) {
		return this.productos.add(producto);
	}

	public boolean remove(Producto producto) {
		return this.productos.remove(producto);
	}

	public boolean remove(int codigo) {
		return this.remove(this.find(codigo));
	}

	public boolean remove(String descripcion) {
		return this.remove(this.find(descripcion));
	}

	public Producto find(int codigo) {
		for (Producto producto : this.productos) {
			if (producto.getCodigo() == codigo) {
				return producto;
			}
		}

		return null;
	}

	public Producto find(String descripcion) {
		for (Producto producto : this.productos) {
			if (producto.getDescripcion().equals(descripcion)) {
				return producto;
			}
		}

		return null;
	}

	public ArrayList<Producto> outOfStockProducts() {
		ArrayList<Producto> result = new ArrayList<Producto>();
		for (Producto producto : this.productos) {
			if (producto.getCantidad() == 0) {
				result.add(producto);
			}
		}

		return result;
	}

	public ArrayList<Producto> belowMinimumProducts() {
		ArrayList<Producto> result = new ArrayList<Producto>();
		for (Producto producto : this.productos) {
			if (producto.getCantidad() < producto.getMinimo()) {
				result.add(producto);
			}
		}

		return result;
	}
}
