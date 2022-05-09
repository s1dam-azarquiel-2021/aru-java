package gestionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private JTable table;
	private GestorClientes gestorClientes;
	private GestorHabitaciones gestorHabitaciones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		this.gestorClientes = new GestorClientes("Clientes.obj");
		this.gestorClientes.read();

		this.gestorHabitaciones = new GestorHabitaciones("habitaciones.obj");
		this.gestorHabitaciones.read();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				gestorClientes.write();
				gestorHabitaciones.write();
			}
		});

		JPanel mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPane.setLayout(new BorderLayout(20, 20));
		this.setContentPane(mainPane);

		JLabel title = new JLabel("Hotel Azarquiel");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		mainPane.add(title, BorderLayout.NORTH);

		JScrollPane scrollTable = new JScrollPane();
		mainPane.add(scrollTable, BorderLayout.CENTER);

		table = new JTable();
		scrollTable.setViewportView(table);

		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BorderLayout());
		mainPane.add(bottomPane, BorderLayout.SOUTH);

		JButton btnGestionHabitaciones = new JButton("Gestion de Habitaciones");
		btnGestionHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionHabitaciones();
			}
		});
		bottomPane.add(btnGestionHabitaciones, BorderLayout.WEST);

		JPanel bottomPaneRight = new JPanel();
		bottomPaneRight.setLayout(
			new BoxLayout(bottomPaneRight, BoxLayout.X_AXIS)
		);
		bottomPane.add(bottomPaneRight, BorderLayout.EAST);

		JButton btnLlegadas = new JButton("Llegada");
		btnLlegadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llegada();
			}
		});
		bottomPaneRight.add(btnLlegadas);

		bottomPaneRight.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton btnSalidas = new JButton("Salida");
		btnSalidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salida();
			}
		});
		bottomPaneRight.add(btnSalidas);

		this.updateTable();
	}

	private void gestionHabitaciones() {
		DialogoGestionHabitaciones dialogoGestionHabitaciones =
			new DialogoGestionHabitaciones(
				this,
				true,
				this.gestorHabitaciones.getHabitaciones()
			);
		dialogoGestionHabitaciones.setLocationRelativeTo(this);
		dialogoGestionHabitaciones.setVisible(true);

		this.updateTable();
	}

	private void llegada() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "Selecciona una habitacion.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		Habitacion habitacion = this.gestorHabitaciones.getHabitaciones().get(
			this.table.getSelectedRow()
		);

		if (!habitacion.isDisponible()) {
			JOptionPane.showMessageDialog(
				this, "Esta habitacion no esta disponible.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		DialogoLlegadas dialogoLlegadas = new DialogoLlegadas(
			this,
			true,
			habitacion
		);
		dialogoLlegadas.setLocationRelativeTo(this);
		dialogoLlegadas.setVisible(true);

		this.updateTable();
	}

	private void salida() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "Selecciona una habitacion.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		Habitacion habitacion = this.gestorHabitaciones.getHabitaciones().get(
			this.table.getSelectedRow()
		);

		if (habitacion.getDni() == null) {
			JOptionPane.showMessageDialog(
				this, "Esta habitacion esta vacia.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		Cliente cliente = this.gestorClientes.getCliente(habitacion.getDni());
		habitacion.setDni(null);

		JOptionPane.showMessageDialog(
			this, "El cliente " + cliente.getNombre() + " se ha marchado.",
			"Done", JOptionPane.INFORMATION_MESSAGE
		);

		this.updateTable();
	}

	private void updateTable() {
		ArrayList<Habitacion> habitaciones =
			this.gestorHabitaciones.getHabitaciones();

		Object[][] datos = new Object[habitaciones.size()][4];

		for (int i = 0; i < datos.length; i++) {
			Habitacion habitacion = habitaciones.get(i);

			datos[i][0] = habitacion.getNumero();
			datos[i][1] = habitacion.getDni();

			if (habitacion.getDni() == null) {
				datos[i][2] = "";
			} else {
				datos[i][2] = this.gestorClientes.getCliente(
					habitacion.getDni()
				).getNombre();
			}

			datos[i][3] = habitacion.isDisponible();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Habitacion", "Dni", "Nombre", "Disponible"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Boolean.class
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

	public GestorClientes getGestorClientes() {
		return this.gestorClientes;
	}

	public GestorHabitaciones getGestorHabitaciones() {
		return this.gestorHabitaciones;
	}
}
