package java11_pruebas.pruebas.inyeccion_dependencias;
//
public class ClienteDaoJdbc  implements ClienteDao{
	public void grabar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("grabando con JDBC: " + cliente);
	}
	
	public void actualizar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("actualizando con JDBC: " + cliente);
	}
}
