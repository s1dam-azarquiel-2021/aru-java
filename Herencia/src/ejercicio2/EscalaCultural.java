package ejercicio2;

public class EscalaCultural extends Escala {
	private String guia;
	private float precioGuia;

	public EscalaCultural(
		String ciudad, int horaBajada, int horaRegreso, String guia,
		float precioGuia
	) {
		super(ciudad, horaBajada, horaRegreso);
		this.guia = guia;
		this.precioGuia = precioGuia;
	}

	public String getGuia() {
		return guia;
	}

	public float getPrecioGuia() {
		return precioGuia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public void setPrecioGuia(float precioGuia) {
		this.precioGuia = precioGuia;
	}

	@Override
	public String toString() {
		return super.toString() + "Guia: " + guia + "\nprecioGuia: "
			+ precioGuia + "\n";
	}
}
