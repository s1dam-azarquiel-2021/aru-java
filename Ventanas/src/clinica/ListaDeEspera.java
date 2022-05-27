package clinica;

import java.util.ArrayList;

public class ListaDeEspera {
	private ArrayList<Paciente> list;

	public ListaDeEspera() {
		this.list = new ArrayList<>();
	}

	public boolean add(Paciente paciente) {
		return this.list.add(paciente);
	}

	public boolean delete(Paciente paciente) {
		return this.list.remove(paciente);
	}

	public Paciente getByName(String name) {
		for (Paciente p : this.list) {
			if (p.getName().equals(name)) {
				return p;
			}
		}

		return null;
	}

	public Paciente getByCompany(String company) {
		for (Paciente p : this.list) {
			if (p.getCompany().equals(company)) {
				return p;
			}
		}

		return null;
	}

	public Paciente atender() {
		if (this.size() == 0) {
			return null;
		} else {
			return this.list.remove(0);
		}
	}

	public Paciente atender(Paciente paciente) {
		if (this.delete(paciente)) {
			return paciente;
		} else {
			return null;
		}
	}

	public boolean colar(Paciente paciente, int pos) {
		if (this.delete(paciente)) {
			if (pos < this.size()) {
				this.list.add(pos, paciente);
			} else {
				this.add(paciente);
			}

			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return this.list.size();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Lista de pacientes:\n");
		for (int i = 0; i < this.size(); i++) {
			if (this.list.get(i) != null) {
				resultado.append(
					"Paciente " + (i + 1) + "\n" + this.list.get(i).toString()
				);
			}
		}

		return resultado.toString();
	}
}
