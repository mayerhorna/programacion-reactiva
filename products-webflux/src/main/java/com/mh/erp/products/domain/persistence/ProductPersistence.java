package com.mh.erp.products.domain.persistence;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.api.dtos.ProductSummaryDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductPersistence {
	Flux<Product> findAll(int limit);

	Mono<Product> create(Product product);
	
	Mono<Product> read(Long productId);

	Mono<Product> update(Product product);

	Mono<ProductIdAndNameDto> delete(Long productId);

	Mono<Product> updateEan(Long productId, String ean);
}
