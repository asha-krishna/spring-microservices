package com.product.api.controller;

import com.product.api.model.Inventory;
import com.product.api.model.Price;
import com.product.api.model.Product;
import com.product.api.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/product-details/{productId}")
    public Product getProduct(@PathVariable Long productId) {

        // get product name and description --> from product-service
        List<ProductInfo> productsList = getProductsList();
        ProductInfo productInfo = productsList.stream().filter(product -> product.getProductId().equals(productId)).findAny().orElseGet(() -> new ProductInfo());

        // get pricing                      --> from pricing-service
        //Price price = restTemplate.getForObject("http://localhost:8082/price/" + productId, Price.class);         // direct API call
        Price price = restTemplate.getForObject("http://pricing-service/price/" + productId, Price.class);      // API call through Eureka server

        // get stock availability           --> inventory-service
        //Inventory inventory = restTemplate.getForObject("http://localhost:8083/inventory/" + productId, Inventory.class);   // direct API call
        Inventory inventory = restTemplate.getForObject("http://inventory-service/inventory/" + productId, Inventory.class);    // API call through Eureka server

        return new Product(productInfo.getProductId(), productInfo.getProductName(), productInfo.getProductDescription(), price.getOriginalPrice(), price.getDiscountedPrice(), inventory.getStockAvailability());
    }

    public List<ProductInfo> getProductsList() {
        // get this list from Database
        List<ProductInfo> productInfoList = Arrays.asList(
                new ProductInfo(123L, "iPhone", "this is iPhone 13 model"),
                new ProductInfo(654L, "Laptop", "Lenovo Laptop"),
                new ProductInfo(289L, "TV", "Sony TV with High definition quality")
        );
        return productInfoList;
    }

    /* Instead of RestTemplate we can use WebClient as well
    Inventory inventory = webClientBuilder.build()                  // using builder pattenr giving a client
                                .get()                                  // making GET call
                                .uri("http://localhost:8083/inventory/" + productId)
                                .retrieve()                             // go and fetch some body
                                .bodyToMono(Inventory.class)            // whatever body is fetch convert it into Inventory class. Mono means will get asynchronous response in future
                                .block();                               // blocking execution until Mono gets something
        */
}
