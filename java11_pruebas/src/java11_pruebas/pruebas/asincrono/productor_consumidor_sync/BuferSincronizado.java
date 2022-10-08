package java11_pruebas.pruebas.asincrono.productor_consumidor_sync;

public class BuferSincronizado {
	private int bufer = -1; // compartido por los subprocesos productor y
	private int cuentaBuferOcupado = 0; // cuenta de búferes ocupados

	public synchronized void establecer(int valor) {
		String nombre = Thread.currentThread().getName();
		while (cuentaBuferOcupado == 1) {
			try {
				System.err.println(nombre + " trata de escribir.");
				mostrarEstado("Bufer lleno. " + nombre + " espera.");
				wait();
			}
			catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		} // fin de instrucción while
		bufer = valor; // establecer nuevo valor de bufer
		++cuentaBuferOcupado;
		mostrarEstado(nombre + " escribe " + bufer);
		notify();  
	} 

	public synchronized int obtener() {
		String nombre = Thread.currentThread().getName();
		while (cuentaBuferOcupado == 0) {
			try {
				System.err.println(nombre + " trata de leer.");
				mostrarEstado("Bufer vacio. " + nombre + " espera.");
				wait();
			}
			catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		} // fin de instrucción while
		--cuentaBuferOcupado;
		mostrarEstado(nombre + " lee " + bufer);
		notify(); // indicar al subproceso en espera que esté listo para
		return bufer;
	} // fin del método obtener; libera bloqueo en BuferSincronizado

	// mostrar la operación actual y el estado del búfer
	public void mostrarEstado(String operacion) {
		StringBuffer lineaSalida = new StringBuffer(operacion);
		lineaSalida.setLength(40);
		lineaSalida.append(bufer + "\t\t" + cuentaBuferOcupado);
		System.err.println(lineaSalida);
		System.err.println();
	}
}