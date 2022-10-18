package rxjava3_pruebas.operators.combining_operators;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;
import rxjava3_pruebas.data.ProductStock;

public class ZipTest {

	public static void main(String[] args) {
		Product productToSearch = new Product(6618L);
		Observable<Product> productsObservable  = Observable.fromCallable(()-> Product.find(productToSearch)); 
		Observable<ProductStock> stockObservable  = Observable.fromCallable(()->ProductStock.findByProduct(productToSearch));
		Observable
			.zip(productsObservable, stockObservable, 
				(product, productStock) -> {
					productStock.setProduct(product);
					return productStock;
				}
			)
			.subscribe(
				productStock -> System.out.println(productStock.getProduct().getName() + " (Stock Actual: %s)".formatted(productStock.getQuantity())),
				error -> System.out.println(error.getMessage())
		);

	}

}
