package ejercicio4;

import java.util.Calendar;

public class Ticket {
	private String matricula;
	private Calendar hora;
	private boolean pagado;

	private static final float PRECIO_DIA = 6.5F;
	private static final float PRECIO_HORA = 1.7F;
	private static final float PRECIO_MINUTO = 0.1F;

	public Ticket(String matricula, Calendar hora, boolean pagado) {
		super();
		this.matricula = matricula;
		this.hora = hora;
		this.pagado = pagado;
	}

	public Ticket(String matricula, boolean pagado) {
		super();
		this.matricula = matricula;
		this.hora = Calendar.getInstance();
		this.pagado = pagado;
	}

	public float calcularPrecio() throws DiferenciaNegativaException {
		long diferencia = Calendar.getInstance().getTimeInMillis()
			- this.hora.getTimeInMillis();
		if (diferencia < 0) {
			throw new DiferenciaNegativaException(
				"Diferencia de horas negativa"
			);
		} else {
			diferencia /= 60000; // To minutes
			long dias = diferencia / 1440;
			diferencia %= 1440;
			long horas = diferencia / 60;
			long minutos = diferencia % 60;

			if (horas > 10) {
				dias++;
				horas = 0;
				minutos = 0;
			}

			return dias * PRECIO_DIA + horas * PRECIO_HORA
				+ minutos * PRECIO_MINUTO;
		}
	}

	public String getMatricula() {
		return this.matricula;
	}

	public Calendar getHora() {
		return this.hora;
	}

	public boolean isPagado() {
		return this.pagado;
	}

	@Override
	public String toString() {
		return "matricula: " + matricula + "\nhora: " + hora + "\npagado: "
			+ pagado + "\n";
	}
}
