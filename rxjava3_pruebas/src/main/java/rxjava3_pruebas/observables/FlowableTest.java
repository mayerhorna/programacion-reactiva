package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import rxjava3_pruebas.data.Product;

public class FlowableTest {

	public static void main(String[] args) {
		//List<Produ.. Product.getData();
			Flowable<Product> productFlowable = Flowable.create(
				emmiter -> { 
					for(int i = 0; i < 10000 ; i++) {
						emmiter.onNext(new Product(i + ": AMOXICILINA 500 mg Tableta"));
					}
					emmiter.onComplete();
				},
				BackpressureStrategy.ERROR
			);
			productFlowable.subscribe(
				product -> System.out.println(product.getName()),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);
			
	}

}
