package arrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class LeerNumeros {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		do {
			numeros.add(input.nextInt());
		} while (numeros.get(numeros.size() - 1) != 0);
		input.close();
		numeros.remove(numeros.size() - 1);

		for (int n : numeros) {
			System.out.printf("%d\n", n);
		}
	}
}
