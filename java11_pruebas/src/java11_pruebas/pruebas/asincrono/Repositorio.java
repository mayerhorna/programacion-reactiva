package java11_pruebas.pruebas.asincrono;

public class Repositorio {
	public void guardar() {
		System.out.println("guardando");
		System.out.println("hilo: " + Thread.currentThread().getName());
	}
}
