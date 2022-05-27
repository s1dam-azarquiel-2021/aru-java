package agenda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoNuevoContacto extends JDialog {
	private JTextField txtFieldNombre;
	private JTextField txtFieldNumero;

	public DialogoNuevoContacto(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(100, 100, 310, 150);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 20, 100, 30);
		contentPanel.add(lblNombre);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(20, 60, 100, 30);
		contentPanel.add(lblNumero);

		txtFieldNombre = new JTextField();
		txtFieldNombre.setBounds(140, 20, 150, 30);
		contentPanel.add(txtFieldNombre);
		txtFieldNombre.setColumns(10);

		txtFieldNumero = new JTextField();
		txtFieldNumero.setColumns(10);
		txtFieldNumero.setBounds(140, 60, 150, 30);
		contentPanel.add(txtFieldNumero);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	private void confirmar() {
		if (this.txtFieldNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo nombre está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.txtFieldNumero.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo numero está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			try {
				((VentanaPrincipal) this.getParent()).getAgenda().add(
					new Contacto(
						this.txtFieldNombre.getText(),
						Long.parseLong(this.txtFieldNumero.getText())
					)
				);

				this.dispose();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					this, "El campo numero no es numero", "Warning",
					JOptionPane.WARNING_MESSAGE
				);
			}
		}
	}

	private void cancelar() {
		this.dispose();
	}
}
