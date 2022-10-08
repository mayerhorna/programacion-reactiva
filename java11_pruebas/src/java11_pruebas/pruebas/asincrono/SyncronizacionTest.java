package java11_pruebas.pruebas.asincrono;

public class SyncronizacionTest {
	public static void main(String[] args) {
	}
}

class Pedidos implements Runnable {
	int nroPedido = 1;

	public void run() { // A toma monitor (this) y bloquea acceso a run(); luego libera el monitor, y
						// este sera tomado por B
		// System.out.println("....");
		// A(toma el monitor this) y B espera tomar el monitor de this
		// cuando A libera el monitor de this, B que esta en espera lo toma e ingresa al
		// bloque synchronized
		synchronized ("javaS") {
			if (nroPedido > 0) {
				nroPedido--;
				System.out.println(Thread.currentThread().getName() + ": toma pedido y dejo en " + nroPedido);
			} else {
				System.out.println(Thread.currentThread().getName() + ": no encontro");
			}
		}

	}

	public static void main(String[] args) {
		Pedidos pedidos1 = new Pedidos();
		Pedidos pedidos2 = new Pedidos();
		new Thread(pedidos1, "A").start();
		new Thread(pedidos2, "B").start();
		// new Thread(pedidos,"C").start();
	}
}

class CalcularTotal implements Runnable {
	public void run() {
		synchronized (this) {
			try {
				System.out.print(Thread.currentThread().getName());
				wait();
				Thread.sleep(500); // logica de negocio del cÃ¡lculo.
				System.out.print(Thread.currentThread().getName());
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args){ 	 
	     CalcularTotal cT = new CalcularTotal();
		  new Thread(cT,"A").start();  // Proceso A
		  new Thread(cT,"B").start();  // Proceso B
	   }
}