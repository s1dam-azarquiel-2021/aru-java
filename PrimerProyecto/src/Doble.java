import java.util.Scanner;
public class Doble {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce un numero: ");
		double n = scanner.nextDouble();
		System.out.printf("%f\n", n * 2);
		scanner.close();
	}
}
