package ejercicioReloj;

public class RelojAnalogico extends Reloj {
	@Override
	public String getHora() {
		String minuto = this.minuto == 45 || this.minuto == 15 ? "cuarto"
			: "" + this.minuto;

		if (this.minuto > 30) {
			return "Son las " + (this.hora + 1) + " menos " + minuto;
		} else {
			return "Son las " + this.hora + " y " + minuto;
		}
	}
}
