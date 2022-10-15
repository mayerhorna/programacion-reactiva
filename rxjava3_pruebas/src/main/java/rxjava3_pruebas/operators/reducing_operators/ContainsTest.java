package rxjava3_pruebas.operators.reducing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ContainsTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		Product productToSearch = new Product(15411L);
		productsObservable.contains(productToSearch)
		.subscribe(
			containsProduct -> System.out.println(containsProduct),
			error -> System.out.println(error.getMessage()) 
		);

	}

}
