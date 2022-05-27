package clinica;

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

public class DialogoNuevoPaciente extends JDialog {
	private JTextField textFieldNombre;
	private JTextField textFieldCompania;

	public DialogoNuevoPaciente(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(0, 0, 260, 150);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 20, 100, 30);
		contentPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(140, 20, 100, 30);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblCompania = new JLabel("Compania:");
		lblCompania.setBounds(20, 60, 100, 30);
		contentPanel.add(lblCompania);

		textFieldCompania = new JTextField();
		textFieldCompania.setColumns(10);
		textFieldCompania.setBounds(140, 60, 100, 30);
		contentPanel.add(textFieldCompania);

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
		} else if (this.textFieldCompania.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "El campo compania está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			((VentanaPrincipal) this.getParent()).getListaDeEspera().add(
				new Paciente(
					this.textFieldNombre.getText(),
					this.textFieldCompania.getText()
				)
			);

			this.dispose();
		}
	}

	private void cancelar() {
		this.dispose();
	}
}
