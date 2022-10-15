package rxjava3_pruebas.operators.trasnforming_operators;

import java.util.List;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class MapTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
		//Stream.of("").map(string -> new Integer(2)).map
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.map(product -> product.getName())
			.subscribe(
				name -> System.out.println(name),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);
	}

}
