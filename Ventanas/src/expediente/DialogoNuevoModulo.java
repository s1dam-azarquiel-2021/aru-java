package expediente;

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
import javax.swing.SwingConstants;

public class DialogoNuevoModulo extends JDialog {
	private JTextField textFieldNombre;
	private JTextField textFieldNotaEv1;
	private JTextField textFieldNotaEv2;
	private JTextField textFieldNotaEv3;

	public DialogoNuevoModulo(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(100, 100, 440, 190);
		this.getContentPane().setLayout(new BorderLayout());

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(20, 20, 100, 30);
		contentPanel.add(lblNombre);

		JLabel lblNotas = new JLabel("Notas:");
		lblNotas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotas.setBounds(20, 100, 100, 30);
		contentPanel.add(lblNotas);

		JLabel lblEv1 = new JLabel("1aEv");
		lblEv1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEv1.setBounds(140, 60, 80, 30);
		contentPanel.add(lblEv1);

		JLabel lblEv2 = new JLabel("2aEv");
		lblEv2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEv2.setBounds(240, 60, 80, 30);
		contentPanel.add(lblEv2);

		JLabel lblEv3 = new JLabel("3aEv");
		lblEv3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEv3.setBounds(340, 60, 80, 30);
		contentPanel.add(lblEv3);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(140, 20, 280, 30);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldNotaEv1 = new JTextField();
		textFieldNotaEv1.setColumns(10);
		textFieldNotaEv1.setBounds(140, 100, 80, 30);
		contentPanel.add(textFieldNotaEv1);

		textFieldNotaEv2 = new JTextField();
		textFieldNotaEv2.setColumns(10);
		textFieldNotaEv2.setBounds(240, 100, 80, 30);
		contentPanel.add(textFieldNotaEv2);

		textFieldNotaEv3 = new JTextField();
		textFieldNotaEv3.setColumns(10);
		textFieldNotaEv3.setBounds(340, 100, 80, 30);
		contentPanel.add(textFieldNotaEv3);

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
		if (this.textFieldNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo nombre está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.textFieldNotaEv1.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo nota de 1aEv está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.textFieldNotaEv2.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo nota de 2aEv está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.textFieldNotaEv3.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo nota de 3aEv está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			try {
				((VentanaPrincipal) this.getParent()).getExpediente().addModulo(
					new Modulo(
						this.textFieldNombre.getText(),
						Integer.parseInt(this.textFieldNotaEv1.getText()),
						Integer.parseInt(this.textFieldNotaEv2.getText()),
						Integer.parseInt(this.textFieldNotaEv3.getText())
					)
				);

				this.dispose();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					this, "Una de las notas no es numero", "Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}

	private void cancelar() {
		this.dispose();
	}
}
