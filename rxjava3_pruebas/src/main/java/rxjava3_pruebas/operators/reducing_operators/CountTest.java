package rxjava3_pruebas.operators.reducing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class CountTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable.count()
			.subscribe(
				countValue -> System.out.println(countValue),
				error -> System.out.println(error.getMessage()) 
			);

	}

}
