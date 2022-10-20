package com.mh.erp.products.domain.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	private final ProductPersistence productPersistence;
	
	public ProductService(ProductPersistence productPersistence) {
		this.productPersistence = productPersistence;
	}
	
	public Flux<Product> findAll(int limit) {
		return this.productPersistence.findAll(limit);
	}
	
    public Mono< Product > create(Product product) {
        product.setCreated(LocalDateTime.now());
        return this.productPersistence.create(product);
    }

    public Mono< Product > read(Long productId) {
        return this.productPersistence.read(productId);
    }
    
    public Mono<ProductIdAndNameDto> delete(Long productId) {
        return this.productPersistence.delete(productId);
    }

    public Mono<Product> update(Product product) {
        return this.productPersistence.read(product.getProductId())
                .map(dataProduct -> {
                	BeanUtils.copyProperties(product, dataProduct, "created");
                	dataProduct.setUpdated(LocalDateTime.now());
                    return dataProduct;
                }).flatMap(dataProduct -> this.productPersistence.update(dataProduct));
    }

	public Mono<Product> updateEan(Long productId, String ean) {
		 return this.productPersistence.updateEan(productId, ean);
	}
	
}
