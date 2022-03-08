package examenCursoPasado;

public class Prueba {
	public static void main(String[] args) {
		Vivienda vivienda = new Vivienda();
		Banio banio = new Banio(10, 1, 200, true);
		Salon salon = new Salon(50, 3, 1000);
		Dormitorio dormitorio = new Dormitorio(30, 2, 800, 3);
		vivienda.add(banio);
		vivienda.add(salon);
		vivienda.add(dormitorio);
		vivienda.imprimirViviendas();
		System.out.printf("Camas: %d\n", vivienda.camas());
		System.out.printf("Precio: %f\n", vivienda.costeTotal());
	}
}
