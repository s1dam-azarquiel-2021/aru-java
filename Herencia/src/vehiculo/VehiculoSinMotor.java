package vehiculo;

public abstract class VehiculoSinMotor extends Vehiculo {
	public VehiculoSinMotor(
		String marca, String modelo, String color, float precio
	) {
		super(marca, modelo, color, precio);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
