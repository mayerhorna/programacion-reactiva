package rxjava3_pruebas.multicasting_replay_caching;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjava3_pruebas.data.Product;
import rxjava3_pruebas.data.ProductStock;

public class CacheTest {

	public static void main(String[] args) {
		List<ProductStock> stockProducts = ProductStock.getData();
		Observable<Product> productsObservable = Observable.fromIterable(Product.getData());
		Observable<ProductStock> hot = Observable.fromIterable(stockProducts);
		Observable<ProductStock> productStockObservable = hot.zipWith(
			productsObservable, 
			(productStock,product) -> {
				System.out.println("==========en operador zipWith...");
				productStock.setProduct(product);  
				return productStock;
			}
		).cache();
		productStockObservable = productStockObservable.subscribeOn(Schedulers.newThread());
		productStockObservable.subscribe(
			productStock -> System.out.println("1:" + productStock.getProduct().getName() + " -> " + productStock.getQuantity())
		);
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e1) {
		}
		productStockObservable.subscribe(
			productStock -> System.out.println("2:" + productStock.getProduct().getName() + " -> " + productStock.getQuantity())
		);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

	}

}
