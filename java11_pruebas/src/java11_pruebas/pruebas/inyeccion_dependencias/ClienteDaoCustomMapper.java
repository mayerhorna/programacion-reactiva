package java11_pruebas.pruebas.inyeccion_dependencias;

//@Repository
public class ClienteDaoCustomMapper implements ClienteDao{
	public void grabar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("grabando con CUSTOM MAP: " + cliente);
	}
	
	public void actualizar(Object cliente) {
		//Graba a la base de datos usando JDBC Connection.getManager()....
		System.out.println("actualizando con CUSTOM MAP: " + cliente);
	}
}
