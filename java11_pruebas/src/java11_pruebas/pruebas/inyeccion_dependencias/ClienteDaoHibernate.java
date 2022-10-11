package java11_pruebas.pruebas.inyeccion_dependencias;

//
public class ClienteDaoHibernate implements ClienteDao{
	public void grabar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("grabando con HIBERNATE: " + cliente);
	}
	
	public void actualizar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("actualizando con HIBERNATE: " + cliente);
	}
}
