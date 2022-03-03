package ejercicioReloj;

import java.util.Calendar;

public abstract class Reloj {
	private Calendar horaDelSistema = Calendar.getInstance();
	protected int hora = horaDelSistema.get(Calendar.HOUR);
	protected int minuto = horaDelSistema.get(Calendar.MINUTE);

	public abstract String getHora();
}
