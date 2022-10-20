package com.mh.erp.client.observers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.erp.client.exceptions.ServiceException;
import com.mh.erp.client.exceptions.ServiceResult;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.HttpException;

public abstract class SingleObserverService<T> implements SingleObserver<T> {
	@Override
	public void onSubscribe(@NonNull Disposable d) {
	}
 
	@Override
	public void onSuccess(T t) {
		success(new ServiceResult<T>(t, null));
	}
	
	@Override
	public void onError(@NonNull Throwable error) {
		HttpException e =	 ((HttpException)error);
		String errorMessageAsJson = e.response().errorBody().source().buffer().clone().readUtf8();
		ObjectMapper mapper = new ObjectMapper();
		ServiceException serviceException = new ServiceException("-");
		try {
			serviceException = mapper.readValue(errorMessageAsJson, ServiceException.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		failure(serviceException);
	}
 	
	public abstract void success(ServiceResult<T> result);
    public abstract void failure(ServiceException exception);
	    
}
