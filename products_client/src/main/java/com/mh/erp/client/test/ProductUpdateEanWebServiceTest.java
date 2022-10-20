package com.mh.erp.client.test;

import java.math.BigDecimal;

import com.mh.erp.client.WebService;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;
import com.mh.erp.client.observers.MaybeObserverService;
import com.mh.erp.client.product.Product;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductUpdateEanWebServiceTest {

	public static void main(String[] args) {
		Long productIdtoUpdate = 18489L;
		String newEan = "1111111111111";
		
		WebService
			.getInstance()
			.createService()
			.updateEan(productIdtoUpdate , newEan)
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
