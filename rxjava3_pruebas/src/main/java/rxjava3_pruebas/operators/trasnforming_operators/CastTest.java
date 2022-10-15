package rxjava3_pruebas.operators.trasnforming_operators;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class CastTest {

	public static void main(String[] args) {
		Object productPolimorfico = new Product("TRAMADOL 500 MB Tab");
		Observable<Object> personasObservable = 
				Observable.just(
					new Product("AMOXICILINA 500 MB Tab"), 
					new String("PANADOL"), 
					productPolimorfico,
					new Product("TRUSOMIDA 2% Solución")
				);
			personasObservable
				.filter((Object obj) -> Product.class.isInstance(obj))
				.cast(Product.class)
				.subscribe(
						product -> System.out.println(product.getName()),
						error -> System.out.println(error.getMessage()),
						() -> System.out.println("completo")
				);

	}

}
