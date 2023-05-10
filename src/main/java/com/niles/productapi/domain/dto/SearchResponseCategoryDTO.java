package com.niles.productapi.domain.dto;

import com.niles.productapi.domain.Category;

public record SearchResponseCategoryDTO(
        Long id,
        String name) {
    public SearchResponseCategoryDTO (Category category){
        this(category.getId(), category.getName());
    }
}
