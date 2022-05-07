package gestionDelTaller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import customReaderWriter.CustomObjectInputStream;

public class VentanaPrincipal2 extends JFrame {
	private ArrayList<Intervencion> intervenciones;
	private ArrayList<Vehiculo> vehiculos;
	private String ficheroIntervenciones;
	private String ficheroVehiculos;
	private JTable tableVehiculos;
	private JTable tableIntervenciones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaPrincipal2 frame = new VentanaPrincipal2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal2() {
		this.ficheroIntervenciones = "intervenciones.obj";
		this.ficheroVehiculos = "vehiculos.obj";

		this.vehiculos = new ArrayList<Vehiculo>();
		this.cargarVehiculos();

		this.intervenciones = new ArrayList<Intervencion>();
		this.cargarIntervenciones();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 400);

		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JScrollPane scrollPaneVehiculos = new JScrollPane();
		contentPane.add(scrollPaneVehiculos);

		tableVehiculos = new JTable();
		tableVehiculos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				actualizarTablaIntervenciones();
			}
		});
		this.actualizarTablaVehiculos();

		scrollPaneVehiculos.setViewportView(tableVehiculos);

		JScrollPane scrollPaneIntervenciones = new JScrollPane();
		contentPane.add(scrollPaneIntervenciones);

		tableIntervenciones = new JTable();

		scrollPaneIntervenciones.setViewportView(tableIntervenciones);
	}

	public void cargarVehiculos() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					Vehiculo vehiculo = (Vehiculo) stream.readObject();
					vehiculos.add(vehiculo);
				}
			}
		};

		ois.read(this.ficheroVehiculos);
	}

	public void cargarIntervenciones() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					intervenciones.add((Intervencion) stream.readObject());
				}
			}
		};

		ois.read(this.ficheroIntervenciones);
	}

	public void actualizarTablaVehiculos() {
		Object[][] datos = new Object[this.vehiculos.size()][4];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = this.vehiculos.get(i).getMatricula();
			datos[i][1] = this.vehiculos.get(i).getMarca();
			datos[i][2] = this.vehiculos.get(i).getModelo();
			datos[i][3] = this.vehiculos.get(i).getPropietario();
		}

		this.tableVehiculos.setModel(new DefaultTableModel(datos, new String[] {
			"Matricula", "Marca", "Modelo", "Propietario"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	private ArrayList<Intervencion> getIntervenciones(Vehiculo vehiculo) {
		ArrayList<Intervencion> intervenciones = new ArrayList<Intervencion>();
		for (Intervencion intervencion : this.intervenciones) {
			if (intervencion.getMatricula().equals(vehiculo.getMatricula())) {
				intervenciones.add(intervencion);
			}
		}

		return intervenciones;
	}

	public void actualizarTablaIntervenciones() {
		if (this.tableVehiculos.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "No estas seleccionando ningun modulo", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		ArrayList<Intervencion> intervenciones = this.getIntervenciones(
			this.vehiculos.get(this.tableVehiculos.getSelectedRow())
		);

		Object[][] datos = new Object[intervenciones.size()][4];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = intervenciones.get(i).getFecha();
			datos[i][1] = intervenciones.get(i).getMatricula();
			datos[i][2] = intervenciones.get(i).getCoste();
			datos[i][3] = intervenciones.get(i).getDescripcion();
		}

		this.tableIntervenciones.setModel(
			new DefaultTableModel(datos, new String[] {
				"Fecha", "Matricula", "Coste", "Descripcion"
			}) {
				private static final long serialVersionUID = 1L;

				Class[] columnTypes = new Class[] {
					Date.class, String.class, Float.class, String.class
				};

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			}
		);

		this.tableIntervenciones.getColumnModel().getColumn(
			3
		).setPreferredWidth(400);
	}
}
