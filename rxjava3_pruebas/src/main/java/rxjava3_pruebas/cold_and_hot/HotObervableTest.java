package rxjava3_pruebas.cold_and_hot;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class HotObervableTest {

	public static void main(String[] args) {
		ConnectableObservable<Long> hot = Observable.interval(1000, TimeUnit.MILLISECONDS).publish();
		hot.connect();
		hot.subscribe(nroSegundo -> System.out.println("Suscriptor Numero 1: " + nroSegundo));
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		hot.subscribe(nroSegundo -> System.out.println("Suscriptor Numero 2: " + nroSegundo));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
		}

	}

}
