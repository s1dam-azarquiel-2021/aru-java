package dialogos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Colores extends JFrame {
	private JLabel lblTexto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					Colores frame = new Colores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Colores() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 160);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);

		lblTexto = new JLabel("Texto de Prueba");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Iosevka", Font.BOLD, 20));
		lblTexto.setBounds(20, 20, 200, 60);
		contentPane.add(lblTexto);

		JButton btnCambiarColor = new JButton("Cambiar color");
		btnCambiarColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogoCambiarColor();
			}
		});
		btnCambiarColor.setBounds(20, 80, 200, 30);
		contentPane.add(btnCambiarColor);
	}

	private void dialogoCambiarColor() {
		DialogoColores dialogoColores = new DialogoColores(this, true);
		dialogoColores.setLocationRelativeTo(this);
		dialogoColores.setVisible(true);
	}

	public JLabel getLblTexto() {
		return this.lblTexto;
	}
}
