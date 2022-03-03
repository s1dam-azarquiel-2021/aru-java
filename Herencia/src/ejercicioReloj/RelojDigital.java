package ejercicioReloj;

public class RelojDigital extends Reloj {
	@Override
	public String getHora() {
		return this.hora + ":" + this.minuto;
	}

	@Override
	public String toString() {
		return "Hora: " + getHora() + "\n";
	}
}
