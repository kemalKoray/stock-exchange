package com.stock_exchange.api.response.stockexchange;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class StockExchangeDto {
    private String name;
    private String description;
    private boolean liveInMarket;
}
