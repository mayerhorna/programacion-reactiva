package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class CompletableTest {

	public static void main(String[] args) {
		Completable completableObservable = Completable.create(
				emmiter -> {
					//guarda un producto
					emmiter.onComplete();
				}
		);

		CompletableObserver completableObserver = new CompletableObserver() {
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe");
			}
			public void onError(Throwable e) {
				System.out.println("onError");
			}
			public void onComplete() {
				System.out.println("Grabo satisfactoriamente");
			}
		};

		completableObservable.subscribe(completableObserver);

	}
	
}
