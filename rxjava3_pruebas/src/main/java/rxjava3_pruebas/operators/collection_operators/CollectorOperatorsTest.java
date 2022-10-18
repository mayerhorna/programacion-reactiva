package rxjava3_pruebas.operators.collection_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class CollectorOperatorsTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.filter(product -> product.getIsActive().equals(1))
			.toList()
			.subscribe(
				productList -> productList.forEach(
					product -> System.out.println(product.getName())
				),
				error -> System.out.println(error.getMessage())
		);

	}
}
