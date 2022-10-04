package java11_pruebas.pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String toString() {
		return species;
	}
}

class TraditionalSearch {
	public static void main(String[] args) {
		// list of animals
		var animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, true));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));

		// Pass lambda that does check
		Predicate<Animal> checker = (Animal a) -> {
			return a.canSwim();
		};
		print(animals, checker);
	}

	private static void print(List<Animal> animals, Predicate<Animal> checker) {
		for (Animal animal : animals) {
			if (checker.test(animal))
				System.out.print(animal + " ");
		}
	}
}

public class IntefacesFuncionlesTest {
	public static void main(String[] args) {

	}
}

class Crow {
	private String color;

	public void caw(final String name) {
		String volume = "loudly";
		color = "allowed";
		//volume = "afdas";
		//name = "not allowed";
		//volume = "not allowed";
		Predicate<String> p = s -> (name + volume + color).length() == 9; // NO COMPILA
	}
}
class Wolf{}
interface Test1{
	int aplicar(Wolf w, Object c);
}


class TestEjercicios{
	public static void main(String[] args) {
		Test1 t1 = (Wolf w, Object c) -> 39;
	}
}

interface LearnToSpeak{
	void print(String s);
}

class ReferenciaDeMetodos{
	public static void main(String[] args) {
		LearnToSpeak learner = s -> System.out.println(s);
		LearnToSpeak learner2 = System.out::println;
		learner.print("Hola Mundo");
		learner2.print("Hola Mundo 2");
		
		ExecuteSort<List<Integer>> lambda = x -> Collections.sort(x);
	    ExecuteSort<List<Integer>> methodRef = Collections::sort;
	    
	    //de una instancia en particular:
	    var str = "abc";
	    Predicate<String> lambda2 = s -> str.startsWith(s);

	    Predicate<String> methodRef2 = str::startsWith;
	    
	    //el parametro se determina en tiempo de ejecucion:
	    Predicate<String> lambda3 = s -> s.isEmpty();
	    Predicate<String> methodRef3 = String::isEmpty;
	    BiPredicate<String, String> lambda4 = (s, p) -> s.startsWith(p);
	    BiPredicate<String, String> methodRef4 = String::startsWith;
	    
	    
	    //constructores:
	    Supplier<List<String>> lambda5 = () -> new ArrayList();
	    Supplier<List<String>> methodRef5 = ArrayList::new;

	    Function<Integer, List<String>> lambda6 = x -> new ArrayList(x);
	    Function<Integer, List<String>> methodRef6 = ArrayList::new;
	    
	}
}

interface ExecuteSort<T>{
	void consume(T t);
}


//Interfaces funcionales del paquete java.util.function
class InterfazFuncionalPruebas{
	public static void main(String[] args) {
		//Ejemplo 1
		Supplier<StringBuilder> s2 = () -> new StringBuilder();
		Supplier<String> s1 = String::new;
		System.out.println(s1.get());
		System.out.println(s2.get());

		//Ejemplo 2
		Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
		ArrayList<String> listaLetras = s3.get();
		listaLetras.add("a");
		listaLetras.add("b");
		listaLetras.add("c");
		System.out.println(listaLetras);
		
		//listaLetras.forEach(System.out::println);
		//listaLetras.forEach(letra -> System.out.println(letra));
		listaLetras.forEach(letra -> {
			System.out.println(letra);
		});
		
		
		//Function
		Function<String, Integer> f2 = x -> x.length();
		Function<String, Integer> f1 = String::length;
		System.out.println(f2.apply("cluck")); // 5 
		System.out.println(f1.apply("cluck")); // 5

		//Ejemplo 2
		BiFunction<String, String, String> b1 = String::concat;
		BiFunction<String, String, String> b2 = 
		   (string, toAdd) -> string.concat(toAdd);
		System.out.println(b1.apply("baby ", "chick")); // baby chick
		System.out.println(b2.apply("baby ", "chick")); // baby chick
		
		//Unary y BinaryOperator
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		System.out.println(u1.apply("chirp"));  // CHIRP
		System.out.println(u2.apply("chirp"));  // CHIRP 


		//Ejemplo 2
		BinaryOperator<String> b1_ = String::concat;
		BinaryOperator<String> b2_ = (string, toAdd) -> string.concat(toAdd);
		System.out.println(b1_.apply("baby ", "chick")); // baby chick
		System.out.println(b2_.apply("baby ", "chick")); // baby chick



	}
}





