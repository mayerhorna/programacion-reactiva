package com.mh.erp.products.domain.persistence;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Repository
public interface ProductPersistence {
	Flowable<Product> findAll(int limit);

	Maybe<Product> create(Product product);
	
	Maybe<Product> read(Long productId);

	Maybe<Product> update(Product product);

	Maybe<ProductIdAndNameDto> delete(Long productId);

	Maybe<Product> updateEan(Long productId, String ean);
}
