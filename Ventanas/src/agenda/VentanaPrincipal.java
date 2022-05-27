package agenda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private Agenda agenda;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 460, 320);

		this.agenda = new Agenda();

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 410, 210);
		contentPane.add(scrollPane);

		table = new JTable();
		this.actualizarTablaContactos();

		scrollPane.setViewportView(table);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setBounds(20, 250, 100, 30);
		contentPane.add(btnNuevo);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(330, 250, 100, 30);
		contentPane.add(btnEliminar);
	}

	private void nuevo() {
		DialogoNuevoContacto dialogoNuevoContacto = new DialogoNuevoContacto(
			this,
			true
		);
		dialogoNuevoContacto.setLocationRelativeTo(this);
		dialogoNuevoContacto.setVisible(true);

		this.actualizarTablaContactos();
	}

	private void eliminar() {
		DialogoEliminarContacto dialogoEliminarContacto =
			new DialogoEliminarContacto(this, true);
		dialogoEliminarContacto.setLocationRelativeTo(this);
		dialogoEliminarContacto.setVisible(true);

		this.actualizarTablaContactos();
	}

	private void actualizarTablaContactos() {
		Object[][] datos = new Object[this.agenda.size()][2];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = this.agenda.getLista().get(i).getNombre();
			datos[i][1] = this.agenda.getLista().get(i).getTelefono();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Nombre", "Telefono"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, Long.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, false
			};

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	public Agenda getAgenda() {
		return this.agenda;
	}
}
