package rxjava3_pruebas;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RXJavaProgramSimplificado {

	public static void main(String[] args) {
		Observable<String> observableStrings = Observable.create(
				emmiter -> {
					System.out.println("Hilo Observable: " + Thread.currentThread().getName());
					emmiter.onNext("maria");
					emmiter.onNext("juan");
					emmiter.onNext("jose");
					emmiter.onNext("luisa");
					emmiter.onComplete();
				}
		);
		
		observableStrings
			.filter(nombre -> nombre.length() == 4)			
			.subscribe(
				nombre -> 	println("onNext: " + nombre),
				error -> println(error.getMessage()),
				() -> println("onComplete")
			);
	}
	
	public static void println(String cadena) {
		System.out.println(cadena);
	}

}
