/**
 *
 */
package com.evergreenprogrammer.microservices.productcatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.evergreenprogrammer.microservices.productcatalogservice.domain.Product;

/**
 * @author TapojitBhattacharya
 *
 */

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}