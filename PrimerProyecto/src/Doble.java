import java.util.Scanner;
public class Doble {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Introduce un numero: ");
         double n = scanner.nextDouble();
         System.out.println("\n" + (n * 2));
         scanner.close();
    }
}
