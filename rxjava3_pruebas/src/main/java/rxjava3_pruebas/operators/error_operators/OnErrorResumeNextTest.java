package rxjava3_pruebas.operators.error_operators;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class OnErrorResumeNextTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		var altObservable = Observable.just(new Product("-")).repeat(3);
		productsObservable 
			.filter(product -> product.getIsActive().equals(1) 
				&& product.getSalesPrice().compareTo(new BigDecimal(30.00)) > 0)
			.onErrorResumeNext(e -> altObservable)
			.subscribe(
			System.out::println,
				error -> System.out.println(error.getMessage())
			);

	}

}
