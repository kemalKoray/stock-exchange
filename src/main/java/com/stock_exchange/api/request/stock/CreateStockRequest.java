package com.stock_exchange.api.request.stock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateStockRequest {
    @NotBlank(message = "The name can not be empty")
    private String name;

    @NotBlank(message = "The description can not be empty")
    private String description;

    @NotNull
    @Positive(message = "The price must be greater than zero")
    private BigDecimal price;
}
