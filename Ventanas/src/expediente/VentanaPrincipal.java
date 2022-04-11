package expediente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private JTextField txtFieldAlumno;
	private JTable table;
	private Expediente expediente;

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 770, 410);

		this.expediente = new Expediente(new Alumno("1234A", "Alberto"));

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);

		JLabel lblAlumno = new JLabel("Alumno:");
		lblAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlumno.setBounds(20, 20, 100, 30);
		contentPane.add(lblAlumno);

		txtFieldAlumno = new JTextField();
		txtFieldAlumno.setEditable(false);
		txtFieldAlumno.setText(this.expediente.getAlumno().getNombre());
		txtFieldAlumno.setBounds(140, 20, 300, 30);
		contentPane.add(txtFieldAlumno);
		txtFieldAlumno.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 600, 300);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNuevoModulo = new JButton("Nuevo");
		btnNuevoModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoModulo();
			}
		});
		btnNuevoModulo.setBounds(640, 100, 100, 30);
		contentPane.add(btnNuevoModulo);

		JButton btnModificarModulo = new JButton("Modificar");
		btnModificarModulo.setBounds(640, 140, 100, 30);
		contentPane.add(btnModificarModulo);

		JButton btnEliminarModulo = new JButton("Elimininar");
		btnEliminarModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarModulo();
			}
		});
		btnEliminarModulo.setBounds(640, 180, 100, 30);
		contentPane.add(btnEliminarModulo);

		this.actualizarTablaModulos();
	}

	private void nuevoModulo() {
		DialogoNuevoModulo dialogoNuevoModulo = new DialogoNuevoModulo(
			this, true
		);
		dialogoNuevoModulo.setLocationRelativeTo(this);
		dialogoNuevoModulo.setVisible(true);

		this.actualizarTablaModulos();
	}

	private void eliminarModulo() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "No estas seleccionando ningun modulo", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			this.expediente.removeModulo(
				this.expediente.getModulos().get(
					this.table.getSelectedRow()
				).getNombre()
			);

			this.actualizarTablaModulos();
		}
	}

	private void actualizarTablaModulos() {
		Object[][] datos = new Object[this.expediente.getModulos().size()][5];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = this.expediente.getModulos().get(i).getNombre();
			datos[i][1] = this.expediente.getModulos().get(i).getNota(1);
			datos[i][2] = this.expediente.getModulos().get(i).getNota(2);
			datos[i][3] = this.expediente.getModulos().get(i).getNota(3);
			datos[i][4] = this.expediente.getModulos().get(i).notaMedia();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Modulo", "Nota 1aEv", "Nota 2aEv", "Nota 3aEv", "Media"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class,
				Float.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	public Expediente getExpediente() {
		return this.expediente;
	}
}
