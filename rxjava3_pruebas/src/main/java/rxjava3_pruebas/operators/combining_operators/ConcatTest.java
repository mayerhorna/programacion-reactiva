package rxjava3_pruebas.operators.combining_operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjava3_pruebas.data.Product;

public class ConcatTest {

	public static void main(String[] args) {
		List<Product> productsSource1 = Product.getData();
		List<Product> productsSource2 = Product.getData();
		Observable<Product> productsObservableSource1 = Observable.create(
		emmiter -> {
			for(Product product : productsSource1) {
				product.setName("1: " + product.getName());
				emmiter.onNext(product);
			}
			emmiter.onComplete();
		});

		Observable<Product> productsObservableSource2 = Observable.create(
		      emmiter -> {
			for(Product product : productsSource2) {
				product.setName("2: " + product.getName());
				emmiter.onNext(product);
			}
			emmiter.onComplete();
		      });
		productsObservableSource1 = productsObservableSource1.subscribeOn(Schedulers.newThread());
		productsObservableSource2 = productsObservableSource2.subscribeOn(Schedulers.newThread());
		Observable.concat(productsObservableSource1, productsObservableSource2)
		      .subscribe(
			System.out::println,
			error -> System.out.println(error.getMessage())
		);
		try {
		      Thread.sleep(10000);
		} catch (InterruptedException e) {
		      e.printStackTrace();
		}

	}

}
