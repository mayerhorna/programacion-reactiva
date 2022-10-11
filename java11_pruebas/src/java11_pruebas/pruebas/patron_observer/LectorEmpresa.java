package java11_pruebas.pruebas.patron_observer;

import java.util.Observable;
import java.util.Observer;

public class LectorEmpresa implements Observer{
	
	private Periodico periodico;
	
	public void setPeriodico(Periodico periodico) {
		this.periodico = periodico;
		this.periodico.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Periodico periodico = (Periodico)o;
		System.out.println("Lector Empresa: " + periodico.getUltimoTitular());
	}

}
