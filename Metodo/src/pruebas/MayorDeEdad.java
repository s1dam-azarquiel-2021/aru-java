package pruebas;

public class MayorDeEdad {
	public static void main(String[] args) {
		if (mayorDeEdad(19)) {
			System.out.printf("Eres mayor de edad.\n");
		} else {
			System.out.printf("Eres menor de edad.\n");
		}
	}

	public static boolean mayorDeEdad(int edad) {
		return edad >= 18;
	}
}
