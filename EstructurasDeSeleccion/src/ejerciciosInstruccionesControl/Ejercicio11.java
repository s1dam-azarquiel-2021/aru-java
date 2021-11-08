package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		// Obtener un numero del 0 al 99 por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero del 0 al 99: ");
		int n = input.nextInt();
		input.close();
		
		// Sacar las cifras
		final int c1 = n / 10,
				  c2 = n % 10;
		
		// 2a cifra escrita
		String c2_escrito = "";
		switch (c2) {
		case 0: c2_escrito = "cero"; break;
		case 1: c2_escrito = "uno"; break;
		case 2: c2_escrito = "dos"; break;
		case 3: c2_escrito = "tres"; break;
		case 4: c2_escrito = "cuatro"; break;
		case 5: c2_escrito = "cinco"; break;
		case 6: c2_escrito = "seis"; break;
		case 7: c2_escrito = "siete"; break;
		case 8: c2_escrito = "ocho"; break;
		case 9: c2_escrito = "nueve"; break;
		}
		
		// Segun la primera cifra todo cambia
		String resultado  = "",
			   c1_escrita = "";
		switch (c1) {
		case 0: resultado = c2_escrito; break;
		case 1:
			switch (c2) {
			case 0:  resultado = "diez"; break;
			case 1:  resultado = "once"; break;
			case 2:  resultado = "doce"; break;
			case 3:  resultado = "trece"; break;
			case 4:  resultado = "catorce"; break;
			case 5:  resultado = "quince"; break;
			default: resultado = "dieci" + c2_escrito; break;
			}
			break;
		case 2:
			if (c2 == 0) { resultado = "veinte"; }
			else         { resultado = "veinti" + c2_escrito; }
			break;
		case 3: c1_escrita = "treinta"; break;
		case 4: c1_escrita = "cuarenta"; break;
		case 5: c1_escrita = "cincuenta"; break;
		case 6: c1_escrita = "sesenta"; break;
		case 7: c1_escrita = "setenta"; break;
		case 8: c1_escrita = "ochenta"; break;
		case 9: c1_escrita = "noventa"; break;
		}
		
		// Solo se han asignado resultados a casos especiales, el resto se
		// forman segun acaban en 0 o no
		if (resultado == "") {
			resultado = c1_escrita + " y " + c2_escrito;
		}
		
		System.out.println(resultado);
	}
}
