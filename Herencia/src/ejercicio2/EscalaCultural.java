package ejercicio2;

import java.util.Date;

public class EscalaCultural extends Escala {
	protected String guia;
	protected float precioGuia;

	public EscalaCultural(
		String ciudad, Date horaBajada, Date horaRegreso, String guia,
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
