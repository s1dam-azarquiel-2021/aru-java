package ejercicioReloj;

public class RelojAnalogico extends Reloj {
	@Override
	public String getHora() {
		String minuto = "";
		switch (this.minuto) {
		case 5, 55:
			minuto = "cinco";
			break;
		case 10, 50:
			minuto = "diez";
			break;
		case 15, 45:
			minuto = "cuarto";
			break;
		case 20, 40:
			minuto = "veinte";
			break;
		case 25, 35:
			minuto = "veinticinco";
			break;
		case 30:
			minuto = "media";
			break;
		}

		return "Son las "
			+ (this.minuto > 30 ? (this.hora + 1) + " menos "
				: this.hora + " y ")
			+ (minuto.equals("") ? this.minuto + " minutos" : minuto);
	}

	@Override
	public String toString() {
		return "Hora: " + getHora() + "\n";
	}
}
