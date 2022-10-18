package rxjava3_pruebas.multicasting_replay_caching;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjava3_pruebas.data.Product;
import rxjava3_pruebas.data.ProductStock;

public class MulitcastingInitTest {

	public static void main(String[] args) {
		List<ProductStock> stockProducts = ProductStock.getData();
		Observable<Product> productsObservable  = Observable.fromIterable(Product.getData());
		ConnectableObservable<ProductStock> hotProductObservable = 
				Observable.fromIterable(stockProducts)
				.zipWith(
					productsObservable, 
					(productStock,product) -> { 
						productStock.setProduct(product);  
						return productStock;
					}
			).publish();
		hotProductObservable.subscribeOn(Schedulers.newThread());
		hotProductObservable.subscribe(
			productStock -> System.out.println("1:"+productStock.getProduct().getName() + " -> " + 	productStock.getQuantity())
		);
		 
		hotProductObservable.connect();
		hotProductObservable.subscribe(
				productStock -> System.out.println("2:"+productStock.getProduct().getName() + " -> " + 	productStock.getQuantity())
			);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
