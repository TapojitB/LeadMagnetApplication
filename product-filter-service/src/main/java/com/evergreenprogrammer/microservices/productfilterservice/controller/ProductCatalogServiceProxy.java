/**
 * 
 */
package com.evergreenprogrammer.microservices.productfilterservice.controller;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.evergreenprogrammer.microservices.productfilterservice.bo.Product;

/**
 * @author TapojitBhattacharya
 *
 */
@FeignClient(name = "product-catalog-service")
@RibbonClient(name="product-catalog-service")
public interface ProductCatalogServiceProxy {

	@GetMapping("/products")
	public List<Product> retrieveAllProducts();

}