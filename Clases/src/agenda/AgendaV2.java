package agenda;

import java.util.ArrayList;

public class AgendaV2 {
	private ArrayList<Contacto> lista;

	public Contacto[] getLista() {
		return this.lista.toArray(new Contacto[this.lista.size()]);
	}

	public AgendaV2() {
		this.lista = new ArrayList<Contacto>();
	}

	public boolean add(Contacto contacto) {
		this.lista.add(contacto);
		return true;
	}

	public boolean update(Contacto antiguo, Contacto nuevo) {
		Contacto contacto = this.get(antiguo);
		if (contacto == null) {
			return false;
		}

		contacto.setNombre(nuevo.getNombre());
		contacto.setTelefono(nuevo.getTelefono());
		return true;
	}

	public boolean update(Contacto antiguo, String nombre) {
		Contacto contacto = this.get(antiguo);
		if (contacto == null) {
			return false;
		}

		contacto.setNombre(nombre);
		return true;
	}

	public boolean update(Contacto antiguo, long telefono) {
		Contacto contacto = this.get(antiguo);
		if (contacto == null) {
			return false;
		}

		contacto.setTelefono(telefono);
		return true;
	}

	public boolean remove(Contacto contacto) {
		return this.lista.remove(contacto);
	}

	public boolean remove(String nombre) {
		Contacto contacto = this.get(nombre);
		return this.remove(contacto);
	}

	public boolean remove(long numero) {
		Contacto contacto = this.get(numero);
		return this.remove(contacto);
	}

	public Contacto get(Contacto contacto) {
		for (Contacto c : this.lista) {
			if (c.equals(contacto)) {
				return contacto;
			}
		}

		return null;
	}

	public Contacto get(String nombre) {
		for (Contacto c : this.lista) {
			if (c.getNombre() == nombre) {
				return c;
			}
		}

		return null;
	}

	public Contacto get(long telefono) {
		for (Contacto c : this.lista) {
			if (c.getTelefono() == telefono) {
				return c;
			}
		}

		return null;
	}

	public int size() {
		return this.lista.size();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Agenda:\n");
		for (int i = 0; i < this.size(); i++) {
			if (this.lista.get(i) != null) {
				resultado.append(
					"Contacto " + (i + 1) + "\n"
					+ this.lista.get(i).toString()
				);
			}
		}

		return resultado.toString();
	}
}
