package java11_pruebas.pruebas.asincrono.streams_paralelos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamParalelos { 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List.of(4,1, 5, 3)
			.parallelStream()
			.map(w -> doWork(w))
			.sorted()
			.forEachOrdered(s -> System.out.print(s + " "));
		System.out.println();
		var timeTaken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time: " + timeTaken + " seconds");
		
		//Stream.of
		//reduce
		System.out.println(
				List.of('w', 'o', 'l', 'f')
				   		.parallelStream()                                   
				   		.reduce("",
				 			(cadenaAnterior, cadenaActual) -> cadenaAnterior + cadenaActual, 
				      		(cadanaFinalGrupoAnterior,cadanaFinalGrupoSiguiente) -> cadanaFinalGrupoAnterior + cadanaFinalGrupoSiguiente
				)
		);  // wol
		String sql = "SELECT * ";
		sql += "TABLA";
		sql += "TABLA";
		sql += "TABLA";
		sql += "TABLA";
		
		StringBuilder sbl = new StringBuilder();
		sbl.append("SELECT ..");
		System.out.println("COLLECT CON STREAMBUILDER");
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		StringBuilder set = stream
				.collect(
						() -> new StringBuilder(),
						(sbl1, cadena) -> sbl1.append(cadena),
						(sbuilder1, sbuilder2) -> sbuilder1.append(sbuilder2)
				);
		System.out.println(set.toString());
		
		Stream<String> stream2 = Stream.of("w", "o", "l", "f", "o").parallel();
		SortedSet<String> set2 = stream2
				.collect(ConcurrentSkipListSet::new,
						Set::add,
						Set::addAll);
		System.out.println(set2); 
		
		//
		{
		var ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(", "));
		System.out.println(result); // lions, tigers, bears
		
		var ohMy2 = Stream.of("lions", "tigers", "bears");
		Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
		System.out.println(result2); // 5.333333333333333
		
		var ohMy3 = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map = ohMy3.collect(
		   Collectors.toMap(s -> s, String::length));
		System.out.println(map); // {lions=5, bears=5, tigers=6}
		}
		{
		var ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map = ohMy.collect(
												Collectors.groupingBy(String::length)
		);
		System.out.println(map);    // {5=[lions, bears], 6=[tigers]}

		}
		{

			var ohMy = Stream.of("lions", "tigers", "bears", "tigers");
			TreeMap<Integer, Set<String>> map = ohMy.collect(
			   Collectors.groupingBy(
			      String::length, 
			      TreeMap::new, 
			      Collectors.toSet()));
			System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		}
		
		{
			var ohMy = Stream.of("lions", "tigers", "bears");
			Map<Boolean, List<String>> map = ohMy.collect(
			   Collectors.partitioningBy(s -> s.length() <= 5));
			System.out.println(map); //{false=[tigers], true=[lions, bears]}

		}
		
		{
			//Ejemplo con Set
			var ohMy = Stream.of("lions", "tigers", "bears");
			Map<Boolean, Set<String>> map = ohMy.collect(
			   Collectors.partitioningBy(
			      s -> s.length() <= 7, 
			      Collectors.toSet()));
			System.out.println(map); //{false=[], true=[lions, tigers, bears]}
			
		}
		
		{
			var ohMy = Stream.of("lions", "tigers", "bears");
			Map<Integer, Optional<Character>> map = ohMy.collect(
			   Collectors.groupingBy(
			      String::length,
			      Collectors.mapping(
			         s -> s.charAt(0), 
			         Collectors.minBy((a, b) -> a -b))));
			System.out.println(map);    // {5=Optional[b], 6=Optional[t]}
		}
		
	}

	private static int doWork(int input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return input;
	}

}
