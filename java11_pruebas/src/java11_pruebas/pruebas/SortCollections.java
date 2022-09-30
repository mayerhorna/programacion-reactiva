package java11_pruebas.pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DVDInfo implements Comparable<DVDInfo>{
	private String title;
	private String genre;
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }

	public int compareTo(DVDInfo d) {
		return this.title.compareTo(d.getTitle());
	}
	
	@Override
	public String toString() {
		return "{title : " + title + ", genre: "+genre+"}";
	}
}

class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
		return one.getGenre().compareTo(two.getGenre());
	}
}


public class SortCollections {

	public static void main(String[] args) {
		List<String> stuff = new ArrayList<String>();
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // #2
		System.out.println("sorted " + stuff);
		
		
		List<DVDInfo> dvdList = new ArrayList<DVDInfo>();
		DVDInfo info1 = new DVDInfo();
		info1.setTitle("Peli 1");
		info1.setGenre("Drama");
		DVDInfo info3 = new DVDInfo();
		info3.setTitle("Peli 4");
		info3.setGenre("Suspenso");
		DVDInfo info2 = new DVDInfo();
		info2.setTitle("Peli 2");
		info2.setGenre("Accion");
		dvdList.add(info3);
		dvdList.add(info1);
		dvdList.add(info2);
		System.out.println("unsorted " + dvdList);
		Collections.sort(dvdList);
		System.out.println("sorted title " + dvdList);
		
		Collections.sort(dvdList, new GenreSort());
		System.out.println("sorted genre: " + dvdList);
		
		
		//Busquedas:
		//Por defecto usando comparable
		DVDInfo infoToSearch = new DVDInfo();
		infoToSearch.setTitle("Peli 4");
		infoToSearch.setGenre("Accion");
		Collections.sort(dvdList);
		System.out.println("lista ordenada por titulo" + dvdList);
		int ubicacion = Collections.binarySearch(dvdList, infoToSearch);
		System.out.println(ubicacion);
		
		//Por comparator
		Collections.sort(dvdList, new GenreSort());
		System.out.println("lista ordenada por genero" + dvdList);
		int ubicacionPorGenero = Collections.binarySearch(dvdList, infoToSearch, new GenreSort());
		System.out.println(ubicacionPorGenero);
	}
}
