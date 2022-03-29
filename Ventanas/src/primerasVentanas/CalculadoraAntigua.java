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

	private static final String DEFAULT_NUMBER = "0";

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
	private JTextField visualizadorNumero;
	private double numero1;
	private Operation operacionARealizar = null;
	private boolean operacionRealizada = false;
	private boolean repetirUltima = false;

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
		setBounds(100, 100, 540, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		visualizadorNumero = new JTextField(DEFAULT_NUMBER);
		visualizadorNumero.setBounds(20, 20, 500, 30);
		visualizadorNumero.setFont(FONT_SMALL);
		visualizadorNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		visualizadorNumero.setEditable(false);
		visualizadorNumero.setColumns(10);

		JButton btnDot = this.generateNumberBtn(".", 120, 360);
		JButton btn0 = this.generateNumberBtn(DEFAULT_NUMBER, 20, 360);
		JButton btn1 = this.generateNumberBtn("1", 20, 260);
		JButton btn2 = this.generateNumberBtn("2", 120, 260);
		JButton btn3 = this.generateNumberBtn("3", 220, 260);
		JButton btn4 = this.generateNumberBtn("4", 20, 160);
		JButton btn5 = this.generateNumberBtn("5", 120, 160);
		JButton btn6 = this.generateNumberBtn("6", 220, 160);
		JButton btn7 = this.generateNumberBtn("7", 20, 60);
		JButton btn8 = this.generateNumberBtn("8", 120, 60);
		JButton btn9 = this.generateNumberBtn("9", 220, 60);

		JButton btnAddition = this.generateOperationBtn(
			Operation.ADDITION, 320, 60
		);
		JButton btnSubstraction = this.generateOperationBtn(
			Operation.SUBSTRACTION, 320, 160
		);
		JButton btnMultiplication = this.generateOperationBtn(
			Operation.MULTIPLICATION, 320, 260
		);
		JButton btnDivision = this.generateOperationBtn(
			Operation.DIVISION, 320, 360
		);

		JButton btnCE = this.generateSquareBtn("CE", 420, 60);
		JButton btnPosNeg = this.generateSquareBtn("+/-", 220, 360);

		JButton btnCalcular = this.generateBtn("=", 420, 160, 100, 300);

		contentPane.add(visualizadorNumero);
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
		contentPane.add(btnDot);
		contentPane.add(btnAddition);
		contentPane.add(btnSubstraction);
		contentPane.add(btnMultiplication);
		contentPane.add(btnDivision);
		contentPane.add(btnCE);
		contentPane.add(btnPosNeg);
		contentPane.add(btnCalcular);

		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});

		btnPosNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSigno();
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
	}

	private JButton generateBtn(String text, int x, int y, int w, int h) {
		JButton resultado = new JButton(text);
		resultado.setBounds(x, y, w, h);
		return resultado;
	}

	private JButton generateSquareBtn(String text, int x, int y) {
		return this.generateBtn(text, x, y, 100, 100);
	}

	private JButton generateNumberBtn(String number, int x, int y) {
		JButton resultado = this.generateSquareBtn(number, x, y);
		resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirNumero(number);
			}
		});
		return resultado;
	}

	private JButton generateOperationBtn(Operation operation, int x, int y) {
		JButton resultado = this.generateSquareBtn(operation.toString(), x, y);
		resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarOperacion(operation);
			}
		});
		return resultado;
	}

	private void aniadirNumero(String number) {
		if (operacionRealizada) {
			this.visualizadorNumero.setText(DEFAULT_NUMBER);
			this.operacionRealizada = false;
		}

		if (
			this.visualizadorNumero.getText().equals(DEFAULT_NUMBER)
				&& !number.equals(".")
				|| this.visualizadorNumero.getText().equals(
					"-" + DEFAULT_NUMBER
				)
		) {
			if (this.visualizadorNumero.getText().startsWith("-")) {
				this.visualizadorNumero.setText("-" + number);
			} else {
				this.visualizadorNumero.setText(number);
			}
		} else if (
			!(number.equals(".")
				&& this.visualizadorNumero.getText().contains("."))
		) {
			this.visualizadorNumero.setText(
				this.visualizadorNumero.getText() + number
			);
		}
	}

	private void realizarOperacion(Operation operation) {
		this.numero1 = Double.parseDouble(this.visualizadorNumero.getText());
		this.operacionARealizar = operation;
		this.repetirUltima = false;
		this.operacionRealizada = true;
	}

	private void reiniciar() {
		this.visualizadorNumero.setText(DEFAULT_NUMBER);
	}

	private void cambiarSigno() {
		if (!this.operacionRealizada) {
			if (this.visualizadorNumero.getText().startsWith("-")) {
				this.visualizadorNumero.setText(
					this.visualizadorNumero.getText().substring(1)
				);
			} else {
				this.visualizadorNumero.setText(
					"-" + this.visualizadorNumero.getText()
				);
			}
		}
	}

	private void calcular() {
		if (this.operacionARealizar == null) {
			JOptionPane.showMessageDialog(
				this, "No seleccionaste ninguna operacion", "Error",
				JOptionPane.ERROR_MESSAGE
			);
		} else {
			try {
				double numero2 = Double.parseDouble(
					this.visualizadorNumero.getText()
				);
				double resultado = this.calcularResultado(numero2);

				if (resultado % 1 == 0.0) {
					this.visualizadorNumero.setText(
						String.valueOf((int) (resultado))
					);
				} else {
					this.visualizadorNumero.setText(String.valueOf(resultado));
				}

				if (!this.repetirUltima) {
					this.numero1 = numero2;
					this.repetirUltima = true;
				}
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(
					this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}

	private double calcularResultado(double numero2)
		throws ArithmeticException {
		double resultado = 0;

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

		if (
			Double.isInfinite(resultado)
				|| Double.isNaN(resultado)
		) {
			if (numero2 == 0) {
				throw new ArithmeticException("Division por 0");
			} else {
				throw new ArithmeticException("Sale infinito");
			}
		} else {
			return resultado;
		}
	}
}
