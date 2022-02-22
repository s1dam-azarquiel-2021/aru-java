package vehiculo;

public class VehiculoConMotor extends Vehiculo {
	protected int cilindrada;
	protected String combustible;

	public VehiculoConMotor(String marca, String modelo, String color, float precio, int cilindrada,
			String combustible) {
		super(marca, modelo, color, precio);
		this.cilindrada = cilindrada;
		this.combustible = combustible;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	@Override
	public String toString() {
		return
			super.toString() + "Cilindrada: " + cilindrada
			+ "\nCombustible: " + combustible + "\n";
	}
}
