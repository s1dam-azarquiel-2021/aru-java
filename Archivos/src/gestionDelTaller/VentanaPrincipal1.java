package gestionDelTaller;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import customReaderWriter.CustomObjectInputStream;

public class VentanaPrincipal1 extends JFrame {
	private ArrayList<Intervencion> intervenciones;
	private ArrayList<Vehiculo> vehiculos;
	private String ficheroIntervenciones;
	private String ficheroVehiculos;
	private JTable tableIntervenciones;
	private JComboBox<String> matricula;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaPrincipal1 frame = new VentanaPrincipal1();
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
	public VentanaPrincipal1() {
		this.ficheroIntervenciones = "intervenciones.obj";
		this.ficheroVehiculos = "vehiculos.obj";

		this.vehiculos = new ArrayList<>();
		this.cargarVehiculos();

		this.intervenciones = new ArrayList<>();
		this.cargarIntervenciones();

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 400);

		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel topPane = new JPanel();
		topPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topPane.setMaximumSize(new Dimension(this.getWidth(), 30));
		contentPane.add(topPane);

		contentPane.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel label = new JLabel("Matricula:");
		topPane.add(label);

		matricula = new JComboBox<>();
		matricula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTablaIntervenciones();
			}
		});
		matricula.setModel(new DefaultComboBoxModel<>(this.matriculas()));
		topPane.add(matricula);

		JScrollPane scrollPaneIntervenciones = new JScrollPane();
		contentPane.add(scrollPaneIntervenciones);

		tableIntervenciones = new JTable();
		this.actualizarTablaIntervenciones();

		scrollPaneIntervenciones.setViewportView(tableIntervenciones);
	}

	private String[] matriculas() {
		String[] matriculas = new String[this.vehiculos.size() + 1];
		matriculas[0] = "Todas";
		for (int i = 1; i < matriculas.length; i++) {
			matriculas[i] = this.vehiculos.get(i - 1).getMatricula();
		}

		return matriculas;
	}

	public void cargarVehiculos() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			@Override
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
			@Override
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					intervenciones.add((Intervencion) stream.readObject());
				}
			}
		};

		ois.read(this.ficheroIntervenciones);
	}

	private ArrayList<Intervencion> getIntervenciones(Vehiculo vehiculo) {
		if (vehiculo == null) {
			return this.intervenciones;
		}

		ArrayList<Intervencion> intervenciones = new ArrayList<>();
		for (Intervencion intervencion : this.intervenciones) {
			if (intervencion.getMatricula().equals(vehiculo.getMatricula())) {
				intervenciones.add(intervencion);
			}
		}

		return intervenciones;
	}

	private Vehiculo getVehiculo(String matricula) {
		for (Vehiculo vehiculo : this.vehiculos) {
			if (vehiculo.getMatricula().equals(matricula)) {
				return vehiculo;
			}
		}

		return null;
	}

	public void actualizarTablaIntervenciones() {
		ArrayList<Intervencion> intervenciones = this.getIntervenciones(
			this.getVehiculo((String) this.matricula.getSelectedItem())
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

				@Override
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};

				@Override
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
