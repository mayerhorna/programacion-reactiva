package rxjava3_pruebas.operators.reducing_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ReduceWithBiFunction {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.reduce(
				(backProduct, currentProduct) -> { 
					currentProduct.setSalesPrice(
						backProduct.getSalesPrice().add(currentProduct.getSalesPrice())
				    );
					return currentProduct;
			   	}
			)
			.subscribe(
				accumulatedProduct 
					-> System.out.println(accumulatedProduct.getSalesPrice().doubleValue()),
				error -> System.out.println(error.getMessage()) 
			);

	}
}
