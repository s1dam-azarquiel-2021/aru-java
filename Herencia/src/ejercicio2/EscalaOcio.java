package ejercicio2;

public class EscalaOcio extends Escala {
	private int horas;

	public EscalaOcio(
		String ciudad, int horaBajada, int horaRegreso, int horas
	) {
		super(ciudad, horaBajada, horaRegreso);
		this.horas = horas;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return super.toString() + "Horas: " + horas + "\n";
	}
}
