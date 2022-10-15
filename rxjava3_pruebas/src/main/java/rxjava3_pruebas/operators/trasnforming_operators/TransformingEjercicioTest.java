package rxjava3_pruebas.operators.trasnforming_operators;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class TransformingEjercicioTest {

	public static void main(String[] args) {
		Observable<Product> productsObservable = Observable.create(
			emmiter -> {
				List<Product> products = Product.getData();
				for (Product product : products) {
					emmiter.onNext(product);
				}
				emmiter.onComplete();
			}	
		);
		Product productInit = new Product();
		productInit.setSalesPrice(BigDecimal.ZERO);
		Double valorInicial = 0.0;
		Observable<Double> doubleObservable = productsObservable
				.filter(product -> product.getIsActive().equals(1)
												&& product.getSalesPrice().compareTo(new BigDecimal(30.00)) > 0)
				.scan(valorInicial, 
						(valorAnterior, productoActual) -> {
							Double sumaPrecios = valorAnterior + productoActual.getSalesPrice().doubleValue();
							productoActual.setSalesPrice(new BigDecimal(sumaPrecios));
							return sumaPrecios;
						}
					);
		doubleObservable.subscribe(System.out::println);
	}

}
