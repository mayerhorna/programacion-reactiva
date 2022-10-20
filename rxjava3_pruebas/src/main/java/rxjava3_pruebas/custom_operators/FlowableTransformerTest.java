package rxjava3_pruebas.custom_operators;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;

public class FlowableTransformerTest {
	public static void main(String[] args) {
		//Letras
		Flowable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
		        .compose(concatenateAsStrings())
		        .subscribe(System.out::println);

		//Numeros
		Flowable.range(1, 15)
			    .compose(concatenateAsStrings())
		        .subscribe(System.out::println);
			}

		public static <T> FlowableTransformer<T, String> concatenateAsStrings() {
		   	   return flowable -> 
		    		 flowable.collect(StringBuilder::new, (sb, v) -> sb.append(String.format("%s ", v))) 
		    		.map(StringBuilder::toString)
		            	.toFlowable();    
		}

}
