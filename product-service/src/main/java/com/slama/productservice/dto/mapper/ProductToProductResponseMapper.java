package com.slama.productservice.dto.mapper;

import com.slama.productservice.dto.ProductResponse;
import com.slama.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductResponseMapper {

    public ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription()
        );
    }
}
