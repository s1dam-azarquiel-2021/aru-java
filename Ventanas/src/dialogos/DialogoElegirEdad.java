package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogoElegirEdad extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEdad;
	private JSlider slider;

	/**
	 * Create the dialog.
	 */
	public DialogoElegirEdad(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setResizable(false);
		this.setBounds(0, 0, 240, 200);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		this.lblEdad = new JLabel("0");
		this.lblEdad.setBounds(20, 20, 200, 60);
		this.lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEdad.setFont(new Font("Iosevka", Font.BOLD, 30));
		contentPanel.add(lblEdad);

		this.slider = new JSlider();
		this.slider.setBounds(20, 100, 200, 40);
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				actualizarEdad();
			}
		});
		this.slider.setValue(0);
		this.slider.setMaximum(120);
		contentPanel.add(slider);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	private void actualizarEdad() {
		this.lblEdad.setText(String.valueOf(this.slider.getValue()));
	}

	private void cancelar() {
		this.dispose();
	}

	private void confirmar() {
		((Formulario2) this.getParent()).getTextFieldEdad().setText(
			this.lblEdad.getText()
		);
		this.dispose();
	}
}
