package primerasVentanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class IMC extends JFrame {
	private static final Font FONT_BIG = new Font("Iosevka", Font.BOLD, 18);
	private static final Font FONT_SMALL = new Font("Iosevka", Font.BOLD, 14);
	private JPanel contentPane;
	private JTextField txtFieldAltura;
	private JTextField txtFieldPeso;
	private JLabel lblIMCValor;
	private JLabel lblIMCTexto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					IMC frame = new IMC();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IMC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 210);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAltura = generateLblCampos("Altura:", 20);
		JLabel lblPeso = generateLblCampos("Peso:", 60);

		txtFieldAltura = generateTxtFieldCampos(20);
		txtFieldPeso = generateTxtFieldCampos(60);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(FONT_SMALL);
		btnCalcular.setBounds(100, 100, 200, 30);
		contentPane.add(btnCalcular);

		JLabel lblIMC = generateLblResultados(
			"IMC:", 30, 100, SwingConstants.RIGHT
		);
		lblIMCValor = generateLblResultados(
			"", 150, 100, SwingConstants.CENTER
		);
		lblIMCTexto = generateLblResultados("", 270, 100, SwingConstants.LEFT);

		contentPane.add(lblAltura);
		contentPane.add(lblPeso);
		contentPane.add(txtFieldAltura);
		contentPane.add(txtFieldPeso);
		contentPane.add(lblIMC);
		contentPane.add(lblIMCValor);
		contentPane.add(lblIMCTexto);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
	}

	private JLabel generateLbl(
		String text, int x, int y, int w, int alignment, Font font
	) {
		JLabel resultado = new JLabel(text);
		resultado.setFont(font);
		resultado.setHorizontalAlignment(alignment);
		resultado.setBounds(x, y, w, 30);
		return resultado;
	}

	private JLabel generateLblCampos(String text, int y) {
		return generateLbl(text, 50, y, 90, SwingConstants.RIGHT, FONT_SMALL);
	}

	private JLabel generateLblResultados(
		String text, int x, int w, int alignment
	) {
		return generateLbl(text, x, 140, w, alignment, FONT_BIG);
	}

	private JTextField generateTxtFieldCampos(int y) {
		JTextField resultado = new JTextField();
		resultado.setHorizontalAlignment(SwingConstants.LEFT);
		resultado.setBounds(160, y, 140, 30);
		resultado.setColumns(10);
		return resultado;
	}

	private void calcular() {
		if (
			this.txtFieldPeso.getText().isBlank()
			|| this.txtFieldAltura.getText().isEmpty()
		) {
			JOptionPane.showMessageDialog(
				this, "Rellena los campos", "Error", JOptionPane.ERROR_MESSAGE
			);
		} else {
			try {
				final double imc = Double.parseDouble(
					this.txtFieldPeso.getText()
				) / Math.pow(
					Double.parseDouble(this.txtFieldAltura.getText()) / 100, 2
				);

				DecimalFormat formato = new DecimalFormat("#0.00");

				this.lblIMCValor.setText(formato.format(imc));

				if (imc < 18) {
					this.lblIMCTexto.setText("Delgadez");
					this.lblIMCTexto.setForeground(Color.ORANGE);
				} else if (imc <= 25) {
					this.lblIMCTexto.setText("Normal");
					this.lblIMCTexto.setForeground(Color.GREEN);
				} else {
					this.lblIMCTexto.setText("Sobrepeso");
					this.lblIMCTexto.setForeground(Color.RED);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					this, "Valores invalidos", "Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}
}
