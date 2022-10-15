package rxjava3_pruebas.operators.trasnforming_operators;

import io.reactivex.rxjava3.core.Observable;

public class BufferTest {

	public static void main(String[] args) {
		Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7  );
		integerObservable
			.buffer(3)
			.subscribe( 
					integers -> {
						System.out.println("Buffer onNext");
						integers.forEach(num -> System.out.println("Buffer item-> " + num));
					}
			);

	}

}
