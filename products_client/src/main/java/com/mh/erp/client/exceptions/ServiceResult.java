package com.mh.erp.client.exceptions;

import okhttp3.Response;

public class ServiceResult<T> {
	public final T data;
    public final Response response;

    public ServiceResult(T data, Response response) {
        this.data = data;
        this.response = response;
    }
    
    public T getData() {
		return data;
	}
}
