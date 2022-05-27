package primerasVentanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class CalcularIVAConListaDesplegable extends JFrame {
	private static final Font FONT_SMALL = new Font("Iosevka", Font.BOLD, 14);
	private JPanel contentPane;
	private JTextField txtFieldCantidad;
	private JTextField txtFieldIVA;
	private JTextField txtFieldTotal;
	private JComboBox<Integer> comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					CalcularIVAConListaDesplegable frame =
						new CalcularIVAConListaDesplegable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalcularIVAConListaDesplegable() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFieldCantidad = generateTxtField(20, true);
		JLabel lblCantidad = generateJLabel("Cantidad:", 20);

		comboBox = new JComboBox<>();
		comboBox.setBounds(100, 60, 200, 30);
		comboBox.setModel(new DefaultComboBoxModel<>(new Integer[] {
			21, 10, 4
		}));

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(FONT_SMALL);
		btnCalcular.setBounds(100, 100, 200, 30);

		JLabel lblIVA = generateJLabel("IVA:", 140);
		txtFieldIVA = generateTxtField(140, false);

		JLabel lblTotal = generateJLabel("Total:", 180);
		txtFieldTotal = generateTxtField(180, false);

		contentPane.add(lblCantidad);
		contentPane.add(lblIVA);
		contentPane.add(lblTotal);
		contentPane.add(txtFieldTotal);
		contentPane.add(txtFieldIVA);
		contentPane.add(txtFieldCantidad);
		contentPane.add(comboBox);
		contentPane.add(btnCalcular);

		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				calcular();
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
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

	private void calcular() {
		if (this.txtFieldCantidad.getText().isBlank()) {
			JOptionPane.showMessageDialog(
				this, "Rellena los campos", "Error", JOptionPane.ERROR_MESSAGE
			);
		} else {
			try {
				final double CANTIDAD = Double.parseDouble(
					this.txtFieldCantidad.getText()
				);
				final double IVA_TOTAL = CANTIDAD
				* (Integer) (comboBox.getSelectedItem()) / 100;

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
