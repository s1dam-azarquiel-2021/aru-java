package dialogos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DialogoColores extends JDialog {
	private final ButtonGroup grupoColores = new ButtonGroup();
	private JRadioButton rdbtnNegro;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnVerde;
	private JRadioButton rdbtnAmarillo;

	public DialogoColores(JFrame padre, boolean modal) {
		super(padre, modal);
		this.setBounds(0, 0, 240, 260);
		this.getContentPane().setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		rdbtnNegro = new JRadioButton("Negro");
		rdbtnNegro.setBounds(20, 20, 200, 30);
		rdbtnNegro.setActionCommand("negro");
		contentPanel.add(rdbtnNegro);
		this.grupoColores.add(rdbtnNegro);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(20, 60, 200, 30);
		rdbtnRojo.setActionCommand("rojo");
		contentPanel.add(rdbtnRojo);
		this.grupoColores.add(rdbtnRojo);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(20, 100, 200, 30);
		rdbtnAzul.setActionCommand("azul");
		contentPanel.add(rdbtnAzul);
		this.grupoColores.add(rdbtnAzul);

		rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBounds(20, 140, 200, 30);
		rdbtnVerde.setActionCommand("verde");
		contentPanel.add(rdbtnVerde);
		this.grupoColores.add(rdbtnVerde);

		rdbtnAmarillo = new JRadioButton("Amarillo");
		rdbtnAmarillo.setBounds(20, 180, 200, 30);
		rdbtnAmarillo.setActionCommand("amarillo");
		contentPanel.add(rdbtnAmarillo);
		this.grupoColores.add(rdbtnAmarillo);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		activarBotonAdecuado();
	}

	private void activarBotonAdecuado() {
		final Color foreground =
			((Colores) this.getParent()).getLblTexto().getForeground();

		if (foreground.equals(Color.RED)) {
			this.rdbtnRojo.setSelected(true);
		} else if (foreground.equals(Color.BLUE)) {
			this.rdbtnAzul.setSelected(true);
		} else if (foreground.equals(Color.GREEN)) {
			this.rdbtnVerde.setSelected(true);
		} else if (foreground.equals(Color.YELLOW)) {
			this.rdbtnAmarillo.setSelected(true);
		} else {
			this.rdbtnNegro.setSelected(true);
		}
	}

	private void cancelar() {
		this.dispose();
	}

	private void confirmar() {
		Color color;
		switch (this.grupoColores.getSelection().getActionCommand()) {
		case "rojo":
			color = Color.RED;
			break;
		case "azul":
			color = Color.BLUE;
			break;
		case "verde":
			color = Color.GREEN;
			break;
		case "amarillo":
			color = Color.YELLOW;
			break;
		case "negro":
		default:
			color = Color.BLACK;
		}

		((Colores) this.getParent()).getLblTexto().setForeground(color);
		this.dispose();
	}
}
