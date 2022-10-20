package com.mh.erp.products.infrastructure.postgredb.persistence;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.exceptions.ConflictException;
import com.mh.erp.products.domain.exceptions.NotFoundException;
import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.postgredb.daos.ProductRepository;
import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

@Repository
public class ProductPersistencePostgredb implements ProductPersistence {
	
	private ProductRepository productRepository;
	
    public ProductPersistencePostgredb(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
    
    @Override
    public Flowable<Product> findAll(int limit) {
    	return this.productRepository
    				.findAll(limit)
    				.map(ProductEntity::toProduct);
    }

	@Override
	public Maybe<Product> create(Product product) {
		return this.productRepository.findByCode(product.getCode())
				.flatMap(
					productEntity -> Maybe.error(
                        new ConflictException("Product Code already exists : " + product.getCode())
					),
					(error) -> Maybe.error(error) , // unnecessary rewrapping of error
					() -> Maybe.just(new ProductEntity(product))  // unnecessary toMaybe()
					     
				)
				.flatMapSingle(productRepository::save)
                .map(ProductEntity::toProduct);
	}

	@Override
	public Maybe<Product> read(Long productId) {
		return productRepository
				.findById(productId)
				.switchIfEmpty(Maybe.error( new ConflictException("Product does not exist : " + productId)))
				.map(ProductEntity::toProduct);
	}

	@Override
	public Maybe<Product> update(Product product) {
        return 
        		this.productRepository.findByCodeAndProductIdNot(product.getCode(), product.getProductId())
                .flatMap(
                		emptyEntity -> Maybe.error(
                				new ConflictException("Product Code already exists in other product: " + product.getCode())
                		),
                		error -> Maybe.error(error),
                		() -> Maybe.just(new ProductEntity(product)) 
                ) 
	          	.flatMapSingle(this.productRepository::save)
	        	.map(ProductEntity::toProduct);
        
	}
	
	@Override
	public Maybe<ProductIdAndNameDto> delete(Long productId) {
		return 
				productRepository.findById(productId)
				.switchIfEmpty(Maybe.error(new NotFoundException("Non existent productId: " + productId)))
				.flatMap(productEntity -> {
					return productRepository
							.logicallyDelete(productEntity.getProductId())
							.flatMap(
									empty -> {
										return Maybe.empty();
									},
									error -> Maybe.error(error),
									() -> Maybe.just(productEntity.toProductIdAndNameDto())
							);
				});
		 
	}
	
	@Override
	public Maybe<Product> updateEan(Long productId, String ean) {
		return this.productRepository.findById(productId)
				.switchIfEmpty(Maybe.error(new NotFoundException("Non existent productId: " + productId)))
                .flatMap(productEntity -> {
                	productEntity.setEan(ean);
                    return Maybe.just(productEntity);
                })
                .flatMapSingle(this.productRepository::save)
                .map(ProductEntity::toProduct);
		
		
	}
	 
}
