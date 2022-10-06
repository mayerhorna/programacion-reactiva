package java11_pruebas.pruebas.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		//stream finitos
		Stream<String> empty = Stream.empty();          // count = 0
		Stream<Integer> singleElement = Stream.of(1);   // count = 1
		Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
		fromArray.forEach(System.out::println);
		
		var list = List.of("a", "b", "c");
		Stream<String> fromList = list.stream();
		fromList.forEach(System.out::println);
		 
		//streams infinitos:
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
		Stream<Integer> oddNumberUnder100 = Stream.iterate(
				1,             // inicio
				   			n -> n < 100,  // Predicate para especificar cuando termina
				   			n -> n + 2);
		//oddNumbers.parallel().forEach(System.out::println);
	 
		
		
		var list2 = List.of("a", "b", "c");
		Stream<String> fromListParallel = list2.parallelStream();
		
		Stream<Integer> integerSource = Stream.of(1, 2, 3);
		//integerSource.map(null).map(null).count();
		long cantidad = integerSource.count();
		System.out.println("operaciones terminales: ");
		System.out.println(cantidad);
		
		Stream<String> s0 = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s0.min((s1, s2) -> s1.length()-s2.length());
		min.ifPresent(System.out::println); // ape
		
		
		//Operaciones terminales: reduce
		Stream<Integer> stream = Stream.of(3, 5, 6);
		System.out.println(stream.reduce(1, (a, b) -> {
				return a*b;
			}
		));  // 90

		Stream<String> stream2 = Stream.of("w", "o", "l", "f!");
		int length = stream2.parallel().reduce(0, (i, s) -> {
			return i+s.length();
		}
		, (a, b) -> { 
			return a+b;	
		});
		System.out.println(length); // 5
		
		/*
		//collect:
		Stream<String> stream3 = Stream.of("w", "o", "l", "f");
		 
		StringBuilder word = stream3.collect(
	  		StringBuilder::new,
	   	StringBuilder::append, 
	   	StringBuilder::append);
	 
		System.out.println(word); // wolf 
		*/ 
	}

}
