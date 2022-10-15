package rxjava3_pruebas.operators.trasnforming_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class GroupByTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.groupBy(
				product -> product.getProductType().getName(),
				product -> product
			)
		    .subscribe(
		   		group -> {
		    			System.out.println("=======GRUPO======: " + group.getKey());
		    			group.subscribe(product -> System.out.println(product.getCode() + ": " + product.getName()));
		    		}
		    	);

	}
}
