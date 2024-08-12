package com.stock_exchange.api.request.stockexchange;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStockExchangeRequest {

    @NotBlank(message = "The name can not be empty")
    private String name;

    @NotBlank(message = "The description can not be empty")
    private String description;

}
