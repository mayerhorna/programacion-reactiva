package rxjava3_pruebas.operators.reducing_operators;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class AllTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable.all(product -> product.getSalesPrice().compareTo(BigDecimal.ZERO) > 0)
		.subscribe(
			allAmountsGreaterThanZero -> System.out.println(allAmountsGreaterThanZero),
			error -> System.out.println(error.getMessage()) 
		);

	}
}
