package rxjava3_pruebas.custom_operators;

import io.reactivex.rxjava3.core.Flowable;

public class FlowableTransformerToCleanStringOperatorTest {
	public static void main(String[] args) {
		Flowable.just("elniño123", "patrón89", "a_l_t_o", "o&a74", "la.empresa")
       			.lift(ToCleanString.toCleanString())
        		.subscribe(System.out::println);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
