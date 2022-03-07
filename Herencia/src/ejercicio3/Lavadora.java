package ejercicio3;

public class Lavadora extends Electrodomestico {
	protected float carga;

	public Lavadora(
		Color color, Consumo consumoEnergetico, float peso, float precioBase,
		float carga
	) {
		super(color, consumoEnergetico, peso, precioBase);
		this.carga = carga;
	}

	public Lavadora(float peso, float precioBase) {
		super(peso, precioBase);
		this.carga = 5;
	}

	public Lavadora() {
		super();
		this.carga = 5;
	}

	public float precioFinal() {
		return super.precioFinal() + this.carga > 30 ? 50 : 0;
	}

	public float getCarga() {
		return carga;
	}
}
