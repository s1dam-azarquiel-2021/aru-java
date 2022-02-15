package agenda;

public class Prueba2 {
	public static void main(String[] args) {
		Contacto juan = new Contacto("Juan", 123456789);
		Contacto fonsi = new Contacto("Fonsi", 234567891);
		Contacto hugo = new Contacto("Hugo", 345678912);
		AgendaV2 agenda = new AgendaV2();
		agenda.add(juan);
		agenda.add(fonsi);
		agenda.add(hugo);
		System.out.printf("%s\n", agenda);
		agenda.remove(juan);
		agenda.remove(hugo);
		System.out.printf("%s\n", agenda);
		System.out.printf("%s\n", agenda.get("Fonsi"));
		System.out.printf("%s\n", agenda.get(234567891));
		agenda.update(fonsi, "Pepino");
		System.out.printf("%s\n", agenda.get("Pepino"));
		agenda.update(fonsi, 456789123);
		System.out.printf("%s\n", agenda.get(456789123));
	}
}
