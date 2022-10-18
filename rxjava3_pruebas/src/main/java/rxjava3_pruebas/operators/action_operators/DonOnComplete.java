package rxjava3_pruebas.operators.action_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DonOnComplete {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.doOnComplete(() -> System.out.println("doOnComplete"))
			.filter(product -> product.getIsActive().equals(1))
			.subscribe(
				System.out::println,
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("doOnComplete")
			);

	}
}
