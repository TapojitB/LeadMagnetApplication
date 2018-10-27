package com.evergreenprogrammer.microservices.productfilterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.evergreenprogrammer.microservices.productfilterservice.controller.ProductCatalogServiceProxy;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients(clients = ProductCatalogServiceProxy.class)
@EnableCircuitBreaker
public class ProductFilterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductFilterServiceApplication.class, args);
	}
}
