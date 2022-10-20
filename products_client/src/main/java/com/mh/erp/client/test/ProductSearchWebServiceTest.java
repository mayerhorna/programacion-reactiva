package com.mh.erp.client.test;

import java.util.List;

import com.mh.erp.client.WebService;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;
import com.mh.erp.client.observers.FlowableObserverService;
import com.mh.erp.client.product.Product;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductSearchWebServiceTest {

	public static void main(String[] args) {
		WebService
			.getInstance()
			.createService()
			.search(5)
			.subscribeOn(Schedulers.io()) 
			.subscribe(new FlowableObserverService<List<Product>>() {
				public void success(ServiceResult<List<Product>> result) {
					result.getData().forEach( 
							product -> 
							System.out.println("%s: %s".formatted(product.getCode(), product.getName()))
					);
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
