package java11_pruebas.pruebas.asincrono.productor_consumidor_no_sync;

public class PruebaBuferCompartido {
	public static void main(String[] args) {
		// crear el objeto compartido utilizado por los subprocesos
		BuferNoSincronizado ubicacionCompartida = new BuferNoSincronizado();
		// crear objetos productor y consumidor
		Productor productor = new Productor(ubicacionCompartida);
		Consumidor consumidor = new Consumidor(ubicacionCompartida);
		productor.start(); // iniciar subproceso productor
		consumidor.start(); // iniciar subproceso consumidor
	}

}
