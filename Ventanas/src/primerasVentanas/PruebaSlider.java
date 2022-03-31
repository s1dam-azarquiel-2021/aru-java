package primerasVentanas;

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

public class PruebaSlider extends JFrame {
	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					PruebaSlider frame = new PruebaSlider();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PruebaSlider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblValor = new JLabel("0");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Iosevka Extrabold", Font.BOLD, 20));
		lblValor.setBounds(144, 101, 131, 69);
		contentPane.add(lblValor);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarValor();
			}
		});
		slider.setValue(0);
		slider.setBounds(110, 231, 200, 16);
		contentPane.add(slider);
	}

	private void cambiarValor() {
		this.lblValor.setText(String.valueOf(this.slider.getValue()));
	}
}
