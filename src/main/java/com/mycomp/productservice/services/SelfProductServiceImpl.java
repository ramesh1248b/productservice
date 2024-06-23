package com.mycomp.productservice.services;

import com.mycomp.productservice.dtos.GenericProductDto;
import com.mycomp.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("selfProductService")
public class SelfProductServiceImpl implements ProductService {
    public Product getProductById (Long id) {
        System.out.println("Inside SelfProductService");

        return null;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        return null ;
    }

    public List<GenericProductDto> getAllProducts() {
        return null;
    }
}
