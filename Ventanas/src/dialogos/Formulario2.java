package dialogos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Formulario2 extends JFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					Formulario2 frame = new Formulario2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Formulario2() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 230, 180);

		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 20, 80, 30);
		contentPane.add(lblNombre);

		this.textFieldNombre = new JTextField();
		this.textFieldNombre.setBounds(100, 20, 100, 30);
		contentPane.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(20, 60, 80, 30);
		contentPane.add(lblEdad);

		this.textFieldEdad = new JTextField();
		this.textFieldEdad.setColumns(10);
		this.textFieldEdad.setBounds(100, 60, 40, 30);
		contentPane.add(this.textFieldEdad);

		JButton btnComprobar = new JButton("Comprobar datos");
		btnComprobar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		btnComprobar.setBounds(20, 100, 180, 30);
		contentPane.add(btnComprobar);

		JButton btnDialogoEdad = new JButton("...");
		btnDialogoEdad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogoEdad();
			}
		});
		btnDialogoEdad.setBounds(160, 60, 40, 30);
		contentPane.add(btnDialogoEdad);
	}

	private void comprobar() {
		if (this.textFieldNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
				this, "El campo nombre está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.textFieldEdad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
				this, "El campo edad está vacío", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
		} else {
			try {
				int edad = Integer.parseInt(this.textFieldEdad.getText());

				if (edad < 0 || edad > 120) {
					JOptionPane.showMessageDialog(
						this, "Revise la edad", "Error",
						JOptionPane.ERROR_MESSAGE
					);
				} else {
					JOptionPane.showMessageDialog(
						this, "Todo correcto", "Correcto",
						JOptionPane.INFORMATION_MESSAGE
					);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					this, "Esa edad no es numero", "Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}

	private void dialogoEdad() {
		DialogoElegirEdad miDialogo = new DialogoElegirEdad(this, true);
		miDialogo.setLocationRelativeTo(this);
		miDialogo.setVisible(true);
	}

	public JTextField getTextFieldEdad() {
		return textFieldEdad;
	}
}
