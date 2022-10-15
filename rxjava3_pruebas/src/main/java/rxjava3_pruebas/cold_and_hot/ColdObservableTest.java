package rxjava3_pruebas.cold_and_hot;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ColdObservableTest {

	public static void main(String[] args) {
		Observable<Long> cold = Observable.interval(1, TimeUnit.SECONDS);
		cold.subscribe(nroSegundo -> System.out.println("Suscriptor Numero 1: " + nroSegundo));
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		cold.subscribe(nroSegundo -> System.out.println("Suscriptor Numero 2: " + nroSegundo));
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

	}

}
