package java11_pruebas.pruebas.asincrono.productor_consumidor_no_sync;

public class Consumidor extends Thread {
	private BuferNoSincronizado ubicacionCompartida; // referencia al objeto compartido

	public Consumidor(BuferNoSincronizado compartido) {
		super("Consumidor");
		ubicacionCompartida = compartido;
	}

	// leer el valor de ubicacionCompartida cuatro veces y sumar los valores
	public void run() {
		int suma = 0;
		for (int cuenta = 1; cuenta <= 4; cuenta++) {
			// estar inactivo de 0 a 3 segundos, leer un valor de Bufer y agregarlo a suma
			try {
				Thread.sleep((int) (Math.random() * 3001));
				suma += ubicacionCompartida.obtener();
			}
			// si se interrumpiĆ³ el subproceso inactivo, imprimir rastreo de la pila
			catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		}
		System.err
				.println(getName() + " leyo valores, dando un total de: " + suma + ".\nTerminando " + getName() + ".");
	}
}