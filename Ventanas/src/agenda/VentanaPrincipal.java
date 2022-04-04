package agenda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private Agenda agenda;
	private Vector<Vector<Object>> datosTabla;
	private JTable table;

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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);

		this.agenda = new Agenda();

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 39, 394, 168);
		contentPane.add(scrollPane);

		datosTabla = new Vector<Vector<Object>>();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
			"Nombre", "Numero"
		}));

		scrollPane.setViewportView(table);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setBounds(25, 228, 106, 25);
		contentPane.add(btnNuevo);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(313, 228, 106, 25);
		contentPane.add(btnEliminar);
	}

	private void nuevo() {
		DialogoNuevoContacto dialogoNuevoContacto = new DialogoNuevoContacto(
			this, true
		);
		dialogoNuevoContacto.setLocationRelativeTo(this);
		dialogoNuevoContacto.setVisible(true);

		actualizarTablaContactos();
	}

	private void eliminar() {
		DialogoEliminarContacto dialogoEliminarContacto =
			new DialogoEliminarContacto(this, true);
		dialogoEliminarContacto.setLocationRelativeTo(this);
		dialogoEliminarContacto.setVisible(true);

		actualizarTablaContactos();
	}

	private void actualizarTablaContactos() {
		Object[][] datos = new Object[this.agenda.size()][2];
		ArrayList<Contacto> lista = this.agenda.getLista();

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = lista.get(i).getNombre();
			datos[i][1] = lista.get(i).getTelefono();
		}

		table.setModel(new DefaultTableModel(datos, new String[] {
			"Nombre", "Telefono"
		}));
	}

	public Agenda getAgenda() {
		return this.agenda;
	}
}
