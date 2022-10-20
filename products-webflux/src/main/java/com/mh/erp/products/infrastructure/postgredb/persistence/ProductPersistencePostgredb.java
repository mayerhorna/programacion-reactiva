package com.mh.erp.products.infrastructure.postgredb.persistence;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.exceptions.ConflictException;
import com.mh.erp.products.domain.exceptions.NotFoundException;
import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.postgredb.daos.ProductRepository;
import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductPersistencePostgredb implements ProductPersistence {
	
	private ProductRepository productRepository;
	
    public ProductPersistencePostgredb(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
    
    @Override
    public Flux<Product> findAll(int limit) {
    	return this.productRepository
    				.findAll(limit)
    				.map(ProductEntity::toProduct);
    }

	@Override
	public Mono<Product> create(Product product) {
		return this.assertCodeNotExist(product.getCode())
				.then(Mono.just(new ProductEntity(product)))
                .flatMap(this.productRepository::save)
                .map(ProductEntity::toProduct);
	}

	@Override
	public Mono<Product> read(Long productId) {
		return productRepository
				.findById(productId)
				.switchIfEmpty(Mono.error( new ConflictException("Product does not exist : " + productId)))
				.map(ProductEntity::toProduct);
	}

	@Override
	public Mono<Product> update(Product product) {
        return this.assertCodeNotExistInOthersProducts(product.getCode(), product.getProductId())
	                .then(this.productRepository.findById(product.getProductId()))
	        		.switchIfEmpty(Mono.error(new NotFoundException("Non existent productId: " + product.getProductId())))
	                .flatMap(productEntity -> {
	                	BeanUtils.copyProperties(product, productEntity, "created", "isDeleted");
	                	productEntity.setUpdated(LocalDateTime.now());
	                    return Mono.just(productEntity);
	                })
	                .flatMap(this.productRepository::save)
	                .map(ProductEntity::toProduct);
	}
	
	private Mono<Void> assertCodeNotExist(String code) {
        return this.productRepository.findByCode(code)
                .flatMap(productEntity -> Mono.error(
                        new ConflictException("Product Code already exists : " + code)
                ));
    }
	
	private Mono<Void> assertCodeNotExistInOthersProducts(String code, Long productId) {
        return this.productRepository.findByCodeAndProductIdNot(code, productId)
                .flatMap(emptyEntity -> Mono.error(
                        new ConflictException("Product Code already exists in other product: " + code)
                ));
    }
	
	@Override
	public Mono<ProductIdAndNameDto> delete(Long productId) {
		return 
				productRepository.findById(productId)
				.switchIfEmpty(Mono.error(new NotFoundException("Non existent productId: " + productId)))
				.flatMap(productEntity -> {
					return productRepository
							.logicallyDelete(productEntity.getProductId())
							.thenReturn(productEntity.toProductIdAndNameDto());
				});
	}
	
	@Override
	public Mono<Product> updateEan(Long productId, String ean) {
		return this.productRepository.findById(productId)
				.switchIfEmpty(Mono.error(new NotFoundException("Non existent productId: " + productId)))
                .flatMap(productEntity -> {
                	productEntity.setEan(ean);
                    return Mono.just(productEntity);
                })
                .flatMap(this.productRepository::save)
                .map(ProductEntity::toProduct);
	}
}
