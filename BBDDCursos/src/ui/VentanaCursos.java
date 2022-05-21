package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAOAlumno;
import dao.DAOCurso;
import dao.DAOEvaluacion;
import entities.Alumno;
import entities.Curso;
import entities.Evaluacion;

public class VentanaCursos extends JFrame {
	private JTable table;
	private JComboBox<String> alumnos;
	private JComboBox<String> cursos;
	private JComboBox<Integer> notas;
	private JTextField txtObservaciones;
	private DAOAlumno daoAlumno;
	private DAOCurso daoCurso;
	private DAOEvaluacion daoEvaluacion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaCursos frame = new VentanaCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCursos() {
		this.daoAlumno = new DAOAlumno();
		this.daoCurso = new DAOCurso();
		this.daoEvaluacion = new DAOEvaluacion();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);

		JPanel mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		this.setContentPane(mainPane);

		JLabel title = new JLabel("Evaluacion de cursos");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		mainPane.add(title);

		mainPane.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout(20, 20));
		mainPane.add(centerPane);

		mainPane.add(Box.createRigidArea(new Dimension(0, 20)));

		JScrollPane scrollTable = new JScrollPane();
		mainPane.add(scrollTable);

		table = new JTable();
		scrollTable.setViewportView(table);

		JPanel centerTopPane = new JPanel();
		centerTopPane.setLayout(new GridLayout(4, 2, 20, 20));
		centerPane.add(centerTopPane, BorderLayout.CENTER);

		JLabel lblId = new JLabel("Seleccione Alumno:", JLabel.RIGHT);
		centerTopPane.add(lblId);

		alumnos = new JComboBox<String>();
		alumnos.setModel(new DefaultComboBoxModel<String>(this.alumnos()));
		centerTopPane.add(alumnos);

		JLabel lblNombre = new JLabel("Seleccione Curso:", JLabel.RIGHT);
		centerTopPane.add(lblNombre);

		cursos = new JComboBox<>();
		cursos.setModel(new DefaultComboBoxModel<String>(this.cursos()));
		centerTopPane.add(cursos);

		JLabel lblGrupo = new JLabel("Nota:", JLabel.RIGHT);
		centerTopPane.add(lblGrupo);

		notas = new JComboBox<Integer>();
		notas.setModel(new DefaultComboBoxModel<Integer>(this.notas()));
		centerTopPane.add(notas);

		JLabel lblPrecio = new JLabel("Observaciones:", JLabel.RIGHT);
		centerTopPane.add(lblPrecio);

		txtObservaciones = new JTextField();
		centerTopPane.add(txtObservaciones);

		JButton btnModificar = new JButton("Anotar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		centerPane.add(btnModificar, BorderLayout.SOUTH);

		this.updateTable();
	}

	private Integer[] notas() {
		Integer[] notas = new Integer[10];
		for (int i = 0; i < 10; i++) {
			notas[i] = i + 1;
		}

		return notas;
	}

	private String[] cursos() {
		ArrayList<Curso> cursosDao = this.daoCurso.get();
		String[] alumnos = new String[cursosDao.size()];

		for (int i = 0; i < cursosDao.size(); i++) {
			alumnos[i] = cursosDao.get(i).getCurso();
		}

		return alumnos;
	}

	private String[] alumnos() {
		ArrayList<Alumno> alumnosDao = this.daoAlumno.get();
		String[] alumnos = new String[alumnosDao.size()];

		for (int i = 0; i < alumnosDao.size(); i++) {
			alumnos[i] = alumnosDao.get(i).getNombre();
		}

		return alumnos;
	}

	private void modificar() {
		final Alumno alumno = this.daoAlumno.get(
			(String) this.alumnos.getSelectedItem()
		);
		final Curso curso = this.daoCurso.get(
			(String) this.cursos.getSelectedItem()
		);

		if (
			this.daoEvaluacion.get(
				alumno.getCodigo(), curso.getCodigo()
			) != null
		) {
			JOptionPane.showMessageDialog(
				this, "No puedes aniadir otra nota para " + alumno.getNombre()
				+ " en " + curso.getCurso(), "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		this.daoEvaluacion.add(
			new Evaluacion(
				alumno,
				curso,
				(int) this.notas.getSelectedItem(),
				this.txtObservaciones.getText()
			)
		);

		this.updateTable();
	}

	private void updateTable() {
		ArrayList<Evaluacion> evaluaciones = this.daoEvaluacion.get();

		Object[][] datos = new Object[evaluaciones.size()][4];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = evaluaciones.get(i).getAlumno().getNombre();
			datos[i][1] = evaluaciones.get(i).getCurso().getCurso();
			datos[i][2] = evaluaciones.get(i).getNotaFinal();
			datos[i][3] = evaluaciones.get(i).getObservaciones();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"Alumno", "Curso", "Nota", "Observaciones"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
