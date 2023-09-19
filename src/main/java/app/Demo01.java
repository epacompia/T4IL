package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//ESTA CLASE SERA NUESTRA VENTANA O GUI

public class Demo01 {
	//REALIZAR EL REGISTRO DE UN NUEVO USUARIO USANDO VALORES FIJOS
	//digito main luego ctrl y espacio y asi obtenemos el void main
	public static void main(String[] args) {
		//1. Obtener la conexion->tiene que llamar a la unidad de persistencia
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("jpa_sesion2");
		//2. CREAR UN MANEJADOR DE LAS ENTIDADES
		EntityManager em=fabrica.createEntityManager();
		//3. PROCESOS
		Usuario u=new Usuario();
		u.setCod_usua(789);
		u.setNom_usua("Jose");
		u.setApe_usua("Quispe");
		u.setUsr_usua("jquispe");
		u.setCla_usua("123");
		u.setFna_usua("200/01/15");
		u.setIdtipo(0);
		u.setEst_usua(0);
		
		//4. PARA INSRTAR EL USUARIO llamaremos a nuestro manejado ry usaremos un comando PERSIST
		//SI EL PROCESO QUE QUIERO EXECUTAR ES UN REG/ACT/ELIM ->NECESITAN : transacciones
		em.getTransaction().begin(); // esto le dice que voy a empezar una transaccion
		em.persist(u);
		//obs si en caso quisiera hacerun update de mi tabla tb_usuarios o otra setenado algunos campos
		//em.merge(u); //recibiria un comando con el objeto que deseamos actualizar
		//en caso de hacer un delete
		//em.remove(u);
		//Si quisieramos obtener toda la informacion de nuestra tabla para un archivo en particular donde id = algo
		Usuario x=  em.find(Usuario.class, 1); //PARA QUE jpa entienda que Usuario es una entidad le agregamos class , en el arg sera el id de la llave primaria 
		em.getTransaction().commit(); //confirmo la transaccion
		System.out.println("Registro OK");
		em.close();
		
	}
	
}
