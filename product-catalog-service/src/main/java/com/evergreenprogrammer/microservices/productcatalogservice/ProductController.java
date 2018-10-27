/**
 *
 */
package com.evergreenprogrammer.microservices.productcatalogservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evergreenprogrammer.microservices.productcatalogservice.domain.Product;
import com.evergreenprogrammer.microservices.productcatalogservice.repository.ProductRepository;

/**
 * @author TapojitBhattacharya
 *
 */
@RestController
public class ProductController {
	@Autowired
	ProductRepository repository;

	@GetMapping(path = "/products")
	public List<Product> retrieveAllProducts() {
		List<Product> products = repository.findAll();

		return products;

	}

}