package examenCursoPasado;

public class Dormitorio extends Estancia {
	protected int nCamas;

	public Dormitorio(int metros2, int nVentanas, int precio, int nCamas) {
		super(metros2, nVentanas, precio);
		this.nCamas = nCamas;
	}

	public int getnCamas() {
		return nCamas;
	}

	@Override
	public String toString() {
		return super.toString() + "nCamas: " + nCamas + "\n";
	}
}
