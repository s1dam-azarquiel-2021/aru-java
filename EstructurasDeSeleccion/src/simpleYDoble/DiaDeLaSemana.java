package simpleYDoble;

import java.util.Scanner;

public class DiaDeLaSemana {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Introduce numero de dia:");
	int dia = scanner.nextInt();
	scanner.close();
	
	switch (dia) {
	case 1:
	    System.out.println("\nLunes");
	case 2:
	    System.out.println("\nMartes");
	case 3:
	    System.out.println("\nMiercoles");
	case 4:
	    System.out.println("\nJueves");
	case 5:
	    System.out.println("\nViernes");
	case 6:
	    System.out.println("\nSabado");
	case 7:
	    System.out.println("\nDomingo");
	default:
	    System.out.println("\nEse numero no existe");
	}
    }
}
