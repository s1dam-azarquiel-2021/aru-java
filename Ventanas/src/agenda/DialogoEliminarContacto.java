package agenda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DialogoEliminarContacto extends JDialog {
	private JTextField txtFieldNumero;
	private final ButtonGroup grupoBorrarPor = new ButtonGroup();

	public DialogoEliminarContacto(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(100, 100, 310, 180);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblBorrarPor = new JLabel("Borrar por:");
		lblBorrarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarPor.setBounds(20, 20, 270, 30);
		contentPanel.add(lblBorrarPor);

		txtFieldNumero = new JTextField();
		txtFieldNumero.setColumns(10);
		txtFieldNumero.setBounds(20, 100, 270, 30);
		contentPanel.add(txtFieldNumero);

		JRadioButton rdbtnNombre = new JRadioButton("Nombre");
		grupoBorrarPor.add(rdbtnNombre);
		rdbtnNombre.setSelected(true);
		rdbtnNombre.setActionCommand("nombre");
		rdbtnNombre.setBounds(20, 60, 125, 30);
		contentPanel.add(rdbtnNombre);

		JRadioButton rdbtnNumero = new JRadioButton("Numero");
		grupoBorrarPor.add(rdbtnNumero);
		rdbtnNumero.setActionCommand("numero");
		rdbtnNumero.setBounds(165, 60, 125, 30);
		contentPanel.add(rdbtnNumero);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	private void confirmar() {
		if (this.txtFieldNumero.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			switch (this.grupoBorrarPor.getSelection().getActionCommand()) {
			case "nombre":
				if (
					((VentanaPrincipal) this.getParent()).getAgenda().remove(
						this.txtFieldNumero.getText()
					)
				) {
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(
						this, "No se encontro ningun contacto con ese nombre",
						"Error", JOptionPane.ERROR_MESSAGE
					);
				}
				break;
			case "numero":
				try {
					if (
						((VentanaPrincipal) this.getParent()).getAgenda().remove(
							Long.parseLong(this.txtFieldNumero.getText())
						)
					) {
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(
							this,
							"No se encontro ningun contacto con ese numero",
							"Error", JOptionPane.ERROR_MESSAGE
						);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(
						this, "No es un numero valido", "Warning",
						JOptionPane.WARNING_MESSAGE
					);
				}
				break;
			}
		}
	}

	private void cancelar() {
		this.dispose();
	}
}
