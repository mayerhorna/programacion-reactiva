package rxjava3_pruebas.operators.action_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjava3_pruebas.data.Product;

public class DoOnDisposeTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		Disposable disposable = productsObservable
		        .doOnDispose( () -> System.out.println("onDispose!") )
		        .subscribeOn(Schedulers.newThread())
		        .doOnNext(product -> Thread.sleep(1000))
		        .subscribe( 
		        	product -> System.out.println("Recibido: " + product.getName()),
		        	error -> System.out.println(error.getMessage()),
		        	() -> System.out.println("onComplete")
		        ); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {	
		}
		disposable.dispose();
	}

}
