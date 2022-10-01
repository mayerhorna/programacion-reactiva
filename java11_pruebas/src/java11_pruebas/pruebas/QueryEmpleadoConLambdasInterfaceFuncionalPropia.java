package java11_pruebas.pruebas;

import java.util.ArrayList;

interface Predicado{
	boolean verificar(Empleado empleado);
}

public class QueryEmpleadoConLambdasInterfaceFuncionalPropia {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new Empleado("Hugo", 1000, 2));
		empleados.add(new Empleado("Maria", 1300, 3));
		empleados.add(new Empleado("Miguel", 1200, 4));
		empleados.add(new Empleado("Karen", 1800, 6));
		
		//version 1
		//Predicado sueldoMayorA1500 = empleado -> empleado.getSueldo() > 1500;
		//Predicado sueldoMenorA1500 = empleado -> empleado.getSueldo() < 1500;
		
		System.out.println("Todos los empleados: " + empleados);
		//System.out.println("Ganan mas de 1500: " + reduceLista(empleados, sueldoMayorA1500));
		//System.out.println("Ganan menos de 1500: " + reduceLista(empleados, sueldoMenorA1500));
		System.out.println("Ganan mas de 1500: " + reduceLista(empleados, 
				empleado -> empleado.getSueldo() > 1500
			)
		);
		System.out.println("Ganan menos de 1500: " + reduceLista(empleados, 
				empleado -> empleado.getSueldo() < 1500
			)
		);
		
		System.out.println("Tienen menos de 5 años de experiencia: " + reduceLista(empleados, 
				empleado -> empleado.getAniosDeTrabajo() < 5
			)
		);
		System.out.println("Empiezan con letra M: " + reduceLista(empleados, 
				empleado -> empleado.getNombre().startsWith("M")
			)
		);
		
		System.out.println("Empiezan con letra K: " + reduceLista(empleados, 
				new Predicado() {
					public boolean verificar(Empleado empleado) {
						return empleado.getNombre().startsWith("K");
					}
				}
			)
		);
		
		//System.out.println("Tienen menos de 5 años de experiencia: " + menosExperienciaDe(empleados, 5));
		//System.out.println("Empiezan con letra M: " + empiezanConLetra(empleados, "M"));
	}

	private static ArrayList<Empleado> reduceLista(ArrayList<Empleado> empleados, Predicado predicado) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (predicado.verificar(empleado)) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
 

}
