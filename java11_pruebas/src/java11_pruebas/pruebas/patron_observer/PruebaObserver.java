package java11_pruebas.pruebas.patron_observer;

public class PruebaObserver {

	public static void main(String[] args) {
		Periodico periodico = new Periodico();
		LectorEmpresa lectorEmpresa = new LectorEmpresa();
		LectorPersona lectorPersona = new LectorPersona();
		lectorEmpresa.setPeriodico(periodico);
		lectorPersona.setPeriodico(periodico);
		
		periodico.agregarTitular("Graduados Java");
		periodico.agregarTitular("Graduados Scala");
		periodico.agregarTitular("Graduados JavaScript");
	}

}
