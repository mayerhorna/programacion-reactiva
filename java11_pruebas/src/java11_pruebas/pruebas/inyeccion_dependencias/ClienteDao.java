package java11_pruebas.pruebas.inyeccion_dependencias;

public interface ClienteDao {
	public void grabar(Object cliente);
	public void actualizar(Object cliente);
}
