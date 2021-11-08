package simpleYDoble;

import java.util.Scanner;

public class EsVocal {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Introduce una vocal:");
	char vocal = scanner.nextLine().charAt(0);
	scanner.close();
	
	switch (vocal) {
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':
	case 'A':
	case 'E':
	case 'I':
	case 'O':
	case 'U':
	    System.out.println("Es una vocal");
	default:
	    System.out.println("No es una vocal");
	}
    }
}
