package examenCursoPasado;

public class Banio extends Estancia {
	protected boolean tieneDucha;

	public Banio(int metros2, int nVentanas, int precio, boolean tieneDucha) {
		super(metros2, nVentanas, precio);
		this.tieneDucha = tieneDucha;
	}

	public boolean isTieneDucha() {
		return tieneDucha;
	}

	@Override
	public String toString() {
		return super.toString() + "tieneDucha: " + tieneDucha + "\n";
	}
}
