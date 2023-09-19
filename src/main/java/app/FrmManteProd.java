package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JComboBox cboCategorias;
	private JComboBox cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setBounds(230, 106, 102, 14);
		contentPane.add(lblProveedores);

		cboProveedores = new JComboBox();
		cboProveedores.setBounds(300, 104, 120, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo1();
		llenaCombo2();
	}

	void llenaCombo1() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();
		//3. PARA HCER UN LISTADO DE TODOS LOS USUARIOS LO HACEMOS CON SELECT * FROM NOMRMALMENTE
		//pero lo haremos haciendo otra cosa (primero pasa el sql que es mi cdena y luego le paso mi entidad Usuario)
		//4. ste es mi sentencia
		String jpql="select c from Categoria c"; //debe ir el nombre de la entidad Producto, y a la enteidad Producto le guarda en la  variable p, esta p tiene el codigo,nombre,apellido etc etc
		List<Categoria> lstCategorias= em.createQuery(jpql,Categoria.class).getResultList();
		//5. mostrar el contenido del listado en un combobox
		cboCategorias.addItem("Seleccione...");
		for (Categoria c : lstCategorias) {
			cboCategorias.addItem(c.getDescripcion());
		}	
				
		em.close();
		
		
	}
	
	
	
	void llenaCombo2() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();
		//3. PARA HCER UN LISTADO DE TODOS LOS USUARIOS LO HACEMOS CON SELECT * FROM NOMRMALMENTE
		//pero lo haremos haciendo otra cosa (primero pasa el sql que es mi cdena y luego le paso mi entidad Usuario)
		//4. ste es mi sentencia
		String jpql="select pr from Proveedor pr"; //debe ir el nombre de la entidad Producto, y a la enteidad Producto le guarda en la  variable p, esta p tiene el codigo,nombre,apellido etc etc
		List<Proveedor> lstProveedores= em.createQuery(jpql,Proveedor.class).getResultList();
		//5. mostrar el contenido del listado en un combobox
		cboProveedores.addItem("Seleccione...");
		for (Proveedor pr : lstProveedores) {
			cboProveedores.addItem(pr.getNombre_rs());
		}	
				
		em.close();
		
		
	}
	
	
	

	void registrar() {
		
		// TODO Auto-generated method stub
		//1. Obtener la conexion->tiene que llamar a la unidad de persistencia
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();

		//entradas
		String id_prod=txtCodigo.getText();
		//validaciones
		if (!id_prod.matches("[Pp][0-9]{4}")) {
			aviso("Codigo incorrecto");
			return;
		}
		
		//3. PROCESOS
		Producto p=new Producto();
		p.setId_prod(id_prod);
		p.setDes_prod(txtDescripcion.getText());
		//p.set("Quispe");
		p.setStk_prod(Integer.parseInt(txtStock.getText()));
		p.setPre_prod(Double.parseDouble(txtPrecio.getText()));
		p.setIdcategoria(cboCategorias.getSelectedIndex());
		p.setIdproveedor(cboProveedores.getSelectedIndex());
		p.setEst_prod(1); // 1:verdad 0:false
		
		
		try {
		//4. PARA INSRTAR EL USUARIO llamaremos a nuestro manejado ry usaremos un comando PERSIST
		//SI EL PROCESO QUE QUIERO EXECUTAR ES UN REG/ACT/ELIM ->NECESITAN : transacciones
		em.getTransaction().begin(); // esto le dice que voy a empezar una transaccion
		em.persist(p);
		//obs si en caso quisiera hacerun update de mi tabla tb_usuarios o otra setenado algunos campos
		//em.merge(u); //recibiria un comando con el objeto que deseamos actualizar
		//en caso de hacer un delete
		//em.remove(u);
		//Si quisieramos obtener toda la informacion de nuestra tabla para un archivo en particular donde id = algo
		//Usuario x=  em.find(Usuario.class, 1); //PARA QUE jpa entienda que Usuario es una entidad le agregamos class , en el arg sera el id de la llave primaria 
		em.getTransaction().commit(); //confirmo la transaccion
		aviso("Registro OK");
		}catch(Exception e){
			aviso("Error al registar\n" + e.getCause().getMessage());
		}
		em.close();
	}

	void aviso(String s) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, s, "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	void listado() {
		// TODO Auto-generated method stub
		//1. Obtener la conexion->tiene que llamar a la unidad de persistencia
				EntityManagerFactory fabrica= 
						Persistence.createEntityManagerFactory("jpa_sesion2");
				//2. CREAR UN MANEJADOR DE LAS ENTIDADES
				EntityManager em=fabrica.createEntityManager();
				//3. PARA HCER UN LISTADO DE TODOS LOS USUARIOS LO HACEMOS CON SELECT * FROM NOMRMALMENTE
				//pero lo haremos haciendo otra cosa (primero pasa el sql que es mi cdena y luego le paso mi entidad Usuario)
				//4. ste es mi sentencia
				String jpql="select p from Producto p"; //debe ir el nombre de la entidad Producto, y a la enteidad Producto le guarda en la  variable p, esta p tiene el codigo,nombre,apellido etc etc
				List<Producto> lstProductos= em.createQuery(jpql,Producto.class).getResultList();
				//5. mostrar el contenido del listado
				for (Producto p : lstProductos) {
					imprimir("Id Producto..............: " + p.getId_prod() + "\n");
					imprimir("Descripcion Producto.....: " + p.getDes_prod() + "\n");
					//System.out.println("Stock.....: " + p.getStk_prod()); // a traves de getObjTipo ingreso a la propiedad de mi descripcion de mi tipo
					//System.out.println("Precio....:" + p.getPre_prod());
					imprimir("Categoria................:" + p.getObjCategoria().getDescripcion() + "\n");
					//System.out.println("Estado del Producto .....:"+ p.getEst_prod());
					imprimir("Proveedor................:" + p.getObjProveedor().getNombre_rs() + "\n");
					imprimir("-------------------------------");
					imprimir("\n\n");
				}	
						
				em.close();
		
	}
	
	void imprimir(String s) {
		// TODO Auto-generated method stub
		txtSalida.append(s +"\n");
		
	}

	void buscar() {
		// TODO Auto-generated method stub
		
	}
}
