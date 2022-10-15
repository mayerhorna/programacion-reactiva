package rxjava3_pruebas.operators.reducing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ReduceWithSupplierTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.reduceWith(
				() -> Integer.valueOf(0), 
				(acumulador, product) 
					-> product.getIsActive().equals(1) ? acumulador + 1 : acumulador
			)
			.subscribe(
				totalActiveProducts -> System.out.println(totalActiveProducts),
				error -> System.out.println(error.getMessage()) 
			);

	}
}
