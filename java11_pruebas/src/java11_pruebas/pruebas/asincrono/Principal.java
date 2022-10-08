package java11_pruebas.pruebas.asincrono;

class MyThread2 extends Thread{
	@Override
	public void run() {
		super.run();
	}
}

public class Principal {

	public static void main(String[] args) {
		System.out.println("1");
		System.out.println("hilo: " + Thread.currentThread().getName());
		Thread hiloRepositorio = new Thread("hiloRepositorio") {
			@Override
			public void run() {
				Repositorio repositorio = new Repositorio();
				repositorio.guardar();
			}
		};
		hiloRepositorio.start();
		
		Thread hiloRepositorio2 = new Thread(()->{
			Repositorio repositorio = new Repositorio();
			repositorio.guardar();
		});
		//hiloRepositorio2.setPriority(3);
		hiloRepositorio2.start();
		try {
			hiloRepositorio.join();
			hiloRepositorio2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("2");
		System.out.println("hilo: " + Thread.currentThread().getName());
	}

}


class MyThread extends Thread {
	public void run() {	m1();}
	MyThread(String threadName) { super(threadName);}
	public void m1() {
		System.out.print(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		MyThread a = new MyThread("A");
		MyThread b = new MyThread("B");
		b.start();
		a.start();
	}
}

