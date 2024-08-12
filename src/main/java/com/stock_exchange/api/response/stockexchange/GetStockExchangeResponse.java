package com.stock_exchange.api.response.stockexchange;

import com.stock_exchange.api.response.stock.StockDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class GetStockExchangeResponse extends StockExchangeDto {
    private Set<StockDto> stocks;
}
