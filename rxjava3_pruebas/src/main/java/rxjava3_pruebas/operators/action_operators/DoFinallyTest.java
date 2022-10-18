package rxjava3_pruebas.operators.action_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DoFinallyTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
		.doFinally(() -> System.out.println("doFinally"))
		.doOnComplete(() -> System.out.println("doOnComplete"))
		.filter(product -> product.getIsActive().equals(1))
		.subscribe(
			System.out::println
		);

	}

}
