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
		for (int i = 0; i < this.size(); i++) {
			if (this.lista[i] == null) {
				this.lista[i] = contacto;
				return true;
			}
		}

		return false;
	}

	public boolean remove(Contacto contacto) {
		int i = this.contactIndex(contacto);
		if (i == -1) {
			return false;
		}

		this.lista[i] = null;
		return true;
	}

	public boolean remove(String nombre) {
		Contacto contacto = this.find(nombre);
		if (contacto == null) {
			return false;
		}

		return this.remove(contacto);
	}

	public boolean remove(long numero) {
		Contacto contacto = this.find(numero);
		if (contacto == null) {
			return false;
		}

		return this.remove(contacto);
	}

	private int contactIndex(Contacto contacto) {
		for (int i = 0; i < this.size(); i++) {
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

	public int saved() {
		int n = 0;
		for (Contacto contacto : this.lista) {
			if (contacto != null) {
				n++;
			}
		}

		return n;
	}

	@Override
	public String toString() {
		String resultado = "Agenda:\n";
		for (int i = 0; i < this.size(); i++) {
			if (this.lista[i] != null) {
				resultado += "Contacto " + (i + 1) + "\n";
				resultado += this.lista[i].toString();
			}
		}

		return resultado;
	}
}
