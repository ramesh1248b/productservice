package com.mycomp.productservice.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/products/"))


public class ProductController {
    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    //  localhost:8080/api/v1/products/123
    public String getProductById(@PathVariable("id") Long id) {
        return "Product ID : " + id ;
    }

    @DeleteMapping("{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public void createProduct() {

    }

    @PostMapping("{id}")
    public void updateProductById() {

    }
}
