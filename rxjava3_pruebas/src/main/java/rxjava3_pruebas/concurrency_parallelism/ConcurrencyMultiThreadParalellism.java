package rxjava3_pruebas.concurrency_parallelism;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ConcurrencyMultiThreadParalellism {

	public static void main(String[] args) {
		Observable.just("Juan", "Maria", "Jose", "Hugo", "Sandra")		
				.subscribeOn(Schedulers.trampoline())
				.doOnNext((s) -> System.out.println(Thread.currentThread().getName()))
	            .map(s -> slowCalculation((s)))
	            .subscribe(System.out::println);
	        Observable.range(1,5)
				.subscribeOn(Schedulers.trampoline())
				.doOnNext((s) -> System.out.println(Thread.currentThread().getName()))
	            .map(s -> slowCalculation((s)))
	            .subscribe(System.out::println);
	    try {
	    	Thread.sleep(10000);
	    } catch (InterruptedException e) {
	    }
	}
	public static <T> T slowCalculation(T value) {
		try {
		   Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}

}
