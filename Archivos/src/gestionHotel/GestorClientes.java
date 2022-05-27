package gestionHotel;

import java.io.IOException;
import java.util.ArrayList;

import customReaderWriter.CustomObjectInputStream;
import customReaderWriter.CustomObjectOutputStream;

public class GestorClientes {
	private ArrayList<Cliente> clientes;
	private String archivo;

	public GestorClientes(String archivo) {
		super();
		this.archivo = archivo;
		this.clientes = new ArrayList<>();
	}

	public void read() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			@Override
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					clientes.add((Cliente) stream.readObject());
				}
			}
		};

		ois.read(this.archivo);
	}

	public void write() {
		CustomObjectOutputStream oos = new CustomObjectOutputStream() {
			@Override
			public void main() throws IOException {
				for (Cliente cliente : clientes) {
					stream.writeObject(cliente);
				}
			}
		};

		oos.write(this.archivo);
	}

	public Cliente getCliente(String dni) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}

		return null;
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
}
