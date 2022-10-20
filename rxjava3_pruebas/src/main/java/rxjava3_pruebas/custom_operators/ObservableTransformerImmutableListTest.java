package rxjava3_pruebas.custom_operators;

import com.google.common.collect.ImmutableList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class ObservableTransformerImmutableListTest {
	public static void main(String[] args) {
		//Letras
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
		        .compose(toImmutableList())
		        .subscribe(System.out::println);

		//Numeros
		Observable.range(1, 15)
		        .compose(toImmutableList())
		        .subscribe(System.out::println);

		}
		public static <T> ObservableTransformer<T, ImmutableList<T>> toImmutableList() {
		  return observable -> 
		    observable.collect(ImmutableList::<T> builder, ImmutableList.Builder::add) 
		    .map(ImmutableList.Builder::build)
		            .toObservable();    
		}
}

