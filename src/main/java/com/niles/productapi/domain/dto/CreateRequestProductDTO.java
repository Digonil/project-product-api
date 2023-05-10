package com.niles.productapi.domain.dto;

import com.niles.productapi.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRequestProductDTO(
        @NotBlank
        String name,
        @NotNull
        Float price,
        @NotBlank
        String description,
        @NotBlank
        String productIdentifier,
        @NotNull
        Category category
) {
}
