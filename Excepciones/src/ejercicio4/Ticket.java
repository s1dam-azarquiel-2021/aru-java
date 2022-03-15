package ejercicio4;

import java.util.Calendar;

public class Ticket {
	private String matricula;
	private Calendar hora;
	private boolean pagado;

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
		float diferencia = this.hora.get(Calendar.HOUR_OF_DAY)
			- Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (diferencia < 0) {
			throw new DiferenciaNegativaException(
				"Diferencia de horas negativa"
			);
		} else {
			return diferencia;
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
