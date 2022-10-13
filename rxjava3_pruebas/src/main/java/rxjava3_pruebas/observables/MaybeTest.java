package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import rxjava3_pruebas.data.Product;

public class MaybeTest {
	public static void main(String[] args) {
		Maybe<Product> productMaybeOneObservable = Maybe.create(
			emmiter -> {
				Product product = new Product();
				product.setName("AMOXICILINA 500 mg Tableta");
				emmiter.onSuccess(product);
			}
		);
		Maybe<Product> productMaybeEmptyObservable = Maybe.empty();
		
		MaybeObserver<Product> productMaybeObserver = new MaybeObserver<Product>() {
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe");
			}
			public void onSuccess(Product product) {
				System.out.println("Producto obtenido: " + product.getName());
			}
			public void onError(Throwable e) {
				System.out.println("onError");
			}
			public void onComplete() {
				System.out.println("onComplete");
			}
		};
		productMaybeOneObservable.subscribe(productMaybeObserver);
		productMaybeEmptyObservable.subscribe(productMaybeObserver);
	}
}
