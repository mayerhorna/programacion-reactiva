package rxjava3_pruebas.observables;

import java.math.BigDecimal;
import java.util.List;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import rxjava3_pruebas.data.Product;

public class FlowableEjercicioTest {

	public static void main(String[] args) {
		List<Product> products = Product.getData();
	    Flowable<Product> productFlowable = Flowable.fromIterable(products);
	    Flowable<String> codeFlowable = productFlowable
	    		.filter(
	    				product -> 
	    					product.getIsActive().equals(1) 
	    					&&  
	    					product.getSalesPrice().compareTo(new BigDecimal(30.00)) > 0 
	    		).map(product -> product.getCode());
	    
	    codeFlowable.subscribe(
			codigo -> System.out.println(codigo),
			error -> System.out.println(error.getMessage()),
			() -> System.out.println("completo")
		);
			
	}

}
