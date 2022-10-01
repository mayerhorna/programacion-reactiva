package java11_pruebas.pruebas;

import java.util.ArrayList;

public class QueryEmpleadoSinLambdas {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new Empleado("Hugo", 1000, 2));
		empleados.add(new Empleado("Maria", 1300, 3));
		empleados.add(new Empleado("Miguel", 1200, 4));
		empleados.add(new Empleado("Karen", 1800, 6));
		System.out.println("Todos los empleados: " + empleados);
		System.out.println("Ganan mas de 1500: " + gananMasDe(empleados, 1500));
		System.out.println("Tienen menos de 5 años de experiencia: " + menosExperienciaDe(empleados, 5));
		System.out.println("Empiezan con letra M: " + empiezanConLetra(empleados, "M"));
	}

	private static ArrayList<Empleado> gananMasDe(ArrayList<Empleado> empleados, double valorAEvaluar) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getSueldo() > valorAEvaluar) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}

	private static ArrayList<Empleado> menosExperienciaDe(ArrayList<Empleado> empleados, int valorAEvaluar) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getAniosDeTrabajo() < valorAEvaluar) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
	
	private static ArrayList<Empleado> empiezanConLetra(ArrayList<Empleado> empleados, String letraInicial) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getNombre().startsWith(letraInicial)) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}

}
