package rxjava3_pruebas.concurrency_parallelism;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserverOnTest {

	public static void main(String[] args) {
		Observable.just("JUAN;10;20;10", "MARIA;20;10;10", "VICTOR;10;10;20")
        .subscribeOn(Schedulers.io())
        .flatMap(s -> Observable.fromArray(s.split(";")))

        //Los recibe en un Computation Scheduler
        .observeOn(Schedulers.computation())
        .filter(s -> s.matches("[0-9]+"))
        .map(Integer::valueOf)
        .reduce((total, next) -> total + next)
        .subscribe(i -> System.out.println("Recibido " + i + " en hilo "
                + Thread.currentThread().getName()));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

	}

}
