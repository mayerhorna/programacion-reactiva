package com.mh.erp.client.test;

import java.math.BigDecimal;

import com.mh.erp.client.WebService;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;
import com.mh.erp.client.observers.MaybeObserverService;
import com.mh.erp.client.product.Product;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductSaveWebServiceTest {

	public static void main(String[] args) {
		Product product = new Product();
		product.setCode("F100016");	
		product.setName("Nueo");	
		product.setIsActive(1);	
		product.setSalesPrice(new BigDecimal(10.0));
		product.setSalesPriceWithTax(new BigDecimal(11.8));	
		product.setEan("1582364798532");	
		product.setCanBeSold(1);	
		product.setProductLocation("");	
		
		WebService
			.getInstance()
			.createService()
			.save(product)
			.subscribeOn(Schedulers.io())
			.subscribe(new MaybeObserverService<Product>() {
				public void success(ServiceResult<Product> result) {
					Product product = result.getData();
					System.out.println("Guardado: %s: %s".formatted(product.getProductId(), product.getName()));
				}

				public void failure(ServiceException exception) {
					System.out.println(exception.getMessage());
				}
			});
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
}
