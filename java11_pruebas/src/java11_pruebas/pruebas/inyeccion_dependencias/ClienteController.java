package java11_pruebas.pruebas.inyeccion_dependencias;

//@Controller
public class ClienteController {
	//@Autowired
	private ClienteDao clienteDao;
	
	//inyeccion de dependencia por setter
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void grabar(Object cliente) {
		clienteDao.grabar(cliente);
	}
	
	public void actualizar(Object cliente) {
		clienteDao.actualizar(cliente);
	}
}
