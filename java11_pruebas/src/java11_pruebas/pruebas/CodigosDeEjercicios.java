package java11_pruebas.pruebas;

interface Sumable {
	public static final String DB_NAME = "db_products";

	public abstract int sumaUno(int x);
}
class A{
	public void init() {
		
	}
}
class B extends A{
	@Override
	public void init() {
		
	}
}
public class CodigosDeEjercicios {

	public static void main(String[] args) {
		int resultado = sumaUnoUsandoClaseAnonima(5);
		System.out.println(resultado);
	}

	public static int sumaUnoUsandoClaseAnonima(int valorASumarUno) {
		/*Sumable summable = new Sumable() {
			@Override
			public int sumaUno(int x) {
				return x + 1;
			}
		};*/
		Sumable summable =  y -> ++y ;
		int resultado = summable.sumaUno(valorASumarUno);
		return resultado;
	}
}
