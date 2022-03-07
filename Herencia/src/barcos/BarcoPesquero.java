package barcos;

public class BarcoPesquero extends Barco implements Navegable {
	protected boolean congelador;

	public BarcoPesquero(
		String nombre, String capitan, int eslora, boolean congelador
	) {
		super(nombre, capitan, eslora);
		this.congelador = congelador;
	}

	@Override
	public String lanzarSOS() {
		return "Tss tais an inflaos q ns undimos";
	}

	@Override
	public void solicitarPermisoZarpar() {
		System.out.printf("Tss e pco q mi voy a piscar\n");
	}

	public boolean isCongelador() {
		return congelador;
	}

	public void setCongelador(boolean congelador) {
		this.congelador = congelador;
	}

	@Override
	public String toString() {
		return super.toString() + "Congelador: " + congelador + "\n";
	}
}
