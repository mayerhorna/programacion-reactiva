package rxjava3_pruebas.operators.trasnforming_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class ScanTest {
	public static void main(String[] args) {
		List<Product> products = Product.getData();
		Observable<Product> productsObservable = Observable.fromIterable(products);
		productsObservable
			.scan(
				(productoAnterior, producto) 
					-> {
						producto.setRowNum(productoAnterior.getRowNum() + 1);
						return producto;
					}
			)
			.subscribe(
				producto -> System.out.println(producto.getRowNum() +  ": " + producto.getName()),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);
	}
}
