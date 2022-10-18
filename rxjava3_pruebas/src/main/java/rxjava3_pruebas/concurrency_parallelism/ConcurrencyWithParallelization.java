package rxjava3_pruebas.concurrency_parallelism;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ConcurrencyWithParallelization {
    public static void main(String[] args) {
        Observable.range(1,10)
         .flatMap(number -> Observable.just(number)
                  .subscribeOn(Schedulers.computation())
                  .map(numberToProccessInParallel -> slowCalculation(numberToProccessInParallel))
         )
         .subscribe(resultNumber -> System.out.println("Recibido " + resultNumber + " "
                 + LocalTime.now() + " en hilo "
                 + Thread.currentThread().getName()));
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
     }
     public static <T> T slowCalculation(T value) {
       try {
           Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
       }catch (InterruptedException e) {
       }
       return value;
     }
}
