package com.stock_exchange.api.request.stock;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StockPriceUpdateRequest {
    @NotNull
    @Positive(message = "The price must be greater than zero")
    private BigDecimal price;
}
