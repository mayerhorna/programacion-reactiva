package rxjava3_pruebas.custom_operators;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.FlowableOperator;

public class ToCleanString implements FlowableOperator<String, String> {
	public static ToCleanString toCleanString() {
		return new ToCleanString();
	}

	private ToCleanString() {
		super();
	}

	public Subscriber<? super String> apply(Subscriber<? super String> subscriber) throws Throwable {
		return new Subscriber<String>() {
			public void onSubscribe(Subscription subscription) {
				subscriber.onSubscribe(subscription);
			}

			public void onNext(String item) { // elimina caracteres distintos a numeros y letras del abecedario
				final String result = item.replaceAll("[^A-Za-z0-9]", "");
				subscriber.onNext(result);
			}

			public void onError(Throwable throwable) {
				subscriber.onError(throwable);
			}

			public void onComplete() {
				subscriber.onComplete();
			}
		};
	}
}