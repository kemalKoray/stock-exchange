package com.stock_exchange.service.stockexchange;

import com.stock_exchange.api.request.stockexchange.CreateStockExchangeRequest;
import com.stock_exchange.api.response.stockexchange.GetStockExchangeResponse;

public interface StockExchangeService {

    GetStockExchangeResponse getStockExchange(String stockExchangeName);

    void createStockExchange(CreateStockExchangeRequest request);

    void addStock(String stockExchangeName, String stockName);

    void removeStock(String stockExchangeName, String stockName);

}
