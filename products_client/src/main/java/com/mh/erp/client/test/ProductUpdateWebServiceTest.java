package com.mh.erp.client.test;

import java.math.BigDecimal;

import com.mh.erp.client.WebService;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;
import com.mh.erp.client.observers.MaybeObserverService;
import com.mh.erp.client.product.Product;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductUpdateWebServiceTest {

	public static void main(String[] args) {
		Long productIdtoUpdate = 18489L;
		Product product = new Product();
		product.setProductId(productIdtoUpdate);
		product.setCode("F100080");	
		product.setName("Actualizado");	
		product.setIsActive(1);	
		product.setSalesPrice(new BigDecimal(10.0));
		product.setSalesPriceWithTax(new BigDecimal(11.8));	
		product.setEan("1582364798532");	
		product.setCanBeSold(1);	
		product.setProductLocation("");	
		
		WebService
			.getInstance()
			.createService()
			.update(product)
			.subscribeOn(Schedulers.io())
			.subscribe(new MaybeObserverService<Product>() {
				public void success(ServiceResult<Product> result) {
					Product product = result.getData();
					System.out.println("Actualizado: %s: %s".formatted(product.getProductId(), product.getName()));
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
