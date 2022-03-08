package ejercicio2;

import java.util.Date;

public abstract class Escala {
	protected String ciudad;
	protected Date horaBajada;
	protected Date horaRegreso;

	public Escala(String ciudad, Date horaBajada, Date horaRegreso) {
		super();
		this.ciudad = ciudad;
		this.horaBajada = horaBajada;
		this.horaRegreso = horaRegreso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Date getHoraBajada() {
		return horaBajada;
	}

	public Date getHoraRegreso() {
		return horaRegreso;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setHoraBajada(Date horaBajada) {
		this.horaBajada = horaBajada;
	}

	public void setHoraRegreso(Date horaRegreso) {
		this.horaRegreso = horaRegreso;
	}

	@Override
	public String toString() {
		return "Ciudad: " + ciudad + "\nHora Bajada: " + horaBajada
			+ "\nHora Regreso: " + horaRegreso + "\n";
	}
}
