package rxjava3_pruebas.custom_operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class ObservableTransformerJoinStringTest {
	public static void main(String[] args) {
		//Letras
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
		        .compose(joinToString(";"))
		        .subscribe(System.out::println);
		}
	
		public static ObservableTransformer<String, String> joinToString(String separator) {
		       return observable -> 
		    observable.collect(StringBuilder::new, (b, s) -> {
		    if(b.length() == 0) {
		    	b.append(s);
		    }else {
		    	b.append(separator).append(s);
		    }
		    })
		    .map(StringBuilder::toString)
		    .toObservable();    
		   }
		}
