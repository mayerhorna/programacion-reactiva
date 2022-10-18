package rxjava3_pruebas.concurrency_parallelism;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyMainThreadParalellism {
	public static void main(String[] args) {
		Observable
			.just("Juan", "Maria", "Jose", "Hugo", "Sandra")
			.map(s -> slowCalculation((s)))
			.subscribe(System.out::println);

		Observable
			.range(1, 5)
			.map(s -> slowCalculation((s)))
			.subscribe(System.out::println);
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
