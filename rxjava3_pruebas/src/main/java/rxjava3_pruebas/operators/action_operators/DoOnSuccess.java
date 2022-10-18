package rxjava3_pruebas.operators.action_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DoOnSuccess {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productObservable = Observable.fromIterable(products);
		productObservable
		.firstElement()
		.doOnSuccess(product -> System.out.println("onSuccess"))
		.subscribe(
			System.out::println
		);

	}
}
