package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio6 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce dinero: ");
    int dinero = scanner.nextInt();
    scanner.close();

    System.out.print("");
    final int[] billetes = { 500, 200, 100, 50, 20, 10, 5 };

    for (int i : billetes) {
	System.out.println("Billetes de " + i + ": " + (dinero / i));
	dinero %= i;
    }
  }
}
