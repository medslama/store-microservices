package com.slama.productservice.service;

import com.slama.productservice.dto.ProductResponse;
import com.slama.productservice.dto.mapper.ProductToProductResponseMapper;
import com.slama.productservice.model.Product;
import com.slama.productservice.dto.ProductRequest;
import com.slama.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public record ProductService(
        ProductRepository productRepository,
        ProductToProductResponseMapper productToProductResponseMapper
) {

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();

        productRepository.save(product);
        log.info("Product with ID {} is created sucsussfully", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productToProductResponseMapper::mapToProductResponse)
                .toList();
    }

    public ProductResponse getProductById(String id) {
        //TODO refactor this
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productToProductResponseMapper.mapToProductResponse(product.get());
        }
        return null;
    }
}
