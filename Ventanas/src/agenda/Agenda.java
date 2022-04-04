package agenda;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contacto> lista;

	public Agenda() {
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
		return this.remove(this.get(nombre));
	}

	public boolean remove(long numero) {
		return this.remove(this.get(numero));
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
			if (c.getNombre().equals(nombre)) {
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

	public ArrayList<Contacto> getLista() {
		return this.lista;
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
					"Contacto " + (i + 1) + "\n" + this.lista.get(i).toString()
				);
			}
		}

		return resultado.toString();
	}
}
