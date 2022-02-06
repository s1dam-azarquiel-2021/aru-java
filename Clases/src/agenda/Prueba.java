package agenda;

public class Prueba {
	public static void main(String[] args) {
		Contacto juan = new Contacto("Juan", 123456789);
		Contacto fonsi = new Contacto("Fonsi", 234567891);
		Contacto hugo = new Contacto("Hugo", 345678912);
		Agenda agenda = new Agenda(20);
		agenda.add(juan);
		agenda.add(fonsi);
		agenda.add(hugo);
		System.out.printf("%s\n", agenda);
		agenda.remove(juan);
		agenda.remove(hugo);
		System.out.printf("%s\n", agenda);
		System.out.printf("%s\n", agenda.find("Fonsi"));
		System.out.printf("%s\n", agenda.find("Pepino"));
	}
}
