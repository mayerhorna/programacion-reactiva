package rxjava3_pruebas.operators.collection_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ToSortedListTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.toSortedList( (product1, product2) 
				-> product2.getName().compareTo(product1.getName())
			)
			.subscribe(
				productList -> productList.forEach(
					product -> System.out.println(product.getName())
				),
				error -> System.out.println(error.getMessage()) 
			);

	}

}
