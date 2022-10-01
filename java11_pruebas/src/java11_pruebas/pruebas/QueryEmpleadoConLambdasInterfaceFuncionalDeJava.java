package java11_pruebas.pruebas;

import java.util.ArrayList;
import java.util.function.Predicate;
 
public class QueryEmpleadoConLambdasInterfaceFuncionalDeJava {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new Empleado("Hugo", 1000, 2));
		empleados.add(new Empleado("Maria", 1300, 3));
		empleados.add(new Empleado("Miguel", 1200, 4));
		empleados.add(new Empleado("Karen", 1800, 6));
		
		Predicate<Empleado> gananMasDe1500 = empleado -> empleado.getSueldo() > 1500;
		Predicate<Empleado> tienenMenosDe5AniosExperiencia = empleado -> empleado.getAniosDeTrabajo() < 5;
		System.out.println("Todos los empleados: " + empleados);
		System.out.println("Ganan mas de 1500: " + reduceLista(empleados, 
				gananMasDe1500
			)
		);
		System.out.println("Ganan menos de 1500: " + reduceLista(empleados, 
				gananMasDe1500.negate()
			)
		);
		
		System.out.println("Tienen menos de 5 años de experiencia: " + reduceLista(empleados, 
				tienenMenosDe5AniosExperiencia
			)
		);
		System.out.println("Empiezan con letra M: " + reduceLista(empleados, 
				(Empleado empleado) -> {
					empleado.setNombre("O");
					return empleado.getNombre().startsWith("M"); 
				}
			)
		);
		
		System.out.println("Tienen menos de 5 años de experiencia y ganan + de 1500: " + reduceLista(empleados, 
				tienenMenosDe5AniosExperiencia.and(gananMasDe1500)
			)
		);
		
	}

	private static ArrayList<Empleado> reduceLista(ArrayList<Empleado> empleados, Predicate<Empleado> predicado) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (predicado.test(empleado)) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
 

}
