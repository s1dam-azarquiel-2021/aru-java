package primerasVentanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class CalculadoraAntigua extends JFrame {

	private static enum Operation {
		ADDITION("+"), SUBSTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

		private String operation;

		Operation(String operation) {
			this.operation = operation;
		}

		public String toString() {
			return this.operation;
		}
	}

	private static final Font FONT_SMALL = new Font("Iosevka", Font.BOLD, 14);
	private JPanel contentPane;
	private JTextField visualizadorNumaro;
	private double numero1;
	private Operation operacionARealizar = null;

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
					CalculadoraAntigua frame = new CalculadoraAntigua();
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
	public CalculadoraAntigua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		visualizadorNumaro = new JTextField();
		visualizadorNumaro.setBounds(20, 20, 400, 30);
		visualizadorNumaro.setFont(FONT_SMALL);
		visualizadorNumaro.setHorizontalAlignment(SwingConstants.RIGHT);
		visualizadorNumaro.setEditable(false);
		visualizadorNumaro.setColumns(10);

		JButton btn0 = generateNumberBtn("0", 20, 360);
		JButton btn1 = generateNumberBtn("1", 20, 260);
		JButton btn2 = generateNumberBtn("2", 120, 260);
		JButton btn3 = generateNumberBtn("3", 220, 260);
		JButton btn4 = generateNumberBtn("4", 20, 160);
		JButton btn5 = generateNumberBtn("5", 120, 160);
		JButton btn6 = generateNumberBtn("6", 220, 160);
		JButton btn7 = generateNumberBtn("7", 20, 60);
		JButton btn8 = generateNumberBtn("8", 120, 60);
		JButton btn9 = generateNumberBtn("9", 220, 60);

		JButton btnAddition = generateOperationBtn(Operation.ADDITION, 320, 60);
		JButton btnSubstraction = generateOperationBtn(
			Operation.SUBSTRACTION, 320, 160
		);
		JButton btnMultiplication = generateOperationBtn(
			Operation.MULTIPLICATION, 320, 260
		);
		JButton btnDivision = generateOperationBtn(
			Operation.DIVISION, 320, 360
		);

		JButton btnCalcular = generateBtn("=", 120, 360, 200);

		contentPane.add(visualizadorNumaro);
		contentPane.add(btn0);
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(btn4);
		contentPane.add(btn5);
		contentPane.add(btn6);
		contentPane.add(btn7);
		contentPane.add(btn8);
		contentPane.add(btn9);
		contentPane.add(btnAddition);
		contentPane.add(btnSubstraction);
		contentPane.add(btnMultiplication);
		contentPane.add(btnDivision);
		contentPane.add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
	}

	private JButton generateBtn(String text, int x, int y, int w) {
		JButton resultado = new JButton(text);
		resultado.setBounds(x, y, w, 100);
		return resultado;
	}

	private JButton generateSquareBtn(String text, int x, int y) {
		return generateBtn(text, x, y, 100);
	}

	private JButton generateNumberBtn(String number, int x, int y) {
		JButton resultado = generateSquareBtn(number, x, y);
		resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizadorNumaro.setText(aniadirNumero(number));
			}
		});
		return resultado;
	}

	private JButton generateOperationBtn(Operation operation, int x, int y) {
		JButton resultado = generateSquareBtn(operation.toString(), x, y);
		resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarOperacion(operation);
			}
		});
		return resultado;
	}

	private String aniadirNumero(String number) {
		return visualizadorNumaro.getText() + number;
	}

	private void realizarOperacion(Operation operation) {
		this.numero1 = Integer.parseInt(this.visualizadorNumaro.getText());
		this.operacionARealizar = operation;
		this.visualizadorNumaro.setText("");
	}

	private void calcular() {
		if (this.visualizadorNumaro.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "Introduce un numero", "Error", JOptionPane.ERROR_MESSAGE
			);
		} else {
			int numero2 = Integer.parseInt(this.visualizadorNumaro.getText());
			double resultado = 0;

			try {
				if (this.operacionARealizar == null) {
					JOptionPane.showMessageDialog(
						this, "No seleccionaste ninguna operacion", "Error",
						JOptionPane.ERROR_MESSAGE
					);
				} else {
					switch (this.operacionARealizar) {
					case ADDITION:
						resultado = this.numero1 + numero2;
						break;
					case SUBSTRACTION:
						resultado = this.numero1 - numero2;
						break;
					case MULTIPLICATION:
						resultado = this.numero1 * numero2;
						break;
					case DIVISION:
						resultado = this.numero1 / numero2;
						break;
					}

					if (resultado % 1 == 0.0) {
						this.visualizadorNumaro.setText(
							String.valueOf((int) (resultado))
						);
					} else {
						this.visualizadorNumaro.setText(
							String.valueOf(resultado)
						);
					}

					this.operacionARealizar = null;
					this.numero1 = resultado;
				}
			} catch (ArithmeticException e1) {
				JOptionPane.showMessageDialog(
					this, "Division por cero", "Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}
}
