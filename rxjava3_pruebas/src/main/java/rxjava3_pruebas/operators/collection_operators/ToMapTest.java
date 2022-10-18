package rxjava3_pruebas.operators.collection_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ToMapTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.toMap(
				product -> product.getTb_product_id(),
				product -> product.getName()
			)
			.subscribe(
				productsAsMap ->   System.out.println(productsAsMap),
				error -> System.out.println(error.getMessage()) 
			);
	}
}
