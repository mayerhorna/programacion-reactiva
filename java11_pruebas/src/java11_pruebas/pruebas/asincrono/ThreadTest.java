package java11_pruebas.pruebas.asincrono;

public class ThreadTest {
	public static void main(String[] args) {
	}
}

class Test implements Runnable{
	public void run(){
		String str="hello";
		try{
			System.out.print(Thread.currentThread().getName());     
			Thread.sleep(500);
			System.out.print(Thread.currentThread().getName());  		
		}catch(InterruptedException e){
		}
	}
	public static void main(String[] args){
		new Thread(new Test(),"A").start();
		new Thread(new Test(),"B").start();
	}
}