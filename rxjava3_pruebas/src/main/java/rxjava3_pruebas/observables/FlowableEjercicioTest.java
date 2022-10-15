package rxjava3_pruebas.observables;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rxjava3_pruebas.data.Product;

public class FlowableEjercicioTest {

	public static void main(String[] args) {
		
	    Observable<Product> productFlowable = Observable.create(
	    		emmiter-> {
	    			List<Product> products = Product.getData();
	    			for (Product product : products) {
	    				emmiter.onNext(product);
					}
	    			emmiter.onComplete();
	    		}
	    );
	    Product productInit = new Product();
	    productInit.setSalesPrice(BigDecimal.ZERO);
	    Observable<Double> codeFlowable = productFlowable
	    		.filter(
	    				product -> 
	    					product.getIsActive().equals(1) 
	    					&&  
	    					product.getSalesPrice().compareTo(new BigDecimal(30.00)) > 0 
	    		).scan(productInit, (p1,p2)->
	    		{ p2.setSalesPrice(p2.getSalesPrice().add(p1.getSalesPrice()));
	    		return p2;
	    			
	    		})
	    		.map(p -> p.getSalesPrice().doubleValue())
	    				 ;
	    
	    codeFlowable.subscribe(
			precio -> System.out.println(String.valueOf(precio)),
			error -> System.out.println(error.getMessage()),
			() -> System.out.println("completo")
		);
	    codeFlowable.subscribe(
				precio -> System.out.println(String.valueOf(precio)),
				error -> System.out.println(error.getMessage()),
				() -> System.out.println("completo")
			);
	    
	}

}
