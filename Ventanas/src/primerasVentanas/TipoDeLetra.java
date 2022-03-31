package primerasVentanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TipoDeLetra extends JFrame {
	private static final Font MAIN_FONT = new Font("Iosevka", Font.PLAIN, 40);
	private static final Font CHKBX_FONT = new Font("Iosevka", Font.PLAIN, 15);
	private JPanel contentPane;
	private JCheckBox chckbxNegrita;
	private JCheckBox chckbxCursiva;
	private JLabel lblTexto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					TipoDeLetra frame = new TipoDeLetra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TipoDeLetra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 210);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTexto = new JLabel("Texto de Prueba");
		lblTexto.setFont(MAIN_FONT);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(50, 20, 300, 60);

		chckbxNegrita = generateChckbx("Negrita", 90);
		chckbxCursiva = generateChckbx("Cursiva", 130);

		contentPane.add(lblTexto);
		contentPane.add(chckbxNegrita);
		contentPane.add(chckbxCursiva);

		chckbxNegrita.addActionListener(cambiarFuenteAlSeleccionar());
		chckbxCursiva.addActionListener(cambiarFuenteAlSeleccionar());
	}

	private JCheckBox generateChckbx(String text, int y) {
		JCheckBox resultado = new JCheckBox(text);
		resultado.setFont(CHKBX_FONT);
		resultado.setBounds(50, y, 300, 30);
		return resultado;
	}

	private ActionListener cambiarFuenteAlSeleccionar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font fuente = MAIN_FONT;

				if (chckbxCursiva.isSelected() && chckbxNegrita.isSelected()) {
					fuente = MAIN_FONT.deriveFont(Font.ITALIC | Font.BOLD);
				} else if (chckbxCursiva.isSelected()) {
					fuente = MAIN_FONT.deriveFont(Font.ITALIC);
				} else if (chckbxNegrita.isSelected()) {
					fuente = MAIN_FONT.deriveFont(Font.BOLD);
				}

				lblTexto.setFont(fuente);
			}
		};
	}
}
