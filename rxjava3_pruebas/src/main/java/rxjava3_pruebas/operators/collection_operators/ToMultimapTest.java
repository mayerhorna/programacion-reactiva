package rxjava3_pruebas.operators.collection_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ToMultimapTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.toMultimap( 
				product -> product.getProductType().getName(),
				product -> product.getName()
			)
			.subscribe(
				productsAsMap ->   { 
					productsAsMap.forEach(
						(productTypeName, productNameList) -> { 
							System.out.println(productTypeName);
							System.out.println("===================");
							productNameList.forEach(System.out::println);
							System.out.println();
						}
					);
				},
				error -> System.out.println(error.getMessage()) 
			);

	}
}
