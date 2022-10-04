package java11_pruebas.pruebas;

import java.util.function.Function;

@FunctionalInterface
interface Funcion {
	int sumaUno(int a);

	// int sumaUno2(int a);
	default double getTemperature() {
		return 10.0;
	}

	static int getJumpHeight() {
		return 8;
	}

	private void checkTime(int hour) {
		if (hour > 17) {
			System.out.println("You're late!");
		} else {
			System.out.println("You have " + (17 - hour) + " hours left " + "to make the appointment");
		}
	}

	private static void breathe(String type) {
		System.out.println("Inhale");
		System.out.println("Performing stroke: " + type);
		System.out.println("Exhale");
	}

}

interface Funcion2<T, R> {
	R aplicar(T a);
}

public class RepasoLambdas {

	public static void main(String[] args) {
		Funcion fnAnonima = new Funcion() {
			public int sumaUno(int a) {
				return a + 1;
			}
		};
		Funcion fn = x -> x + 1;
		Funcion fnAnonima3 = (int a) -> {
			return a + 1;
		};
		int suma = fn.sumaUno(3);
		int suma2 = fnAnonima.sumaUno(4);
		int suma3 = fnAnonima3.sumaUno(5);
		System.out.println(suma);
		System.out.println(suma2);
		System.out.println(suma3);

		Funcion2<Integer, String> fn1 = x -> "" + (x + 1);
		String cadena1 = fn1.aplicar(3);
		System.out.println(cadena1);

		Function<Integer, String> fn2 = x -> "" + (x + 1);
		String cadena2 = fn2.apply(3);
		System.out.println(cadena2);

	}
}
