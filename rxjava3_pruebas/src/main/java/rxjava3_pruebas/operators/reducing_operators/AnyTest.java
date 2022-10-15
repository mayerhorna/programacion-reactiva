package rxjava3_pruebas.operators.reducing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class AnyTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable.any(product -> product.getIsActive().equals(0))
		.subscribe(
			areAnyInactiveProduct -> System.out.println(areAnyInactiveProduct), 
			error -> System.out.println(error.getMessage()) 
		);

	}
}
