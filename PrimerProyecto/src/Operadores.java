public class Operadores {
	public static void main(String[] args) {
		int a = 2,
			b = 8,
			c = 3;

		System.out.printf("%d\n", ++a);
		System.out.printf("%d\n", a++);

		System.out.printf("%s\n", a != c);
		System.out.printf("%s\n", a > b);

		char letra = 'F';

		System.out.printf("%s\n", letra > 'W');

		boolean hayToner = true,
				hayPapel = true,
				resultado;

		resultado = hayToner && hayPapel;

		System.out.printf("Se puede imprimir? %s", resultado);
	}
}
