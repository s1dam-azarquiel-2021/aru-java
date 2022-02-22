package vehiculo;

public class Coche extends VehiculoConMotor {
	protected int nPuertas;

	public Coche(
		String marca, String modelo, String color, float precio, int cilindrada,
		String combustible, int nPuertas
	) {
		super(marca, modelo, color, precio, cilindrada, combustible);
		this.nPuertas = nPuertas;
	}

	public int getnPuertas() {
		return nPuertas;
	}

	public void setnPuertas(int nPuertas) {
		this.nPuertas = nPuertas;
	}

	@Override
	public String toString() {
		return super.toString() + "Numero de puertas: " + nPuertas + "\n";
	}
}
