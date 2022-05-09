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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DialogoGestionHabitaciones extends JDialog {
	private JTable table;
	private ArrayList<Habitacion> habitaciones;

	public DialogoGestionHabitaciones(
		JFrame padre, boolean modal, ArrayList<Habitacion> habitaciones
	) {
		super(padre, modal);
		this.habitaciones = habitaciones;

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
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		buttonPane.add(Box.createHorizontalGlue());

		JButton okButton = new JButton("Aceptar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelButton);

		this.updateTable();
	}

	private void aceptar() {
		for (int i = 0; i < this.table.getRowCount(); i++) {
			((VentanaPrincipal) this.getParent()).getGestorHabitaciones().getHabitacion(
				(int) this.table.getValueAt(i, 0)
			).setDisponible((boolean) this.table.getValueAt(i, 1));
		}

		this.dispose();
	}

	private void cancelar() {
		this.dispose();
	}

	private void updateTable() {
		Object[][] datos = new Object[this.habitaciones.size()][2];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = this.habitaciones.get(i).getNumero();
			datos[i][1] = this.habitaciones.get(i).isDisponible();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Habitacion", "Disponible"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				Integer.class, Boolean.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, true
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
