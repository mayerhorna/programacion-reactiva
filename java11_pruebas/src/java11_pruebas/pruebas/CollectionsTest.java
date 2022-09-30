package java11_pruebas.pruebas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		{	System.out.println("ArrayList");
			List<String> strings = new ArrayList<String>();
			strings.add("a");
			strings.add("a");
			strings.add("b");
			String primerElemento = strings.get(0);
			for (String string : strings) {
				System.out.println(string);
			}
		}
		{	System.out.println("LinkedList");
			LinkedList<String> strings = new LinkedList<String>();
			strings.add("a");
			strings.add("a");
			strings.add("b");
			String primerElemento = strings.get(0);
			for (String string : strings) {
				System.out.println(string);
			}
			strings.poll();
		}
		
		{	System.out.println("HashSet");
			HashSet<String> strings = new HashSet<String>();
			strings.add("a");
			strings.add(new String("a"));
			strings.add("b");
			//strings.get
			for (String string : strings) {
				System.out.println(string);
			}
		}
		
		{
			System.out.println("Maps:");
			HashMap<String, String> map = new HashMap<>();
			map.put("dni", "44032588");
			map.put("nombre", "Juan Perez");
			map.put("direccion", "Av. 2343223");
			for(String key : map.keySet()) {
				System.out.println(key + " : " +   map.get(key));
			}
		}
		
		{
			System.out.println("");
			System.out.println("LinkedHashMap:");
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			map.put("dni", "44032588");
			map.put("nombre", "Juan Perez");
			map.put("direccion", "Av. 2343223");
			for(String key : map.keySet()) {
				System.out.println(key + " : " +   map.get(key));
			}
		}
		
		Object o = new String("a");
		
		System.out.println("a" == new String("a"));
		System.out.println("a".equals(new String(new String("a"))));
		System.out.println(new Long(1L).equals(1L));
	}

}
