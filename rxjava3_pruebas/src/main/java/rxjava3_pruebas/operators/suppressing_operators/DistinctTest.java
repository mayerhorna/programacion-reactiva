package rxjava3_pruebas.operators.suppressing_operators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class DistinctTest {

	public static void main(String[] args) {
		/*
		Product product1 = new Product(1L);
		product1.setName("A");
		Product product2 = new Product(1L);
		product2.setName("0");
		
		Set<Product> products = new HashSet<>();
		products.add(product1);
		products.add(product2);
		System.out.println(products);
		*/
		//System.out.println(product1.equals(product2));
		//System.out.println("3".equals(new String("3")));
		///System.out.println("3" == new String("3"));
		 
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.distinct()
			.subscribe(
				product -> System.out.println(product.getName()),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);


	}
}
