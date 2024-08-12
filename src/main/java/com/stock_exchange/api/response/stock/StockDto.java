package com.stock_exchange.api.response.stock;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
public class StockDto {
    private String name;
    private String description;
    private BigDecimal currentPrice;
    private LocalDateTime lastUpdate;
}
