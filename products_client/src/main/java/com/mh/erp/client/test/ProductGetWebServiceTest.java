package com.mh.erp.client.test;

import com.mh.erp.client.WebService;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;
import com.mh.erp.client.observers.MaybeObserverService;
import com.mh.erp.client.product.Product;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class ProductGetWebServiceTest {

	public static void main(String[] args) {
		Long productId = 18489L;
		WebService
			.getInstance()
			.createService()
			.get(productId)
			.subscribeOn(Schedulers.io())
			.subscribe(new MaybeObserverService<Product>() {
				public void success(ServiceResult<Product> result) {
					Product product = result.getData();
					System.out.println("%s: %s".formatted(product.getCode(), product.getName()));
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
