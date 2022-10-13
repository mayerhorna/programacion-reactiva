package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import rxjava3_pruebas.data.Product;

public class SingleTest {

	public static void main(String[] args) {
		//1. observable
		Single<Product> productSingleObservable = Single.create(
			emmiter -> {
				Product product = new Product();
				product.setName("AMOXICILINA 500 mg Tableta");
				emmiter.onSuccess(product);
			}
		);
		//observador
		SingleObserver<Product> productSingleObserver = new SingleObserver<Product>() {
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe");
			}	
			public void onSuccess(Product product) {
				System.out.println("Producto obtenido: " + product.getName());
			}
			public void onError(Throwable e) {
				System.out.println("onError");
			}
		};
		
		//Suscription
		productSingleObservable.subscribe(productSingleObserver);

	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}

}
