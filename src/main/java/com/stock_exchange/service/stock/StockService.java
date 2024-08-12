package com.stock_exchange.service.stock;

import com.stock_exchange.api.request.stock.CreateStockRequest;
import com.stock_exchange.api.request.stock.StockPriceUpdateRequest;
import com.stock_exchange.api.response.stock.GetStockResponse;

public interface StockService {

    GetStockResponse getStock(String stockName);

    void createStock(CreateStockRequest request);

    void updatePrice(String stockName, StockPriceUpdateRequest request);

    void deleteStock(String stockName);

}
