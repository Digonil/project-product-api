package com.niles.productapi.domain.dto;

import com.niles.productapi.domain.Category;
import com.niles.productapi.domain.Product;

public record SearchResponseProductDTO(
        Long id,
        String name,
        Float price,
        String description,
        String productIdentifier,
        Category category
) {
    public SearchResponseProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getProductIdentifier(), product.getCategory());
    }
}
