package com.mh.erp.client.product;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductWebServiceApi {
	@GET("/products/search")
	Flowable<List<Product>> search(@Query("limit") int limit);
	
	@GET("/products/{productId}")
	Maybe<Product> get(@Path("productId") Long productId);
	
	@POST("/products")
	Maybe<Product> save(@Body Product product);
	
	@PUT("/products")
	Maybe<Product> update(@Body Product product);
	
	@DELETE("/products/{productId}")
	Maybe<Product> delete(@Path("productId") Long productId);

	@PATCH("/products/{productId}/ean")
	Maybe<Product> updateEan(@Path("productId") Long productId, @Query("ean") String ean);
	
}
