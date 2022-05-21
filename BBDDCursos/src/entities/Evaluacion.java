package entities;

public class Evaluacion {
	private Alumno alumno;
	private Curso curso;
	private int notaFinal;
	private String observaciones;

	public Evaluacion(
		Alumno alumno, Curso curso, int notaFinal, String observaciones
	) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.notaFinal = notaFinal;
		this.observaciones = observaciones;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public int getNotaFinal() {
		return this.notaFinal;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	@Override
	public String toString() {
		return "alumno: " + alumno + "\ncurso: " + curso + "\nnotaFinal: "
		+ notaFinal + "\nobservaciones: " + observaciones + "\n";
	}
}
