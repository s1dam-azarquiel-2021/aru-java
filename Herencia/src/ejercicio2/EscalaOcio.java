package ejercicio2;

import java.util.Date;

public class EscalaOcio extends Escala {
	protected int horas;

	public EscalaOcio(
		String ciudad, Date horaBajada, Date horaRegreso, int horas
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
