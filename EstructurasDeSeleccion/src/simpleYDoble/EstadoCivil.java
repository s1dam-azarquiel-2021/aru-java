package simpleYDoble;

import java.util.Scanner;

public class EstadoCivil {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Introduce tu letra del estado civil: ");
	char letra = scanner.nextLine().charAt(0);
	scanner.close();
	
	switch (letra) {
	case 's':
	case 'S':
	    System.out.println("Soltero/a");
	case 'c':
	case 'C':
	    System.out.println("Casado/a");
	case 'v':
	case 'V':
	    System.out.println("Viudo/a");
	case 'd':
	case 'D':
	    System.out.println("Divorciado/a");
	default:
	    System.out.println("Letra incorrecta");
	}
    }
}
