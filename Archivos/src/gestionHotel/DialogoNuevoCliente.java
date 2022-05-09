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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogoNuevoCliente extends JDialog {
	private ArrayList<Cliente> clientes;
	private JTextField txtFldDni;
	private JTextField txtFldNombre;

	public DialogoNuevoCliente(
		JDialog padre, boolean modal, ArrayList<Cliente> clientes
	) {
		super(padre, modal);
		this.clientes = clientes;

		this.setBounds(0, 0, 300, 250);
		this.getRootPane().setBorder(new EmptyBorder(20, 20, 20, 20));
		this.getContentPane().setLayout(new BorderLayout(20, 20));

		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		this.getContentPane().add(mainPane, BorderLayout.CENTER);

		JLabel lblDni = new JLabel("Dni:");
		mainPane.add(lblDni);

		txtFldDni = new JTextField();
		txtFldDni.setMaximumSize(
			new Dimension(
				(int) txtFldDni.getMaximumSize().getWidth(),
				(int) txtFldDni.getPreferredSize().getHeight()
			)
		);
		mainPane.add(txtFldDni);

		mainPane.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel lblNombre = new JLabel("Nombre:");
		mainPane.add(lblNombre);

		txtFldNombre = new JTextField();
		txtFldNombre.setMaximumSize(
			new Dimension(
				(int) txtFldNombre.getMaximumSize().getWidth(),
				(int) txtFldNombre.getPreferredSize().getHeight()
			)
		);
		mainPane.add(txtFldNombre);

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

		buttonPane.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelButton);
	}

	private void aceptar() {
		this.dispose();

		if (this.txtFldDni.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
				this, "Introduce un DNI.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		if (this.txtFldNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
				this, "Introduce un nombre.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		this.clientes.add(
			new Cliente(this.txtFldDni.getText(), this.txtFldNombre.getText())
		);
	}

	private void cancelar() {
		this.dispose();
	}
}
