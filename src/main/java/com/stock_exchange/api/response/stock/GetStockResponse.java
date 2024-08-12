package com.stock_exchange.api.response.stock;

import com.stock_exchange.api.response.stockexchange.StockExchangeDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class GetStockResponse extends StockDto {
    private Set<StockExchangeDto> stockExchanges;
}
