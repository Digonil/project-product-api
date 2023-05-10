package com.niles.productapi.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CreateRequestCategoryDTO(
        @NotNull
        String name
) {
}
