package java11_pruebas.pruebas.inyeccion_dependencias;

public class AppPrincipal {

	public static void main(String[] args) {
		ClienteController clienteController = new ClienteController();
		ClienteDao clienteDao = new ClienteDaoHibernate(); 
		clienteController.setClienteDao(clienteDao);
		clienteController.grabar("Cliente 1");
		
		
		//xml  <bea>
		//@anotaciones
	}

}
