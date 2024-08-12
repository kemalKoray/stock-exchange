package com.stock_exchange.exception.enums.stockexchange;

import com.stock_exchange.exception.BusinessError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StockExchangeBusinessError implements BusinessError {
    STOCK_EXCHANGE_COULD_NOT_BE_FOUND("SE_1", "Stock exchange could not be found by given name"),
    STOCK_EXISTS("SE_2", "The stock has already been added"),
    STOCK_NOT_EXISTS("SE_2", "The stock exchange does not have this stock");

    private final String code;

    private final String description;
}
