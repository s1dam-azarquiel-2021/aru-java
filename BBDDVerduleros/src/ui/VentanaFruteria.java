package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAOGrupo;
import dao.DAOProducto;
import entities.Grupo;
import entities.Producto;

public class VentanaFruteria extends JFrame {
	private JTable table;
	private JTextField txtNombre;
	private JComboBox<String> grupos;
	private JTextField txtId;
	private JTextField txtPrecio;
	private DAOProducto daoProducto;
	private DAOGrupo daoGrupo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					VentanaFruteria frame = new VentanaFruteria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaFruteria() {
		this.daoProducto = new DAOProducto();
		this.daoGrupo = new DAOGrupo();

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);

		JPanel mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPane.setLayout(new BorderLayout(20, 20));
		this.setContentPane(mainPane);

		JLabel title = new JLabel("Gestion de la fruteria");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		mainPane.add(title, BorderLayout.NORTH);

		JScrollPane scrollTable = new JScrollPane();
		mainPane.add(scrollTable, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarProducto();
			}
		});
		scrollTable.setViewportView(table);

		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BorderLayout(100, 20));
		mainPane.add(bottomPane, BorderLayout.SOUTH);

		JPanel leftBottomPane = new JPanel();
		leftBottomPane.setLayout(new GridLayout(4, 2, 20, 20));
		bottomPane.add(leftBottomPane, BorderLayout.CENTER);

		JLabel lblId = new JLabel("Id:", SwingConstants.RIGHT);
		leftBottomPane.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		leftBottomPane.add(txtId);

		JLabel lblNombre = new JLabel("Nombre:", SwingConstants.RIGHT);
		leftBottomPane.add(lblNombre);

		txtNombre = new JTextField();
		leftBottomPane.add(txtNombre);

		JLabel lblGrupo = new JLabel("Grupo:", SwingConstants.RIGHT);
		leftBottomPane.add(lblGrupo);

		grupos = new JComboBox<>();
		leftBottomPane.add(grupos);

		JLabel lblPrecio = new JLabel("Precio:", SwingConstants.RIGHT);
		leftBottomPane.add(lblPrecio);

		txtPrecio = new JTextField();
		leftBottomPane.add(txtPrecio);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		bottomPane.add(btnModificar, BorderLayout.EAST);

		this.updateTable();
	}

	private void modificar() {
		this.daoProducto.update(
			new Producto(
				Integer.valueOf(this.txtId.getText()),
				this.txtNombre.getText(),
				this.daoGrupo.get((String) this.grupos.getSelectedItem()),
				Double.valueOf(this.txtPrecio.getText())
			)
		);

		this.updateTable();
	}

	private void cargarProducto() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(
				this, "Selecciona una habitacion.", "Warning",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		Producto producto = daoProducto.get(
			(int) this.table.getValueAt(this.table.getSelectedRow(), 0)
		);

		this.txtId.setText(String.valueOf(producto.getId()));
		this.txtNombre.setText(producto.getNombre());
		this.txtPrecio.setText(String.valueOf(producto.getPrecio()));
		this.grupos.setModel(
			new DefaultComboBoxModel<>(
				this.cargarGrupos(producto.getGrupo().getNombre())
			)
		);
	}

	private String[] cargarGrupos(String grupo) {
		ArrayList<Grupo> gruposCargados = daoGrupo.get();
		String[] grupos = new String[gruposCargados.size()];
		grupos[0] = grupo;
		gruposCargados.remove(grupo);

		for (int i = 1; i < gruposCargados.size(); i++) {
			grupos[i] = gruposCargados.get(i - 1).getNombre();
		}

		return grupos;
	}

	private void updateTable() {
		ArrayList<Producto> productos = this.daoProducto.get();
		Object[][] datos = new Object[productos.size()][4];

		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = productos.get(i).getId();
			datos[i][1] = productos.get(i).getNombre();
			datos[i][2] = productos.get(i).getGrupo().getNombre();
			datos[i][3] = productos.get(i).getPrecio();
		}

		this.table.setModel(new DefaultTableModel(datos, new String[] {
			"ID", "Nombre", "Grupo", "Precio"
		}) {
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class
			};

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
