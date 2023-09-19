package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

//ESTA CLASE SERA NUESTRA VENTANA O GUI

public class Demo07 {
	//Listado de todos los productos mostrando el nombre del proveedor y nombre de categoria (relacionar ambas tablas , debo crear l aotra entidad)
	public static void main(String[] args) {
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
			System.out.println("Id Producto..............: " + p.getId_prod());
			System.out.println("Descripcion Producto.....: " + p.getDes_prod());
			//System.out.println("Stock.....: " + p.getStk_prod()); // a traves de getObjTipo ingreso a la propiedad de mi descripcion de mi tipo
			//System.out.println("Precio....:" + p.getPre_prod());
			System.out.println("Categoria................:" + p.getObjCategoria().getDescripcion());
			//System.out.println("Estado del Producto .....:"+ p.getEst_prod());
			System.out.println("Proveedor................:" + p.getObjProveedor().getNombre_rs());
			System.out.println("-------------------------------");
			System.out.println("\n\n");
		}	
				
		em.close();
		
	}
	
}
