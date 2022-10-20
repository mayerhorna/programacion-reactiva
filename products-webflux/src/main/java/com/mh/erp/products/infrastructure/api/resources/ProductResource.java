package com.mh.erp.products.infrastructure.api.resources;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.services.ProductService;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {
	public static final String PRODUCTS = "/products";
	public static final String PRODUCT_ID = "/{productId}";
	public static final String SEARCH = "/search";
	public static final String EAN = "/ean";
    private ProductService productService;
    
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(SEARCH)
    public Flux<Product> findAll(@RequestParam int limit) {
    	Flux<Product> products = 
    			productService.findAll(limit)
    			.map(this::encryptCode);
    	return products;
    } 
    
    private Product encryptCode(Product product) {
        String encriptedCode = new BCryptPasswordEncoder().encode(product.getCode());
        product.setEncriptedCode(encriptedCode);
        return product;
    }
    
    @PostMapping(produces = {"application/json"})
	public Mono<Product> create(@Valid @RequestBody Product product) {
        product.doDefault();
        return this.productService.create(product);
    }
    
    @PutMapping(produces = {"application/json"})
   	public Mono<Product> update(@Valid @RequestBody Product product) {
       return this.productService.update(product);
    }
    
    @PatchMapping(value = PRODUCT_ID + EAN,  produces = {"application/json"})
   	public Mono<Product> updateEan(@PathVariable Long productId, @RequestParam String ean) {
       return this.productService.updateEan(productId, ean);
    }

    @GetMapping(PRODUCT_ID)
    public Mono<Product> read(@PathVariable Long productId) {
        return this.productService.read(productId);
    }
    
    @DeleteMapping(PRODUCT_ID)
    public Mono<ProductIdAndNameDto> delete(@PathVariable Long productId) {
        return this.productService.delete(productId);
    }
}
