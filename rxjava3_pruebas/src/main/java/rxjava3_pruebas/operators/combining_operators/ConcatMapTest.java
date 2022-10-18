package rxjava3_pruebas.operators.combining_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ConcatMapTest {

	public static void main(String[] args) {
		List<Product> products1 = Product.getData();
		List<Product> products2 = Product.getData();
		Observable<List<Product>> personasObservable = Observable.fromArray(products1,products2);
		personasObservable
			.concatMap(productList -> Observable.fromIterable(productList))
			.map(product -> product.getName())
			.subscribe(
				name -> System.out.println(name),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);

	}

}
