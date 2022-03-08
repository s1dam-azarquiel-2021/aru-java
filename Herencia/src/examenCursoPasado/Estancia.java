package examenCursoPasado;

public abstract class Estancia {
	protected int metros2;
	protected int nVentanas;
	protected int precio;

	public Estancia(int metros2, int nVentanas, int precio) {
		super();
		this.metros2 = metros2;
		this.nVentanas = nVentanas;
		this.precio = precio;
	}

	public int getMetros2() {
		return metros2;
	}

	public int getnVentanas() {
		return nVentanas;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "metros2: " + metros2 + "\nnVentanas: " + nVentanas
			+ "\nprecio: " + precio + "\n";
	}
}
