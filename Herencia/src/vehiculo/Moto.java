package vehiculo;

public class Moto extends VehiculoConMotor {
	protected String estilo;

	public Moto(
		String marca, String modelo, String color, float precio, int cilindrada,
		String combustible, String estilo
	) {
		super(marca, modelo, color, precio, cilindrada, combustible);
		this.estilo = estilo;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return super.toString() + "Estilo=" + estilo + "\n";
	}
}
