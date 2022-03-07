package ejercicio3;

public class Television extends Electrodomestico {
	protected int resolucion;
	protected boolean smartTV;

	public Television(
		Color color, Consumo consumoEnergetico, float peso, float precioBase,
		int resolucion, boolean smartTV
	) {
		super(color, consumoEnergetico, peso, precioBase);
		this.resolucion = resolucion;
		this.smartTV = smartTV;
	}

	public Television(float peso, float precioBase) {
		super(peso, precioBase);
		this.resolucion = 20;
		this.smartTV = false;
	}

	public Television() {
		super();
		this.resolucion = 20;
		this.smartTV = false;
	}

	public float precioFinal() {
		return super.precioFinal() * (this.resolucion > 40 ? 1.3F : 1)
			+ (this.smartTV ? 50 : 0);
	}

	public int getResolucion() {
		return resolucion;
	}

	public boolean isSmartTV() {
		return smartTV;
	}
}
