package rxjava3_pruebas.custom_operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class ObservableTransformerTest {

	public static void main(String[] args) {
		//Letras
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
		        .compose(concatenateAsStrings())
		        .subscribe(System.out::println);

		//Numeros
		Observable.range(1, 15)
				.compose(concatenateAsStrings())
		        .subscribe(System.out::println);

	}
	
	public static <T> ObservableTransformer<T, String> concatenateAsStrings() {
   	    return observable -> 
    		observable.collect(StringBuilder::new, (sb, v) -> sb.append(String.format("%s ", v))) 
    		.map(StringBuilder::toString)
            	.toObservable();    
	}


}
