/**
 * 
 */
package com.evergreenprogrammers.microservices.productfilterservice.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evergreenprogrammers.microservices.productfilterservice.bo.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author TapojitBhattacharya
 *
 */
@RestController
public class ProductFilterController {
	@Autowired
	private ProductCatalogServiceProxy feignClient;

	@GetMapping(path = "/product-filter-feign/type/{type}")
	@HystrixCommand(fallbackMethod = "reliable")
	public Collection<Product> filterProducts(@PathVariable String type) {
		Collection<Product> resultantProducts = new HashSet<>();

		List<Product> allProducts = feignClient.retrieveAllProducts();
		if (!CollectionUtils.isEmpty(allProducts)) {
			for (Product product : allProducts) {
				if (product.getType().equalsIgnoreCase(type)) {
					resultantProducts.add(product);
				}
			}

		}
		return resultantProducts;
	}

	public Collection<Product> reliable(String type) {
		return new HashSet<Product>();
	}

}
