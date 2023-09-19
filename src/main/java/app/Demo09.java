package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

//ESTA CLASE SERA NUESTRA VENTANA O GUI

public class Demo09 {
	//Listado de  los usuarios segun un criterio (filtro)
	public static void main(String[] args) {
		String usuario=JOptionPane.showInputDialog("Ingrese usuario:");
		String clave=JOptionPane.showInputDialog("Ingrese contrasena:");
		
		
		
		//1. Obtener la conexion->tiene que llamar a la unidad de persistencia
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();
		//4. ste es mi sentencia debe llevar where para tener un filtro donde idtipo=? --> Lista
		//int xtipo=1; //mi valor que voy a leer 
		String jpql="select u from Usuario u where u.usr_usua= :xusr and u.cla_usua= :xcla"; //xtipo es una variable que va recibir el tipo de dato que yo le quiero dar
		
		//Debera devolverme un elmeento de tipo usuario solo el primero por eso antes era List ahora ya no
		//List<Usuario> lstUsuarios= em.createQuery(jpql,Usuario.class).setParameter("xusr",usuario).setParameter("xcla", clave).getResultList();//getResultlist le devuelve la lsita d eusuarios, el primer valor del set parameter es el valor de :xtipo y el segundo valor es el int xtipo
		
		
		try {
			Usuario u= em.createQuery(jpql,Usuario.class).setParameter("xusr",usuario).setParameter("xcla", clave).getSingleResult();//getResultlist le devuelve la lsita d eusuarios, el primer valor del set parameter es el valor de :xtipo y el segundo valor es el int xtipo
			//5. mostrar el contenido del listado
			//tampoco ya no se necesitaria un for porque es para el login osea traer un usuario
			//for (Usuario u : lstUsuarios) {
			
			//Mostrar contenido de usuario
			/*
			System.out.println("Codigo.....: " + u.getCod_usua());
			System.out.println("Nombre.....: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.....: " + u.getIdtipo() + "-" + u.getObjTipo().getDescripcion()); // a traves de getObjTipo ingreso a la propiedad de mi descripcion de mi tipo
			System.out.println("-------------------------------");
			*/
			
			//Mostrar dialogo de bienvenido
			JOptionPane.showMessageDialog(null, "Bienvenido"+ u.getNom_usua());
			//abrir la ventana de menu principal (como prueba abriremos la ventana de mantenimiento)
			FrmManteProd v=new FrmManteProd();
			v.setVisible(true);
			//dispose(); //esto se usa en caso tengamos una gui pero como no tenemos y esto es una clase de java no podemos usarla ahora
			//test de comentario
			//}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
		}
			
				
		em.close();
		
	}
	
}
