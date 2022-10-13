package rxjava3_pruebas.observables;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;

public class ObservablesTest {

	public static void main(String[] args) {
		Observable<String> empty = Observable.empty();
		Observable<Integer> singleElement = Observable.just(1);   // count = 1
		Observable<Integer> fromArray = Observable.just(1, 2, 3); // count = 3
		var list = List.of("a", "b", "c");
		Observable<String> fromList = Observable.fromIterable(list);
		
		Observable<Double> randoms = Observable.generate(emitter -> emitter.onNext(Math.random()));
		
		//randoms.subscribe(System.out::println);
		
		Observable<Integer> oddNumbers = Observable.generate(
				() -> 1, (value, emitter) -> {
					if(value == 11) emitter.onComplete();
					emitter.onNext(value);
				    return value +  2 ; 
				}
			);
		oddNumbers.subscribe(System.out::println);
		
		
		//a partir de rxjava3:
		Stream<Integer> fromArray2 = Stream.of(1, 2, 3);
		Observable<Integer> obsInts = Observable.fromStream(fromArray2);
		//obsInts.forEach(System.out::println);
		
		Stream<Integer> stream = Stream.iterate(1, (i)->i+1);
		Observable<Integer> obs = Observable.fromStream(stream);  
		//obs.forEach(System.out::println);
		
		
		//
		Observable<java.util.Date> deferObservable = Observable.defer(
				() -> {
					return Observable.just(new java.util.Date()); 
				}
			);
			deferObservable.forEach(System.out::println); 
		
		Observable<String> empty2 = Observable.empty();
		empty2.subscribe(
			v -> System.out.println("Esto no se imprimira!"),
			error -> System.out.println("Imprime si hay error!"),
			() -> System.out.println("Completo operacion!")
		);
		
		Observable<String> never = Observable.never();
		never.subscribe(
				v -> System.out.println("Esto nunca se imprimira!"),
				error -> System.out.println("Esto tampoco!"),
				() -> System.out.println("Esto menos!")
		);
		
		/*
		Observable<Long> clock = Observable.interval(1, TimeUnit.SECONDS);
		clock.subscribe(time -> {
			if (time % 2 == 0L) {
				System.out.println("Tick");
			} else {
				System.out.println("Tock");
			}
		});
		
		Observable<Long> timer = Observable.timer(2, TimeUnit.SECONDS);
		timer.subscribe(time -> {
			System.out.println("Empezamos despues de 2 segundos");
		});
		*/
		Callable<String> task = () -> { System.out.println(""); return "ok"  ;};
		Observable<String> callable = Observable.fromCallable(task);
		callable.subscribe(
			string -> System.out.println(string),
			error -> System.out.println("Imprime si hay error!"), 
			() -> System.out.println("Completo operacion!")
		);
		
		//no espera retorno
		Action task2 = () -> {
			System.out.println("Ejecuta tarea sin retorno");
			System.out.println("Ejecuta tarea2 sin retorno");
		};
		Observable<String> action = Observable.fromAction(task2);
		action.subscribe(
			string -> System.out.println(string),
			error -> System.out.println("Imprime si hay error!"), 
			() -> System.out.println("Completo operacion!")
		);
		
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		Future<String> future = executor.schedule(() -> "Hola Futuro!" , 1, TimeUnit.SECONDS);
		Observable<String> observableFuture = Observable.fromFuture(future);
		observableFuture.subscribe(
				string -> System.out.println(string),
				error -> System.out.println("Imprime si hay error!"), 
				() -> System.out.println("Completo operacion!")
		);

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}

}
