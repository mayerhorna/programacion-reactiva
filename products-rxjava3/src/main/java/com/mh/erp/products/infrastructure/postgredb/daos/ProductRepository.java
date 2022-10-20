package com.mh.erp.products.infrastructure.postgredb.daos;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.RxJava3SortingRepository;

import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ProductRepository extends RxJava3SortingRepository<ProductEntity, Long>{
	@Query(value = "SELECT tb_product_id as productId, code, name FROM tb_product WHERE is_deleted = 0 ORDER BY RANDOM() LIMIT :limit ")
	Flowable<ProductEntity> findAll(int limit);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code")
	Maybe<ProductEntity> findByCode(String code);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and tb_product_id = :productId")
	Maybe<ProductEntity> findById(Long productId);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code and tb_product_id <> :productId")
	Maybe<ProductEntity> findByCodeAndProductIdNot(String code, Long productId);

	@Modifying
	@Query("UPDATE tb_product set is_deleted = 1 WHERE tb_product_id = :productId ")
	Maybe<Void> logicallyDelete(Long productId);
	
} 
