package buscarTexto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaPrincipal extends JFrame {
	private GestorArchivoTexto gestor = new GestorArchivoTexto("");
	private JTextArea textArea;
	private JTextField txtFieldFiltro;

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
		this.setTitle("Bloc de notas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 531, 407);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);

		this.textArea = new JTextArea();

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como");

		mnArchivo.add(mntmAbrir);
		mnArchivo.add(mntmGuardar);
		mnArchivo.add(mntmGuardarComo);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		txtFieldFiltro = new JTextField();
		contentPane.add(txtFieldFiltro, BorderLayout.NORTH);

		txtFieldFiltro.getDocument().addDocumentListener(
			new DocumentListener() {
				public void removeUpdate(DocumentEvent e) {
					filtrarTexto();
				}

				public void insertUpdate(DocumentEvent e) {
					filtrarTexto();
				}

				public void changedUpdate(DocumentEvent e) {
					filtrarTexto();
				}
			}
		);

		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});

		mntmAbrir.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)
		);

		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		mntmGuardar.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)
		);

		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
	}

	private void abrir() {
		JFileChooser dialogo = new JFileChooser(this.gestor.getArchivo());
		dialogo.showOpenDialog(this);

		if (dialogo.getSelectedFile() != null) {
			this.gestor.setArchivo(dialogo.getSelectedFile().getAbsolutePath());
			this.gestor.readContenido();
			this.textArea.setText(this.gestor.getContenido());

			this.setTitle(this.gestor.getArchivo() + ":Bloc de notas");
		}
	}

	private void guardarComo() {
		JFileChooser dialogo = new JFileChooser(gestor.getArchivo());
		dialogo.showSaveDialog(this);

		if (dialogo.getSelectedFile() != null) {
			this.gestor.setArchivo(dialogo.getSelectedFile().getAbsolutePath());
			this.gestor.setContenido(this.textArea.getText());
			this.gestor.guardarContenido();

			this.setTitle(this.gestor.getArchivo() + ":Bloc de notas");
		}
	}

	private void guardar() {
		if (this.gestor.getArchivo() != null) {
			this.gestor.setContenido(this.textArea.getText());
			this.gestor.guardarContenido();
		} else {
			this.guardarComo();
		}
	}

	public void filtrarTexto() {
		if (txtFieldFiltro.getText().isEmpty()) {
			this.textArea.setText(this.gestor.getContenido());
			return;
		}

		Pattern p = Pattern.compile(
			"(?m)(.*" + txtFieldFiltro.getText() + ".*)"
		);
		Matcher m = p.matcher(this.gestor.getContenido());

		String filtrado = "";
		while (m.find()) {
			filtrado += m.group() + "\n";
		}

		this.textArea.setText(filtrado);
	}
}
