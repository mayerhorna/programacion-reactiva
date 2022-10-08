package java11_pruebas.pruebas.asincrono.productor_consumidor_sync;

public class Productor extends Thread {
	private BuferSincronizado ubicacionCompartida; // referencia al objeto compartido

	public Productor(BuferSincronizado compartido) {
		super("Productor");
		ubicacionCompartida = compartido;
	}

	// almacenar valores de 1 a 4 en ubicacionCompartida
	public void run() {
		for (int cuenta = 1; cuenta <= 4; cuenta++) {
			// estar inactivo de 0 a 3 segundos y luego colocar valor en Bufer
			try {
				Thread.sleep((int) (Math.random() * 3001));
				ubicacionCompartida.establecer(cuenta);
			}
			// si se interrumpió el subproceso inactivo, imprimir rastreo de pila
			catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		}
		System.err.println(getName() + " termino de producir." + "\nTerminando " + getName() + ".");
	}
}
