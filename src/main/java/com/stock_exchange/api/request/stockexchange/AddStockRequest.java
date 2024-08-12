package com.stock_exchange.api.request.stockexchange;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStockRequest {
    @NotBlank(message = "The stock name can not be empty")
    private String stockName;
}
