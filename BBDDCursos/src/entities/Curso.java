package entities;

import java.sql.Date;

public class Curso {
	private int codigo;
	private String curso;
	private Date fechaInicio;
	private Date fechaFin;
	private String horaInicio;
	private String horaFin;

	public Curso(
		int codigo, String curso, Date fechaInicio, Date fechaFin,
		String horaInicio, String horaFin
	) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getCurso() {
		return this.curso;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public String getHoraFin() {
		return this.horaFin;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\ncurso: " + curso + "\nfechaInicio: "
		+ fechaInicio + "\nfechaFin: " + fechaFin + "\nhoraInicio: "
		+ horaInicio + "\nhoraFin: " + horaFin + "\n";
	}
}
