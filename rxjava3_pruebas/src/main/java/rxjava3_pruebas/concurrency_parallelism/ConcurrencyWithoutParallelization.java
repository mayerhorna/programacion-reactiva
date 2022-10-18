package rxjava3_pruebas.concurrency_parallelism;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyWithoutParallelization {
	public static void main(String[] args) {
	       Observable.range(1,10)
	               .map(number -> slowCalculation(number))
	               .subscribe(resultNumber -> System.out.println("Recibido " + resultNumber + " "
	                       + LocalTime.now()));
	}
	
	public static <T> T slowCalculation(T value) {
	    try { 
	    	Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
	    }catch(InterruptedException e){
	    	
	    }
	    return value;
	}
	   
}
