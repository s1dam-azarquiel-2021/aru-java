package ejerciciosRepaso;

public class Ejercicio10 {
	public static boolean mismoADN(String st1, String st2) {
		if (st1.length() != st2.length()) {
			return false;
		}

		for (int i = 0; i < st1.length(); i++) {
			String st = st1.substring(i, st1.length()) + st1.substring(0, i);
			if (st.equals(st2)) {
				return true;
			}
		}

		return false;
	}
}
