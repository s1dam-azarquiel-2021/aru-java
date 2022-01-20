package pruebas;

public class PonerPuntoFinal {
	public static void main(String[] args) {
		StringBuilder frase = new StringBuilder("Frase sin punto");
		System.out.printf("%s\n", ponerPuntoFinal(frase));
	}

	public static StringBuilder ponerPuntoFinal(StringBuilder st) {
		StringBuilder copia = new StringBuilder(st);
		return copia.append(".");
	}
}
