package ejercicio2;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private DAOCliente daoCliente = new DAOCliente();
	private DAOMascota daoMascota = new DAOMascota();
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
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		this.daoCliente = new DAOCliente();
		this.daoMascota = new DAOMascota();

		this.setTitle("Censo Electoral");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 400);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		contentPane.add(Box.createVerticalGlue());

		this.table = new JTable();
		scrollPane.setViewportView(this.table);

		JButton nuevo = new JButton("Nueva Mascota");
		nuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		nuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevaMascota();
			}
		});
		contentPane.add(nuevo);

		this.updateTable();
	}

	private void nuevaMascota() {
		DialogoNuevaMascota dialogoModificarModulo = new DialogoNuevaMascota(
			this,
			true
		);
		dialogoModificarModulo.setLocationRelativeTo(this);
		dialogoModificarModulo.setVisible(true);

		this.updateTable();
	}

	private void updateTable() {
		ArrayList<Mascota> mascotas = this.daoMascota.get();
		Object[][] datos = new Object[mascotas.size()][6];

		for (int i = 0; i < datos.length; i++) {
			Cliente cliente = this.daoCliente.get(
				mascotas.get(i).getDniCliente()
			);

			datos[i][0] = mascotas.get(i).getNumero();
			datos[i][1] = mascotas.get(i).getNombreMascota();
			datos[i][2] = mascotas.get(i).getTipoDeAnimal();
			datos[i][3] = mascotas.get(i).getRaza();
			datos[i][4] = mascotas.get(i).getFechaDeNacimiento();
			if (cliente != null) {
				datos[i][5] = cliente.getNombre();
			} else {
				datos[i][5] = "";
			}
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Numero", "Nombre", "Tipo de Animal", "Raza", "Fecha de nacimiento",
			"Cliente"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class,
				String.class, String.class, String.class
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
		});
	}

	public DAOMascota getDaoMascota() {
		return this.daoMascota;
	}
}
