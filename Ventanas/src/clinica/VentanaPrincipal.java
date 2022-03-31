package clinica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private ListaDeEspera listaDeEspera;
	private JLabel lblEsperando;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 330, 130);

		this.listaDeEspera = new ListaDeEspera();

		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoPaciente();
			}
		});
		btnNuevo.setBounds(20, 20, 130, 30);
		contentPane.add(btnNuevo);

		JButton btnAtender = new JButton("Atender");
		btnAtender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atenderPaciente();
			}
		});
		btnAtender.setBounds(170, 20, 130, 30);
		contentPane.add(btnAtender);

		JLabel lblTxtEsperando = new JLabel("Pacientes esperando:");
		lblTxtEsperando.setBounds(20, 60, 200, 30);
		contentPane.add(lblTxtEsperando);

		lblEsperando = new JLabel("0");
		lblEsperando.setBounds(240, 60, 60, 30);
		contentPane.add(lblEsperando);
	}

	private void nuevoPaciente() {
		DialogoNuevoPaciente dialogoNuevoPaciente = new DialogoNuevoPaciente(
			this, true
		);
		dialogoNuevoPaciente.setLocationRelativeTo(this);
		dialogoNuevoPaciente.setVisible(true);

		actualizarPacientesEnEspera();
	}

	private void atenderPaciente() {
		Paciente pacienteAtendido = this.listaDeEspera.atender();

		if (pacienteAtendido == null) {
			JOptionPane.showMessageDialog(
				this, "No quedan pacientes para atender", "Error",
				JOptionPane.ERROR_MESSAGE
			);
		} else {
			JOptionPane.showMessageDialog(
				this, "Turno para: " + pacienteAtendido.getName(),
				"Information", JOptionPane.INFORMATION_MESSAGE
			);

			actualizarPacientesEnEspera();
		}
	}

	public ListaDeEspera getListaDeEspera() {
		return this.listaDeEspera;
	}

	private void actualizarPacientesEnEspera() {
		this.lblEsperando.setText(String.valueOf(this.listaDeEspera.size()));
	}
}
