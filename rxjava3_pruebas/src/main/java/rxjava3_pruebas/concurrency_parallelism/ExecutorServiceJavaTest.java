package rxjava3_pruebas.concurrency_parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExecutorServiceJavaTest {

	public static void main(String[] args) {
		int numberOfThreads = 20;
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
		Scheduler scheduler = Schedulers.from(executor);
		Observable.just("Juan", "Maria", "Jose", "Hugo" , "Sandra")
			 .subscribeOn(scheduler)
		        .doFinally(executor::shutdown)
		        .subscribe(System.out::println);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

	}

}
