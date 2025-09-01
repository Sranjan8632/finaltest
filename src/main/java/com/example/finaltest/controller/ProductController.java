package com.example.finaltest.controller;

import com.example.finaltest.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

     @RestController
public class ProductController {

    private static final List<Product> products = Arrays.asList(
            new Product(101, "RedTape", "Shoes", 1500),
            new Product(102, "AllenSolley", "Shirts", 1000),
            new Product(103, "WoodLand", "Shoes", 2500),
            new Product(104, "Oxemberg", "Shirts", 900),
            new Product(105, "Arrow", "Shirts", 1100),
            new Product(106, "Bata", "Shoes", 899),
            new Product(107, "Raymond", "Blazers", 3000),
            new Product(108, "ParkAvenue", "Blazers", 2500),
            new Product(109, "PeterEngland", "Shirts", 1200),
            new Product(110, "LondonBridge", "Shirts", 700)
    );

          // Endpoint to return all products
         @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
             return products;
    }

          // Endpoint to get products by type and price
       @GetMapping("/getByTypeAndPrice")
    public List<Product> getByTypeAndPrice(@RequestParam String type, @RequestParam double price) {
         return products.stream()
                .filter(product -> product.getType().equalsIgnoreCase(type) && product.getPrice() > price)
                .collect(Collectors.toList());
            }
 }
