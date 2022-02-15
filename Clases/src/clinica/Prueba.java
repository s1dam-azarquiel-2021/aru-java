package clinica;
public class Prueba {
	public static void main(String[] args) {
		Paciente fonsi = new Paciente("fonsi", "c1");
		Paciente juan = new Paciente("juan", "c2");
		Paciente david = new Paciente("david", "c3");
		ListaDeEspera lista = new ListaDeEspera();
		lista.add(fonsi);
		lista.add(juan);
		lista.add(david);
		System.out.printf("%s\n", lista);
		lista.colar(david, 0);
		System.out.printf("%s\n", lista);
		System.out.printf("Atendiendo a:\n%s\n", lista.atender());
		System.out.printf("%s\n", lista);
		System.out.printf("Atendiendo a:\n%s\n", lista.atender(juan));
		System.out.printf("%s\n", lista);
	}
}
