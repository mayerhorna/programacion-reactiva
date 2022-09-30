package java11_pruebas.pruebas;

import java.util.ArrayList;
import java.util.List;

interface AbstractDao<T>{
	public T get(Long id) ;
	public void save(T t) ;
	public void update(T t) ;
}

class ClienteDao implements AbstractDao<Cliente>{

	@Override
	public Cliente get(Long id) {
		return null;
	}

	@Override
	public void save(Cliente t) {
		
	}

	@Override
	public void update(Cliente t) {
		
	}
	
}

class MiLista<T /*extends Cliente*/>{
	private List<T> lista = new ArrayList<T>();
	
	public void agregar(T t) {
		lista.add(t);
	}
	
	public T obtener(int indice) {
		return lista.get(indice);
	}
}
class Cliente{}
class SubCliente extends Cliente{}
public class GenericTest {
	public static void main(String[] args) {
		MiLista<String> miLista = new MiLista<String>();
		miLista.agregar("a");
		miLista.agregar("b");
		System.out.println(miLista.obtener(1));
		
		ArrayList<?> strings = new ArrayList<String>();
		//strings.add("a");
		//strings.add("b");
		for (Object object : strings) {
			
		}
	}
}
