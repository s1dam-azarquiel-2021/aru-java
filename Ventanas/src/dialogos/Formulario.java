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

public class Formulario extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 180);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 20, 80, 30);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(100, 20, 100, 30);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(20, 60, 80, 30);
		contentPane.add(lblEdad);

		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(100, 60, 40, 30);
		contentPane.add(textFieldEdad);

		JButton btnComprobar = new JButton("Comprobar datos");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		btnComprobar.setBounds(20, 100, 180, 30);
		contentPane.add(btnComprobar);

		JButton btnDialogoEdad = new JButton("...");
		btnDialogoEdad.addActionListener(new ActionListener() {
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
				this, "El campo nombre está vacío", "Error",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (this.textFieldEdad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(
				this, "El campo edad está vacío", "Error",
				JOptionPane.WARNING_MESSAGE
			);
		} else if (
			Integer.parseInt(this.textFieldEdad.getText()) < 0
			|| Integer.parseInt(this.textFieldEdad.getText()) > 120
		) {
			JOptionPane.showMessageDialog(
				this, "Revise la edad", "Error", JOptionPane.WARNING_MESSAGE
			);
		} else {
			JOptionPane.showMessageDialog(
				this, "Todo correcto", "Correcto",
				JOptionPane.INFORMATION_MESSAGE
			);
		}
	}

	private void dialogoEdad() {
		this.textFieldEdad.setText(
			JOptionPane.showInputDialog(
				this, "Teclea tu edad", "Edad", JOptionPane.INFORMATION_MESSAGE
			)
		);
	}
}
