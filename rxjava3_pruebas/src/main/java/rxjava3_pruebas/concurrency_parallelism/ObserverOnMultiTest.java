package rxjava3_pruebas.concurrency_parallelism;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserverOnMultiTest {
	public static void main(String[] args) {
		Observable.just("JUAN;10;20;10", "MARIA;20;10;10", "VICTOR;10;10;20")
        .subscribeOn(Schedulers.io())
        .flatMap(trama -> Observable.fromArray(trama.split(";")))
        .doOnNext(trama -> System.out.println("Cadena separada " + trama + " en hilo "
                + Thread.currentThread().getName()))
        //Los recibe en un Computation Scheduler
        .observeOn(Schedulers.computation())
        .filter(cadenaSeparada -> cadenaSeparada.matches("[0-9]+"))
        .map(Integer::valueOf)
        .reduce((total, next) -> total + next)
        .doOnSuccess(suma -> System.out.println("Suma calculada " + suma + " en hilo "
                + Thread.currentThread().getName()))
        
        //Se vuelve al Scheduler IO
        .observeOn(Schedulers.io())
        .map(suma -> suma.toString())
        .doOnSuccess(sumaAsString -> System.out.println("Escribiendo " + sumaAsString + " a archivo en hilo "
                + Thread.currentThread().getName()))
        .subscribe(sumaAsString -> write(sumaAsString,"D:/tmp/SUMA_TRAMA.txt"));
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
	}
		
}
	
	public static void write(String text, String path) {
        BufferedWriter writer = null;
        try {
            File file = new File(path);
            writer = new BufferedWriter(new FileWriter(file));
            writer.append(text);
        } catch (Exception e) {
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
