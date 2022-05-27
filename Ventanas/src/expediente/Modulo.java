package expediente;

public class Modulo {
	private String nombre;
	private int[] notas;

	public Modulo(String nombre) {
		this.nombre = nombre;
		notas = new int[3];
	}

	public Modulo(String nombre, int nota1, int nota2, int nota3) {
		this.nombre = nombre;
		notas = new int[3];
		notas[0] = nota1;
		notas[1] = nota2;
		notas[2] = nota3;
	}

	public Modulo(String nombre, int[] notas) {
		this.nombre = nombre;
		this.notas = notas;
	}

	// metodo para guardar las notas. Las evaluaciones son 1,2 y 3
	public void setNota(int evaluacion, int nota) {
		if (evaluacion > 0 && evaluacion < 4) {
			notas[evaluacion - 1] = nota;
		}
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public int getNota(int evaluacion) {
		if (evaluacion > 0 && evaluacion < 4) {
			return notas[evaluacion - 1];
		} else {
			return 0;
		}
	}

	public int[] getNotas() {
		return notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float notaMedia() {
		return (float) (notas[0] + notas[1] + notas[2]) / 3;
	}

	@Override
	public String toString() {
		return nombre + "\t" + notas[0] + "\t" + notas[1] + "\t" + notas[2];
	}
}
