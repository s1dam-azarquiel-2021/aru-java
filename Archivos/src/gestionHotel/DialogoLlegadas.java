package gestionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DialogoLlegadas extends JDialog {
	private JTable table;
	private Habitacion habitacion;

	public DialogoLlegadas(JFrame padre, boolean modal, Habitacion habitacion) {
		super(padre, modal);
		this.habitacion = habitacion;

		this.setBounds(100, 100, 600, 300);
		this.getRootPane().setBorder(new EmptyBorder(20, 20, 20, 20));
		this.getContentPane().setLayout(new BorderLayout(20, 20));

		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		this.getContentPane().add(mainPane, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Clientes");
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		mainPane.add(titulo);

		mainPane.add(Box.createRigidArea(new Dimension(0, 20)));

		JScrollPane scrollTable = new JScrollPane();
		mainPane.add(scrollTable);

		table = new JTable();
		scrollTable.setViewportView(table);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
		this.getContentPane().add(buttonPane, BorderLayout.EAST);

		Dimension btnSpacer = new Dimension(0, 10);

		buttonPane.add(Box.createVerticalGlue());

		JButton nuevoButton = new JButton("Nuevo");
		nuevoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		buttonPane.add(nuevoButton);

		buttonPane.add(Box.createRigidArea(btnSpacer));

		JButton okButton = new JButton("Aceptar");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		buttonPane.add(Box.createRigidArea(btnSpacer));

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelButton);

		buttonPane.add(Box.createVerticalGlue());

		this.updateTable();
	}

	private void nuevo() {
		DialogoNuevoCliente dialogoNuevoCliente = new DialogoNuevoCliente(
			this,
			true,
			((VentanaPrincipal) this.getParent()).getGestorClientes().getClientes()
		);
		dialogoNuevoCliente.setLocationRelativeTo(this);
		dialogoNuevoCliente.setVisible(true);

		this.updateTable();
	}

	private void aceptar() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "Selecciona un cliente.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		Cliente cliente =
			((VentanaPrincipal) this.getParent()).getGestorClientes().getClientes().get(
				this.table.getSelectedRow()
			);

		this.habitacion.setDni(cliente.getDni());
		this.habitacion.setDisponible(false);

		this.dispose();
	}

	private void cancelar() {
		this.dispose();
	}

	private void updateTable() {
		ArrayList<Cliente> clientes =
			((VentanaPrincipal) this.getParent()).getGestorClientes().getClientes();

		Object[][] datos = new Object[clientes.size()][2];

		for (int i = 0; i < datos.length; i++) {
			final Cliente cliente = clientes.get(i);

			datos[i][0] = cliente.getDni();
			datos[i][1] = cliente.getNombre();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Dni", "Nombre"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, String.class
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
}
