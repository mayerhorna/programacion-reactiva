package rxjava3_pruebas;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RXJavaProgram {

	public static void main(String[] args) {
		//1. Observable
		//Observable<String> observableStrings = Observable.just("maria","juan","jose","luisa");
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
		
		//2. Observer
		Observer<String> observerString = new Observer<String>() {
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe");
			}
			public void onNext(String nombre) {
				System.out.println("Hilo Observador: " + Thread.currentThread().getName());
				System.out.println("onNext: " + nombre);
			}
			public void onError(Throwable e) {
				System.out.println("onError: " + e.getMessage());
			}
			public void onComplete() {
				System.out.println("onComplete");
			}
		};
		
		//3. Operadores
		observableStrings.filter(nombre -> nombre.length() == 4);
		
		//4. Schedulers
		observableStrings = observableStrings.observeOn(Schedulers.newThread());
		observableStrings = observableStrings.subscribeOn(Schedulers.newThread());
		
		//5. Suscripcion
		observableStrings.subscribe(observerString);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}  
	}

}
