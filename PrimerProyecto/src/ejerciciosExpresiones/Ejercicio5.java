package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio5 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce segundos: ");
    int tSegs = scanner.nextInt();
    scanner.close();

    int hrs = tSegs / 3600;
    int segsLeft = tSegs % 3600;
    int mns = segsLeft / 60;
    int segs = segsLeft - mns * 60;
    System.out.println("\n" + hrs + ':' + mns + ':' + segs);
  }
}
