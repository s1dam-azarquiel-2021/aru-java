package examenCursoPasado;

public class Cocina extends Estancia {
	protected int nElectrodomesticos;

	public Cocina(
		int metros2, int nVentanas, int precio, int nElectrodomesticos
	) {
		super(metros2, nVentanas, precio);
		this.nElectrodomesticos = nElectrodomesticos;
	}

	public int getnElectrodomesticos() {
		return nElectrodomesticos;
	}

	@Override
	public String toString() {
		return super.toString() + "nElectrodomesticos: " + nElectrodomesticos
		+ "\n";
	}
}
