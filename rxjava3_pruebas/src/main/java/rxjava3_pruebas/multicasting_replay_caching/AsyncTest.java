package rxjava3_pruebas.multicasting_replay_caching;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.Subject;
import rxjava3_pruebas.data.Product;

public class AsyncTest {

	public static void main(String[] args) {
		Subject<Product> productSubject = AsyncSubject.create();
		productSubject.subscribe(
			product -> System.out.println("O1:" + product.getName())
		);

		productSubject.onNext(new Product(1L,"Panadol"));
		productSubject.onNext(new Product(2L,"Amoxixilina"));

		productSubject.subscribe(
			product -> System.out.println("O2:" + product.getName())
		);

		productSubject.onNext(new Product(3L,"Tramadol"));
		productSubject.onNext(new Product(4L,"Diclofenaco"));
		 
		productSubject.onComplete();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

	}

}
