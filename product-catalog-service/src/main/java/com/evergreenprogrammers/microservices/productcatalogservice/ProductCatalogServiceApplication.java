package com.evergreenprogrammers.microservices.productcatalogservice;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.annotation.PostConstruct;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
 
import com.evergreenprogrammers.microservices.productcatalogservice.domain.Product;
import com.evergreenprogrammers.microservices.productcatalogservice.repository.ProductRepository;
 
@SpringBootApplication
@EnableDiscoveryClient(autoRegister=true)
public class ProductCatalogServiceApplication {
 
    @Autowired(required=true)
    private ProductRepository productRepository;
     
    @Autowired
    private Environment environment;
 
      
 
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogServiceApplication.class, args);
    }
 
    @PostConstruct
    public void initialize() {
         
        String port = environment.getProperty("server.port");
        int portNo = Integer.parseInt(port);
         
        Set<Product> products = new HashSet<>();
        products.add(new Product("Nike", "Sports", portNo));
        products.add(new Product("Puma", "Sports", portNo));
        products.add(new Product("Adidas", "Sports", portNo));
        products.add(new Product("Reebok", "Sports", portNo));
 
        products.add(new Product("Nokia", "Electronics", portNo));
        products.add(new Product("Motorola", "Electronics", portNo));
        products.add(new Product("LG", "Electronics", portNo));
        products.add(new Product("Samsung", "Electronics", portNo));
 
        products.add(new Product("Honda", "Vehicle", portNo));
        products.add(new Product("Maruti", "Vehicle", portNo));
        products.add(new Product("Hyundai", "Vehicle", portNo));
        products.add(new Product("Nissan", "Vehicle", portNo));
         
        productRepository.saveAll(products);
         
    }
 
}