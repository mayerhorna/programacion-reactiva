package rxjava3_pruebas.operators.action_operators;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DoOnEachTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.filter(product -> product.getIsActive().equals(1) 
				&& product.getSalesPrice().compareTo(new BigDecimal(30.00)) > 0)
			.doOnEach(notification -> System.out.println("hubo error?: " + notification.isOnError()))
			.doOnEach(notification -> System.out.println("todo ok?: " + notification.isOnNext()))
			.map(product -> "-> ".concat(product.getCode()).concat(": ").concat(product.getName()))
			.subscribe(
				System.out::println 
			);

	}

}
