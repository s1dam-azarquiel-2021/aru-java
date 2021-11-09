public class Operadores {
	public static void main(String[] args) {
		int a = 2,
			b = 8,
			c = 3;

		System.out.println(++a);
		System.out.println(a++);

		System.out.println(a != c);
		System.out.println(a > b);

		char letra = 'F';

		System.out.println(letra > 'W');

		boolean hayToner = true,
				hayPapel = true,
				resultado;

		resultado = hayToner && hayPapel;

		System.out.println("Se puede imprimir? " + resultado);
	}
}
