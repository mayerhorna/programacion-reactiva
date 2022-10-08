package java11_pruebas.pruebas.asincrono.productor_consumidor_no_sync;

public class BuferNoSincronizado {
	private int bufer = -1; // compartido por los subprocesos Productor y
	// Consumidor
	// colocar valor en bufer
	public void establecer(int valor) {
	System.err.println(Thread.currentThread().getName() + " escribe " + valor);
	bufer = valor;
	}

	// devolver valor de bufer
	public int obtener() {
	System.err.println(Thread.currentThread().getName() + " lee " + bufer);
	return bufer;
	}
}
