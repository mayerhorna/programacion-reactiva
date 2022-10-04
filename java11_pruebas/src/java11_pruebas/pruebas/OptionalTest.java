package java11_pruebas.pruebas;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		/*Double promedio = promediarNumeros();
		if (promedio != null) {
			System.out.println(promedio);
		} else {
			System.out.println("");
		}
		*/
		System.out.println(average(90, 100)); // Optional[95.0]
		System.out.println(average());        // Optional.empty
		
		Optional<Double> opt = average(90, 100);
		/*	if (opt.isPresent())
			System.out.println(opt.get()); // 95.0
	 	*/
		opt.ifPresent(System.out::println);
	}

	private static Double promediarNumeros(int... numeros) {// VARG-ARGS
		Double suma = 0.0;
		for (int numero : numeros) {
			suma += numero;
		}
		Double promedio = suma / numeros.length;
		return promedio;
	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}

}
