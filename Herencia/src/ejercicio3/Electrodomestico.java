package ejercicio3;

public class Electrodomestico {
	public enum Color {
		BLANCO, NEGRO, ROJO, AZUL, GRIS
	}

	public enum Consumo {
		A, B, C, D, E, F
	}

	protected Color color;
	protected Consumo consumoEnergetico;
	protected float peso;
	protected float precioBase;

	public Electrodomestico() {
		this.color = Color.BLANCO;
		this.consumoEnergetico = Consumo.F;
		this.precioBase = 100;
		this.precioBase = 100;
	}

	public Electrodomestico(float peso, float precioBase) {
		this.color = Color.BLANCO;
		this.consumoEnergetico = Consumo.F;
		this.peso = peso;
		this.precioBase = precioBase;
	}

	public Electrodomestico(
		Color color, Consumo consumoEnergetico, float peso, float precioBase
	) {
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
		this.precioBase = precioBase;
	}

	public float precioFinal() {
		int precioLetra = 0;
		switch (this.consumoEnergetico) {
		case A:
			precioLetra = 100;
			break;
		case B:
			precioLetra = 80;
			break;
		case C:
			precioLetra = 60;
			break;
		case D:
			precioLetra = 50;
			break;
		case E:
			precioLetra = 30;
			break;
		case F:
			precioLetra = 10;
			break;
		}

		int precioPeso = 0;
		if (this.peso >= 0 && this.peso < 20) {
			precioPeso = 10;
		} else if (this.peso >= 20 && this.peso < 50) {
			precioPeso = 50;
		} else if (this.peso >= 50 && this.peso < 80) {
			precioPeso = 80;
		} else if (this.peso >= 80) {
			precioPeso = 100;
		}

		return this.precioBase + precioLetra + precioPeso;
	}

	public Color getColor() {
		return color;
	}

	public Consumo getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public float getPeso() {
		return peso;
	}

	public float getPrecioBase() {
		return precioBase;
	}
}
