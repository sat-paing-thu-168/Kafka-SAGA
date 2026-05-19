package com.kindergarten.saga.productservice.controller;

import com.kindergarten.saga.core.dto.Product;
import com.kindergarten.saga.productservice.dto.ProductCreationRequest;
import com.kindergarten.saga.productservice.dto.ProductCreationResponse;
import com.kindergarten.saga.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<ProductCreationResponse> save(@RequestBody @Valid ProductCreationRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        Product result = productService.save(product);

        ProductCreationResponse productCreationResponse = new ProductCreationResponse();
        BeanUtils.copyProperties(result, productCreationResponse);
        System.out.println("After BeanUtils.copyProperties: " + productCreationResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreationResponse);
    }
}
