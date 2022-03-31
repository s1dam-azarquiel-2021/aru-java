package primerasVentanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CalcularIVA extends JFrame {
	private static final Font FONT_BIG = new Font("Iosevka", Font.BOLD, 18);
	private static final Font FONT_SMALL = new Font("Iosevka", Font.BOLD, 14);
	private JPanel contentPane;
	private JTextField txtFieldCantidad;
	private JTextField txtFieldIVA;
	private JTextField txtFieldTotal;
	private final ButtonGroup grupoIVA = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					CalcularIVA frame = new CalcularIVA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalcularIVA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 340);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFieldCantidad = generateTxtField(20, true);
		JLabel lblCantidad = generateJLabel("Cantidad:", 20);

		JRadioButton rdbtnIVA21 = generateRDBTNIva("21", 60);
		JRadioButton rdbtnIVA10 = generateRDBTNIva("10", 100);
		JRadioButton rdbtnIVA4 = generateRDBTNIva("4", 140);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(FONT_SMALL);
		btnCalcular.setBounds(100, 180, 200, 30);

		JLabel lblIVA = generateJLabel("IVA:", 220);
		txtFieldIVA = generateTxtField(220, false);

		JLabel lblTotal = generateJLabel("Total:", 260);
		txtFieldTotal = generateTxtField(260, false);

		contentPane.add(lblCantidad);
		contentPane.add(lblIVA);
		contentPane.add(lblTotal);
		contentPane.add(txtFieldTotal);
		contentPane.add(txtFieldIVA);
		contentPane.add(txtFieldCantidad);
		contentPane.add(rdbtnIVA21);
		contentPane.add(rdbtnIVA10);
		contentPane.add(rdbtnIVA4);
		contentPane.add(btnCalcular);

		rdbtnIVA4.addItemListener(calcularAlSeleccionar());
		rdbtnIVA10.addItemListener(calcularAlSeleccionar());
		rdbtnIVA21.addItemListener(calcularAlSeleccionar());

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
	}

	private JRadioButton generateRDBTNIva(String porcentaje, int y) {
		JRadioButton resultado = new JRadioButton(porcentaje + "%");
		grupoIVA.add(resultado);
		resultado.setFont(FONT_BIG);
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(100, y, 200, 30);
		resultado.setActionCommand(porcentaje);
		return resultado;
	}

	private JLabel generateJLabel(String texto, int y) {
		JLabel resultado = new JLabel(texto);
		resultado.setBounds(50, y, 140, 30);
		resultado.setFont(FONT_SMALL);
		resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		return resultado;
	}

	private JTextField generateTxtField(int y, boolean editable) {
		JTextField resultado = new JTextField();
		resultado.setBounds(210, y, 140, 30);
		resultado.setFont(FONT_SMALL);
		resultado.setHorizontalAlignment(SwingConstants.LEFT);
		resultado.setEditable(editable);
		resultado.setColumns(10);
		return resultado;
	}

	private ItemListener calcularAlSeleccionar() {
		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				calcular();
			}
		};
	}

	private void calcular() {
		if (this.txtFieldCantidad.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "Rellena los campos", "Error", JOptionPane.ERROR_MESSAGE
			);
		} else if (this.grupoIVA.getSelection() == null) {
			JOptionPane.showMessageDialog(
				this, "Elige un porcentaje de IVA", "Error",
				JOptionPane.ERROR_MESSAGE
			);
		} else {
			try {
				final double CANTIDAD = Double.parseDouble(
					this.txtFieldCantidad.getText()
				);
				final double IVA_TOTAL = CANTIDAD * Double.parseDouble(
					this.grupoIVA.getSelection().getActionCommand()
				) / 100;

				this.txtFieldIVA.setText(String.valueOf(IVA_TOTAL));
				this.txtFieldTotal.setText(
					String.valueOf(IVA_TOTAL + CANTIDAD)
				);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					this, "Valores invalidos", "Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}
}
