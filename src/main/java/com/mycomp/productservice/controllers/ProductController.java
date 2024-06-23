package com.mycomp.productservice.controllers;


import com.mycomp.productservice.dtos.FakeStoreProductDto;
import com.mycomp.productservice.dtos.GenericProductDto;
import com.mycomp.productservice.models.Product;
import com.mycomp.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/products/"))


public class ProductController {
    private ProductService productService ;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService ;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    //  localhost:8080/api/v1/products/123
    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        //productService.getProductById(1L) ;
        return productService.getProductById(id) ;
    }

    @DeleteMapping("{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        System.out.println(product.getTitle());

        return productService.createProduct(product) ;
    }

    @PostMapping("{id}")
    public void updateProductById() {

    }
}
