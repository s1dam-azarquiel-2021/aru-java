package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;

import customReaderWriter.CustomObjectInputStream;
import customReaderWriter.CustomObjectOutputStream;

public class Fusionar {
	private String fCompras;
	private ArrayList<Compra> compras;

	public static void main(String[] args) {
		Fusionar fusionar = new Fusionar("compras.obj");

		fusionar.cargarCompras();
		fusionar.fusionarCompras();
	}

	public Fusionar(String fCompras) {
		this.fCompras = fCompras;
		this.compras = new ArrayList<>();
	}

	public void cargarCompras() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					compras.add((Compra) stream.readObject());
				}
			}
		};

		ois.read(this.fCompras);
	}

	public void fusionarCompras() {
		CustomObjectOutputStream oos = new CustomObjectOutputStream() {
			public void main() throws IOException {
				for (int i = 0; i < compras.size(); i++) {
					Compra compra = compras.get(i);

					if (compra != null) {
						for (int j = i + 1; j < compras.size(); j++) {
							Compra compra2 = compras.get(j);

							if (
								compra2 != null
								&& compra2.getDepartamento().equals(
									compra.getDepartamento()
								)
							) {
								compra.setCantidad(
									compra.getCantidad() + compra2.getCantidad()
								);

								compras.set(j, null);
							}
						}
						stream.writeObject(compra);
					}
				}
			}
		};

		oos.write(this.fCompras);
	}

	public ArrayList<Compra> getCompras() {
		return this.compras;
	}
}
