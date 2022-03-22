package primerasVentanas;

import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

public class VentanaColor extends JFrame {

	private JPanel contentPane;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaColor frame = new VentanaColor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaColor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTexto = new JLabel("Texto de Prueba");
		lblTexto.setFont(new Font("Iosevka Extrabold", Font.BOLD, 30));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(84, 81, 278, 72);
		contentPane.add(lblTexto);

		JButton btnRojo = new JButton("rojo");
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.RED);
			}
		});

		btnRojo.setForeground(Color.RED);
		btnRojo.setFont(new Font("Iosevka Medium", Font.PLAIN, 15));
		btnRojo.setBounds(12, 238, 87, 25);
		contentPane.add(btnRojo);

		JButton btnVerde = new JButton("verde");
		btnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.GREEN);
			}
		});
		btnVerde.setForeground(Color.GREEN);
		btnVerde.setFont(new Font("Iosevka Medium", Font.PLAIN, 15));
		btnVerde.setBounds(223, 238, 87, 25);
		contentPane.add(btnVerde);

		JButton btnAzul = new JButton("azul");
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.BLUE);
			}
		});
		btnAzul.setForeground(Color.BLUE);
		btnAzul.setFont(new Font("Iosevka Medium", Font.PLAIN, 15));
		btnAzul.setBounds(111, 238, 87, 25);
		contentPane.add(btnAzul);

		JButton btnAmarillo = new JButton("amarillo");
		btnAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.YELLOW);
			}
		});
		btnAmarillo.setForeground(Color.YELLOW);
		btnAmarillo.setFont(new Font("Iosevka Medium", Font.PLAIN, 15));
		btnAmarillo.setBounds(322, 238, 101, 25);
		contentPane.add(btnAmarillo);
	}

	private void cambiarColor(Color c) {
		lblTexto.setForeground(c);
	}
}
