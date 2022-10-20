package com.mh.erp.client;

import com.mh.erp.client.product.ProductWebServiceApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class WebService {
	 private static final String BASE_URL = "http://localhost:8082/";
	    private static WebService instance;
	    private Retrofit retrofit;
	    private HttpLoggingInterceptor loggingInterceptor;
	    private OkHttpClient.Builder httpClientBuilder;

	    private WebService(){
	        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
	        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
	        retrofit = new Retrofit.Builder()
	                .baseUrl(BASE_URL)
	                .client(httpClientBuilder.build())
	                .addConverterFactory(JacksonConverterFactory.create())
	                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
	                .build();
	    }

	    public static synchronized WebService getInstance(){
	        if(instance== null){
	            instance = new WebService();
	        }
	        return instance;
	    }

	    public ProductWebServiceApi createService(){
	        return retrofit.create(ProductWebServiceApi.class);
	    }
}
