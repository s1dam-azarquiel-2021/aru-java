package ejercicio2;

public abstract class Escala {
	protected String ciudad;
	protected int horaBajada;
	protected int horaRegreso;

	public Escala(String ciudad, int horaBajada, int horaRegreso) {
		this.ciudad = ciudad;
		this.horaBajada = horaBajada;
		this.horaRegreso = horaRegreso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getHoraBajada() {
		return horaBajada;
	}

	public int getHoraRegreso() {
		return horaRegreso;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setHoraBajada(int horaBajada) {
		this.horaBajada = horaBajada;
	}

	public void setHoraRegreso(int horaRegreso) {
		this.horaRegreso = horaRegreso;
	}

	@Override
	public String toString() {
		return "Ciudad: " + ciudad + "\nHora Bajada: " + horaBajada
			+ "\nHora Regreso: " + horaRegreso + "\n";
	}
}
