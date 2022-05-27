package ejercicio2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogoNuevaMascota extends JDialog {
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;

	public DialogoNuevaMascota(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(100, 100, 700, 400);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPanel.setLayout(new GridLayout(6, 2, 20, 20));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel label1 = new JLabel("Numero:");
		contentPanel.add(label1);

		txt1 = new JTextField();
		contentPanel.add(txt1);

		JLabel label2 = new JLabel("Nombre:");
		contentPanel.add(label2);

		txt2 = new JTextField();
		contentPanel.add(txt2);

		JLabel label3 = new JLabel("Tipo de animal:");
		contentPanel.add(label3);

		txt3 = new JTextField();
		contentPanel.add(txt3);

		JLabel label4 = new JLabel("Raza:");
		contentPanel.add(label4);

		txt4 = new JTextField();
		contentPanel.add(txt4);

		JLabel label5 = new JLabel("Fecha de nacimiento");
		contentPanel.add(label5);

		txt5 = new JTextField();
		contentPanel.add(txt5);

		JLabel label6 = new JLabel("Cliente:");
		contentPanel.add(label6);

		txt6 = new JTextField();
		contentPanel.add(txt6);

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
		ArrayList<JTextField> textFields = new ArrayList<>();
		textFields.add(txt1);
		textFields.add(txt2);
		textFields.add(txt3);
		textFields.add(txt4);
		textFields.add(txt5);
		textFields.add(txt6);

		for (JTextField textField : textFields) {
			if (textField.getText().isBlank()) {
				JOptionPane.showMessageDialog(
					this, "Hay campos vacios", "Warning",
					JOptionPane.WARNING_MESSAGE
				);
				return;
			}
		}

		StringTokenizer partesFecha = new StringTokenizer(txt5.getText(), "-/");
		int dia;
		int mes;
		int anio;

		try {
			dia = Integer.valueOf(partesFecha.nextToken());
			mes = Integer.valueOf(partesFecha.nextToken());
			anio = Integer.valueOf(partesFecha.nextToken());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(
				this, "Fecha mal formateada", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		((VentanaPrincipal) this.getParent()).getDaoMascota().add(
			new Mascota(
				this.txt1.getText(),
				this.txt2.getText(),
				this.txt3.getText(),
				this.txt4.getText(),
				new Date(dia, mes, anio),
				this.txt6.getText()
			)
		);

		this.dispose();
	}

	private void cancelar() {
		this.dispose();
	}
}
