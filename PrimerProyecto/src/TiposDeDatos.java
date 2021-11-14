public class TiposDeDatos {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean papel = true;
		System.out.printf("%s\n", papel);

		char letra = 'f';
		letra = '8';
		letra = '\n';

		String frase = "Buenos dias.\nQue tal estamos";
		System.out.printf("%s\n", frase);

		byte enano = 127;
		short mediano = 32767;
		int grande = enano + mediano;
		long enorme;

		mediano = (short) (enano + 500);
		enano = (byte) (127 + 1);

		System.out.printf("%d\n", grande);
		System.out.printf("%d\n", enano);

		float pocos = 2.59375397f;
		double muchos = 7484.5148;

		System.out.printf("%f\n", pocos);
		System.out.printf("%f\n", muchos);
	}
}
