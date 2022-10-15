package rxjava3_pruebas.operators.reducing_operators;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ReduceWithSeedTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable.reduce(
				BigDecimal.ZERO, 
				(acumulador, product) -> acumulador.add(product.getSalesPrice())
			)
			.subscribe(
				totalPrice -> System.out.println(totalPrice.doubleValue()),
				error -> System.out.println(error.getMessage()) 
			);

	}

}
