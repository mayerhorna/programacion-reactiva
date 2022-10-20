package com.mh.erp.products.domain.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Service
public class ProductService {
	private final ProductPersistence productPersistence;
	
	public ProductService(ProductPersistence productPersistence) {
		this.productPersistence = productPersistence;
	}
	
	public Flowable<Product> findAll(int limit) {
		return this.productPersistence.findAll(limit);
	}
	
    public Maybe<Product> create(Product product) {
        product.setCreated(LocalDateTime.now());
        return this.productPersistence.create(product);
    }

    public Maybe< Product > read(Long productId) {
        return this.productPersistence.read(productId);
    }
    
    public Maybe<ProductIdAndNameDto> delete(Long productId) {
        return this.productPersistence.delete(productId);
    }

    public Maybe<Product> update(Product product) {
        return this.productPersistence.read(product.getProductId())
                .map(dataProduct -> {
                	BeanUtils.copyProperties(product, dataProduct, "created");
                	dataProduct.setUpdated(LocalDateTime.now());
                    return dataProduct;
                }).flatMap(dataProduct -> this.productPersistence.update(dataProduct));
    }

	public Maybe<Product> updateEan(Long productId, String ean) {
		 return this.productPersistence.updateEan(productId, ean);
	}
	
}
