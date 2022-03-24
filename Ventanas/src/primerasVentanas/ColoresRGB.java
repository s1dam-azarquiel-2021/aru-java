package primerasVentanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColoresRGB extends JFrame {

	private static final Font MAIN_FONT = new Font(
		"Iosevka Extrabold", Font.BOLD, 20
	);
	private JPanel contentPane;
	private JPanel colorVisualizer;
	private JSlider sliderR;
	private JSlider sliderG;
	private JSlider sliderB;

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
					ColoresRGB frame = new ColoresRGB();
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
	public ColoresRGB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		colorVisualizer = new JPanel();
		JLabel lblR = generateColorLbl("R", Color.RED, 125);
		JLabel lblG = generateColorLbl("G", Color.GREEN, 165);
		JLabel lblB = generateColorLbl("B", Color.BLUE, 205);
		JLabel lblRValor = generateColorValueLbl(Color.RED, 125);
		JLabel lblGValor = generateColorValueLbl(Color.GREEN, 165);
		JLabel lblBValor = generateColorValueLbl(Color.BLUE, 205);
		sliderR = generateSlider(125);
		sliderG = generateSlider(165);
		sliderB = generateSlider(205);

		contentPane.add(colorVisualizer);
		contentPane.add(sliderR);
		contentPane.add(sliderG);
		contentPane.add(sliderB);
		contentPane.add(lblR);
		contentPane.add(lblG);
		contentPane.add(lblB);
		contentPane.add(lblRValor);
		contentPane.add(lblGValor);
		contentPane.add(lblBValor);

		colorVisualizer.setBounds(200, 15, 100, 100);
		colorVisualizer.setBackground(Color.BLACK);

		sliderR.addChangeListener(actualizar(lblRValor, sliderR));
		sliderG.addChangeListener(actualizar(lblGValor, sliderG));
		sliderB.addChangeListener(actualizar(lblBValor, sliderB));
	}

	private JSlider generateSlider(int y) {
		JSlider resultado = new JSlider(0, 255, 0);
		resultado.setBounds(80, y, 345, 40);
		return resultado;
	}

	private JLabel generateLbl(
		String text, int alignment, Color color, int x, int y
	) {
		JLabel resultado = new JLabel(text);
		resultado.setBounds(x, y, 60, 60);
		resultado.setHorizontalAlignment(alignment);
		resultado.setFont(MAIN_FONT);
		resultado.setForeground(color);
		return resultado;
	}

	private JLabel generateColorLbl(String text, Color color, int y) {
		return generateLbl(text, SwingConstants.RIGHT, color, 15, y);
	}

	private JLabel generateColorValueLbl(Color color, int y) {
		return generateLbl("0", SwingConstants.LEFT, color, 425, y);
	}

	private void cambiarColor() {
		this.colorVisualizer.setBackground(
			new java.awt.Color(
				this.sliderR.getValue(), this.sliderG.getValue(),
				this.sliderB.getValue()
			)
		);
	}

	private void cambiarValor(JLabel jLabel, int valor) {
		jLabel.setText(String.valueOf(valor));
	}

	private ChangeListener actualizar(JLabel jLabel, JSlider jSlider) {
		return new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarColor();
				cambiarValor(jLabel, jSlider.getValue());
			}
		};

	}
}
