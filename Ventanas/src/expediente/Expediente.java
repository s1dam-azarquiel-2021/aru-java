package expediente;

import java.util.ArrayList;

public class Expediente {
	private Alumno alumno;
	private ArrayList<Modulo> modulos;

	public Expediente(Alumno alumno) {
		this.alumno = alumno;
		modulos = new ArrayList<Modulo>();
	}

	public Expediente(Alumno alumno, ArrayList<Modulo> modulos) {
		super();
		this.alumno = alumno;
		this.modulos = modulos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void addModulo(Modulo m) {
		modulos.add(m);
	}

	public Modulo getModulo(String nombreModulo) {
		for (int i = 0; i < modulos.size(); i++) {
			if (modulos.get(i).getNombre().equals(nombreModulo)) {
				return modulos.get(i);
			}
		}
		return null;
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public float notaMedia() {
		if (modulos.isEmpty()) {
			return 0;
		} else {
			float suma = 0;
			for (int i = 0; i < modulos.size(); i++) {
				suma += modulos.get(i).notaMedia();
			}
			return suma / modulos.size();
		}
	}

	public String toString() {
		String resultado = "";
		resultado += " Expediente de: " + alumno + "\n";
		resultado += " MODULO\t1Ev\t2Ev\t3Ev\n";
		for (int i = 0; i < modulos.size(); i++) {
			resultado += modulos.get(i) + "\n";
		}
		resultado += "Nota Media:" + this.notaMedia() + "\n";
		return resultado;
	}

	public boolean removeModulo(String nombreModulo) {
		for (int i = 0; i < modulos.size(); i++) {
			if (modulos.get(i).getNombre().equals(nombreModulo)) {
				modulos.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean modifyModulo(Modulo modulo) {
		for (int i = 0; i < modulos.size(); i++) {
			if (modulos.get(i).getNombre().equals(modulo.getNombre())) {
				modulos.get(i).setNota(1, modulo.getNota(1));
				modulos.get(i).setNota(2, modulo.getNota(2));
				modulos.get(i).setNota(3, modulo.getNota(3));
				return true;
			}
		}
		return false;
	}
}
