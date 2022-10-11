package java11_pruebas.pruebas.asincrono;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Pregunta18ExecutorsAll {
	public static void main(String[] args) {
		String cadenaFinal = concatenarAsincrono(() -> "Hola", () -> "Mundo", () -> "!");
		System.out.println(cadenaFinal);
	}
	
	public static String concatenarAsincrono(Callable<String> ... tasksToGetStrings) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<String>> list = null;
		try {
			list = service.invokeAll(
					List.of(tasksToGetStrings)
			);
		} catch (InterruptedException e) {
		}
		String cadenaFinal = list.stream()
			.map( future -> { 
				try {
					return future.get();
				} catch (Exception e) {
				}
				return "";
			}).collect(Collectors.joining(" "));
		return cadenaFinal;
	}

}	
