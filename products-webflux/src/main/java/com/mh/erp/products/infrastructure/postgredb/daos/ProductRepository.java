package com.mh.erp.products.infrastructure.postgredb.daos;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Long>{
	@Query(value = "SELECT tb_product_id as productId, code, name FROM tb_product WHERE is_deleted = 0 ORDER BY RANDOM() LIMIT :limit ")
	Flux<ProductEntity> findAll(int limit);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code")
	Mono<ProductEntity> findByCode(String code);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and tb_product_id = :productId")
	Mono<ProductEntity> findById(Long productId);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code and tb_product_id <> :productId")
	Mono<ProductEntity> findByCodeAndProductIdNot(String code, Long productId);

	@Modifying
	@Query("UPDATE tb_product set is_deleted = 1 WHERE tb_product_id = :productId ")
	Mono<Void> logicallyDelete(Long productId);
	
} 
