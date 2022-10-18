package rxjava3_pruebas.operators.action_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DoOnErrorTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.doOnError((error)->System.out.println("fallo el origen: " + error.getMessage()))
		    .filter(product -> product.getIsActive().equals(1) 
		    		&& product.getSalesPrice().compareTo(null) > 0)
		    .doOnError((error)->System.out.println("fallo el filtro: " + error.getMessage()))
		    .map(product -> "-> ".concat(product.getCode()).concat(": ").concat(product.getName()))
		    .subscribe(
		    		System.out::println
		    );
	}

}
