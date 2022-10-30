package com.slama.productservice.controller;

import com.slama.productservice.dto.ProductRequest;
import com.slama.productservice.dto.ProductResponse;
import com.slama.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public record ProductController(
        ProductService productService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse createProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }
}
