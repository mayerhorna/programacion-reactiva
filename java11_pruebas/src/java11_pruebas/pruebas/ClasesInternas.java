package java11_pruebas.pruebas;

import java11_pruebas.pruebas.Email.EmailValidator;

class ClaseA{
	
}

class Email{
	private String body;
	
	//REGULAR INNER CLASS
	class EmailValidator{
		public String validateBody() {
			return body+"_OK";
		}
	}
	
	//STATIC NESTED CLASS	
	static class EmailParser{
		public static String parseBody(String body) {
			return body+"_PARSED";
		}
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	public String getBody() {
		return body;
	}
}

public class ClasesInternas {

	public static void main(String[] args) {
		Email email = new Email();
		email.setBody("Hola Mundo");
		//Creacion de objeto de una clase interna regular
		EmailValidator emailValidator = email.new EmailValidator();
		String bodyValidated = emailValidator.validateBody();
		System.out.println(bodyValidated);
		
		//creacion de un objeto de una clase interna static
		Email.EmailParser emailParser = new Email.EmailParser();
		String emailParseado = emailParser.parseBody(email.getBody());
		System.out.println(emailParseado);
		
		//MEthod LOCAL Inner Class
		class EmailProcessor{
			private String email;
			public boolean procesarEmail() {
				return true;
			}
		}
		/*
		class EmailProcessor2 extends EmailProcessor{
			
		}*/
		//creacion de un objeto de una clase interna a un metodo
		EmailProcessor emailProcessor = new EmailProcessor();
		boolean proceso = emailProcessor.procesarEmail();
		System.out.println(proceso);
		
	}
}

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
	public void clean() {
		System.out.println("clean popcorn padre");
	}
}
class Food {
	Popcorn p = new Popcorn(){
		public void pop() {
			System.out.println("anonymous popcorn");
		}
	} ;
} 

class ClaseAnonima{
	public static void main(String[] args) {
		/*Food food = new Food();
		food.p.pop();
		*/
		Popcorn popcorn = new Popcorn() {
			private String s = "";
			public void pop() {
				System.out.println("custom popcorn" + s);
				pop2();
			}
			public void pop2() {
				
			}
		};
		popcorn.pop();
	}
}


class CustomPopcorn extends Popcorn{
	public void pop() {
		System.out.println("custom popcorn");
	}
	
	public void clean() {
		System.out.println("clean popcorn hijo");
	}
}


interface EmpresaDao{
	public void save(Object entity);
}
class EmpresaDaoImpl implements EmpresaDao{
	@Override
	public void save(Object entity) {
	}
}

class PruebaPolimorfismo{
	//@Autowired
	static private EmpresaDao empresaDao;
	
	public static void main(String[] args) {
		//Object s = new String("a");
		Popcorn food = new CustomPopcorn();
		food.pop();
		food.clean();
		empresaDao.save(new String());
	}
}

interface Cookable {
	public void cook();
}
/*
class MyCookable implements Cookable{
	@Override
	public void cook() {
		System.out.println("cook de MyCookable");
	}
} 
*/ 
class PruebaInstanciaDeClaseAnonimaQueImplementaInterface{
	public static void main(String[] args) {
		/*
		Cookable cookable = new Cookable() {
			public void cook() {
				System.out.println("cook de clase anonima");
			}
		};
		*/
		Cookable cookable = () -> System.out.println("cook de clase anonima");
		cookable.cook();
	}
}






