package com.mycomp.productservice.services;

import com.mycomp.productservice.dtos.FakeStoreProductDto;
import com.mycomp.productservice.dtos.GenericProductDto;
import com.mycomp.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    RestTemplateBuilder restTemplateBuilder ;

    String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    String createProductRequestURL = "https://fakestoreapi.com/products/";
    String getAllProductsURL = "https://fakestoreapi.com/products/";
    String deleteProductUrl = "https://fakestoreapi.com/products/{id}" ;

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder ;
    }

    public Product getProductById (Long id) {
        System.out.println("Inside FakeProductServiceImpl : " + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response =
                restTemplate.getForEntity(getProductRequestURL, GenericProductDto.class, id) ;

        GenericProductDto genericProductDto = response.getBody() ;

        System.out.println( response.getStatusCode() ) ;
        Product product = new Product();

        product.setId(genericProductDto.getId());
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setTitle(genericProductDto.getTitle());
        product.setPrice(genericProductDto.getPrice());
        product.setCategory(genericProductDto.getCategory());

        return product ;
    }

    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response =
                restTemplate.postForEntity(createProductRequestURL, product ,GenericProductDto.class) ;

        return response.getBody() ;
    }

    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(getAllProductsURL, FakeStoreProductDto[].class ) ;

        List<GenericProductDto> answer = new ArrayList<>() ;

        for (FakeStoreProductDto fakeStoreProductDto : response.getBody() ) {
            GenericProductDto product = new GenericProductDto();

            product.setId(fakeStoreProductDto.getId());
            product.setImage(fakeStoreProductDto.getImage());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());

            answer.add(product) ;
        }

        return answer;
    }

    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();


        //deleteProductUrl
    }
}
