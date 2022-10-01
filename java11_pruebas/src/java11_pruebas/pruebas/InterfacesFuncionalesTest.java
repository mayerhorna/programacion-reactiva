package java11_pruebas.pruebas;

interface Predicado2 {
	public static final String DBNAME = "db_products";

	public abstract boolean verificar(Object obj);

}

interface IsWarmBlooded {
	abstract boolean hasScales();

	default double getTemperature() {
		return 10.0;
	}
	
	private double getTemperature3() {
		return 10.0;
	}

	public default double getTemperature2() {
		return 3.0;
	}

	static int getJumpHeight() {
		return 8;
	}

	
	private static int getJumpHeight2() {
		return 8;
	}
}

public class InterfacesFuncionalesTest {

	public static void main(String[] args) {
		IsWarmBlooded isWarmBlooded = new IsWarmBlooded() {
			public boolean hasScales() {
				return false;
			}
		};
		double d2 = isWarmBlooded.getTemperature2();
		int i = IsWarmBlooded.getJumpHeight(); 
	}
}

interface Sprint {
   public void sprint(int speed);
}
 
class Tiger implements Sprint {
   public void sprint(int speed) {
      System.out.println("Animal is sprinting fast! " + speed);
   }
}

