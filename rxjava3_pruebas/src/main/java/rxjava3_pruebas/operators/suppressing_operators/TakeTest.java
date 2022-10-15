package rxjava3_pruebas.operators.suppressing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class TakeTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.take(3)
			.subscribe(
				product -> System.out.println(product.getName()),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);
	}

}
