package rxjava3_pruebas.operators.combining_operators;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;
import rxjava3_pruebas.data.ProductStock;

public class ZipWithTest {

	public static void main(String[] args) {
		Observable<Product> productsObservable = Observable.fromIterable(Product.getData()); 
		Observable<ProductStock> stockObservable = Observable.fromIterable(ProductStock.getData());
		productsObservable
			.zipWith(
				stockObservable, 
				(product, productStock) -> {
					productStock.setProduct(product);
					return productStock;
				}
			)
			.subscribe(
				productStock -> System.out.println(productStock.getProduct() + " (Stock Actual: %s)".formatted(productStock.getQuantity())),
				error -> System.out.println(error.getMessage())
		);

	}

}
