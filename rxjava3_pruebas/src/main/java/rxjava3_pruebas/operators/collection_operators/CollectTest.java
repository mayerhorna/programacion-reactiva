package rxjava3_pruebas.operators.collection_operators;

import java.util.HashSet;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class CollectTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.collect( 
				() -> new HashSet<String>(),
				(productsHashSet, product) 
					-> productsHashSet.add(product.getProductType().getName())
			)
			.subscribe(
				productsHashSet ->   System.out.println(productsHashSet),
				error -> System.out.println(error.getMessage()) 
			);

	}
}
