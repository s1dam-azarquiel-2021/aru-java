package pruebas;

public class PruebaStringBuilder {
	public static void main(String[] args) {
		String s = "Hola";
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder(500);
		StringBuilder sb3 = new StringBuilder("Hola");
		StringBuilder sb4 = new StringBuilder(s);
		
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());
		System.out.println(sb4.capacity());
		
		sb3.append(" que tal");
		System.out.println(sb3.length());
		System.out.println(sb3.capacity());
		
		String f1 = "Hola";
		String f2 = " que tal";
		
		StringBuilder f3 = new StringBuilder("Hola");
		StringBuilder f4 = new StringBuilder(" que tal");
		
		f1 = f1.concat(f2);
		f3.append(f4);
		
		System.out.println(f1);
		System.out.println(f3);
		
		f1 = "Hola";
		f2 = new String("Hola");
		
		if (f1.equals(f2)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}
		
		f3 = new StringBuilder("Hola");
		f4 = new StringBuilder("Hola");
		
		if (f3.equals(f4)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}
	}
}
