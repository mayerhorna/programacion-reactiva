package java11_pruebas.pruebas.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsOperacionesIntermediasTest {

	public static void main(String[] args) {
		Stream stream = Stream.of("a", "b", "c","d");
		//filter:
		Stream<String> s = Stream.of("monkey", "gorilla", "mono");
			s.peek(e -> System.out.println("1:" + e))
				.filter(x -> x.startsWith("m"))
				   .peek(e2 -> System.out.println("2:" + e2))
					   .forEach(System.out::println); // monkey

			
		//distinct
		System.out.println("distinct");
		Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
			s2.distinct()
			   .forEach(System.out::println); // duck goose
			 
		//limit
		System.out.println("distinct");	
		Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
			s3.skip(5)
			   .limit(2)
			    .forEach(System.out::println); // 6 7
		 
		//map
		System.out.println("map");	
		Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
			s4.map(string -> string.length()) 
				.map(numero -> numero + 5)
					.forEach(System.out::println); // 6 7 6    11   12   11
			
		//flatMap
		System.out.println("flatMap:");	
		List<String> zero = List.of();
		var one = List.of("Bonobo");
		var two = List.of("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
			 
		animals.flatMap(m -> m.stream()).forEach(System.out::println);
		
		//Sorted
		System.out.println("sorted:");	
		Stream<String> s5 = Stream.of("b", "a", "c", "u","s");
			s5.sorted( (cadena1, cadena2) -> cadena2.compareTo(cadena1) )  //a b c s u
				.forEach(System.out::println); 
		/*
		Stream<Integer> s6 = Stream.iterate(1, n -> n + 1);
			s6.sorted()   
				.forEach(System.out::println);
		*/
	}
	/*"1:monkey"
	"1:gorilla"
	"1:mono"
	"2:monkey"
	"2:mono"
	"3:monkey"
	"3:mono"*/
	/*
	"1:monkey"
	"2:monkey"
	*/
	
	public Integer sumarDobles(String ... nums) {
		  return List.of(nums)
			.stream()
			    .map(Integer::valueOf)
					.map(numero -> numero * 2)  
		                  .reduce(0
					, (acumulador, valor) -> acumulador + valor );
		}
}
