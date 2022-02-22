package vehiculo;

public class Bici extends VehiculoSinMotor {
	protected int marchas;

	public Bici(
		String marca, String modelo, String color, float precio, int marchas
	) {
		super(marca, modelo, color, precio);
		this.marchas = marchas;
	}

	public int getMarchas() {
		return marchas;
	}

	public void setMarchas(int marchas) {
		this.marchas = marchas;
	}

	@Override
	public String toString() {
		return super.toString() + "Marchas: " + marchas + "\n";
	}
}
