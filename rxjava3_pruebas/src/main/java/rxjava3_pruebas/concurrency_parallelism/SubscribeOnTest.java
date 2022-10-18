package rxjava3_pruebas.concurrency_parallelism;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnTest {

	public static void main(String[] args) {
		Observable.just("Juan", "Maria", "Jose", "Hugo" , "Sandra")
		.subscribeOn(Schedulers.computation()) // ubicación recomendada
		.map(String::length).filter(i -> i > 5)
		.subscribe(System.out::println);

		Observable.just("Juan", "Maria", "Jose", "Hugo" , "Sandra")
			.map(String::length)
			.subscribeOn(Schedulers.computation())
			.filter(i -> i > 5)
			.subscribe(System.out::println);

		Observable.just("Juan", "Maria", "Jose", "Hugo" , "Sandra")
			.map(String::length)
			.filter(i -> i > 5)
			.subscribeOn(Schedulers.computation())
			.subscribe(System.out::println);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

	}

}
