package agenda;

public class Agenda {
	private Contacto[] lista;

	public Contacto[] getLista() {
		return lista;
	}

	public Agenda(int size) {
		this.lista = new Contacto[size];
	}

	public boolean add(Contacto contacto) {
		for (int i = 0; i < size(); i++) {
			if (this.lista[i] == null) {
				this.lista[i] = contacto;
				return true;
			}
		}

		return false;
	}

	public boolean remove(Contacto contacto) {
		int i = contactIndex(contacto);
		if (i == -1) {
			return false;
		}

		this.lista[i] = null;
		return true;
	}

	private int contactIndex(Contacto contacto) {
		for (int i = 0; i < size(); i++) {
			if (this.lista[i] != null && this.lista[i].equals(contacto)) {
				return i;
			}
		}

		return -1;
	}

	public Contacto find(String nombre) {
		for (Contacto contacto : this.lista) {
			if (contacto != null && contacto.getNombre() == nombre) {
				return contacto;
			}
		}

		return null;
	}

	public Contacto find(long telefono) {
		for (Contacto contacto : this.lista) {
			if (contacto != null && contacto.getTelefono() == telefono) {
				return contacto;
			}
		}

		return null;
	}

	public int size() {
		return this.lista.length;
	}

	public String showLista() {
		String resultado = "";
		for (int i = 0; i < size(); i++) {
			if (this.lista[i] != null) {
				resultado += "Contacto " + (i + 1) + "\n";
				resultado += this.lista[i].toString();
			}
		}

		return resultado;
	}

	@Override
	public String toString() {
		return "Agenda:\n" + showLista();
	}
}
