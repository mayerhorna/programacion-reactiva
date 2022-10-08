package java11_pruebas.pruebas.asincrono.productor_consumidor_sync;

public class PruebaBuferCompartidoSincronizado {
	public static void main(String[] args) {
		BuferSincronizado ubicacionCompartida = new BuferSincronizado();

		Productor productor = new Productor(ubicacionCompartida);
		Consumidor consumidor = new Consumidor(ubicacionCompartida);
		productor.start(); // iniciar subproceso productor
		consumidor.start(); // iniciar subproceso consumidor
	}

}
