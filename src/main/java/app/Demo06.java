package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//ESTA CLASE SERA NUESTRA VENTANA O GUI

public class Demo06 {
	//Listado de todos los usuarios mostrando el tipo de usuario (relacionar ambas tablas , debo crear l aotra entidad)
	public static void main(String[] args) {
		//1. Obtener la conexion->tiene que llamar a la unidad de persistencia
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();
		//3. PARA HCER UN LISTADO DE TODOS LOS USUARIOS LO HACEMOS CON SELECT * FROM NOMRMALMENTE
		//pero lo haremos haciendo otra cosa (primero pasa el sql que es mi cdena y luego le paso mi entidad Usuario)
		//4. ste es mi sentencia
		String jpql="select u from Usuario u"; //debe ir el nombre de la entidad Usuario, y a la enteidad Usuario le guarda en la  variable u, esta u tiene el codigo,nombre,apellido etc etc
		List<Usuario> lstUsuarios= em.createQuery(jpql,Usuario.class).getResultList();
		//5. mostrar el contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo.....: " + u.getCod_usua());
			System.out.println("Nombre.....: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.....: " + u.getIdtipo() + "-" + u.getObjTipo().getDescripcion()); // a traves de getObjTipo ingreso a la propiedad de mi descripcion de mi tipo
			System.out.println("-------------------------------");
		}	
				
		em.close();
		
	}
	
}
