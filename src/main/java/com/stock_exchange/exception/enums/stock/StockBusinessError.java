package com.stock_exchange.exception.enums.stock;

import com.stock_exchange.exception.BusinessError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StockBusinessError implements BusinessError {
    STOCK_COULD_NOT_BE_FOUND("S_1", "Stock could not be found by given name"),
    PRICE_MUST_BE_GREATER_THAN_ZERO("S_2", "Given price must be greater than zero");

    private final String code;

    private final String description;
}
