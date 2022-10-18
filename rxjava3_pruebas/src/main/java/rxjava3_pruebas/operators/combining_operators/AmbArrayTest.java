package rxjava3_pruebas.operators.combining_operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AmbArrayTest {

	public static void main(String[] args) {
		Observable<Double> exchangeService1 
			= Observable.fromCallable(()-> {
				System.out.println("invocando servicio1");
				return Double.valueOf("3.81");
		}); 
		Observable<Double> exchangeService2 
			= Observable.fromCallable(()-> {
				System.out.println("invocando servicio2");
				return Double.valueOf("3.82");
			}); 
		exchangeService1 = exchangeService1.subscribeOn(Schedulers.newThread());
		exchangeService2 = exchangeService2.subscribeOn(Schedulers.newThread());
		Observable
			.ambArray(exchangeService1, exchangeService2)
			.subscribe(
				exchangeValue -> System.out.println("exchange: %s".formatted(exchangeValue)),
				error -> System.out.println(error.getMessage())
			);
		try {Thread.sleep(5000);} catch (InterruptedException e) {}

	}

}
