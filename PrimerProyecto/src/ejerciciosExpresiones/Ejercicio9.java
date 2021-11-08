package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio9 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce un numero: ");
    int n = scanner.nextInt();
    scanner.close();

    int n_reves = 0;

    for (int i = n; i != 0; i /= 10) {
      n_reves *= 10;
      n_reves += i % 10;
    }

    System.out.println("\nNumero del reves: " + n_reves);
  }
}
