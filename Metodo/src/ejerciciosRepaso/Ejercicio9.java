package ejerciciosRepaso;

public class Ejercicio9 {
	public static boolean esMatricula(String matricula) {
		return matricula.matches("\\d{4}\\w{3}|\\w{1,2}\\d{4}\\w{1,2}");
	}
}
