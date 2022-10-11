package java11_pruebas.pruebas.patron_observer;

import java.util.Observable;

public class Periodico extends Observable{
	String ultimoTitular = "";
	public void agregarTitular(String titular) {
		this.ultimoTitular = titular;
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getUltimoTitular() {
		return ultimoTitular;
	}
}
