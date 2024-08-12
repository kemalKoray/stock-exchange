package com.stock_exchange.api.converter;

import com.stock_exchange.api.request.stock.CreateStockRequest;
import com.stock_exchange.api.request.stockexchange.CreateStockExchangeRequest;
import com.stock_exchange.api.response.stock.GetStockResponse;
import com.stock_exchange.api.response.stock.StockDto;
import com.stock_exchange.api.response.stockexchange.GetStockExchangeResponse;
import com.stock_exchange.api.response.stockexchange.StockExchangeDto;
import com.stock_exchange.domain.entity.stock.Stock;
import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelConverterUtil {

    public static GetStockExchangeResponse convertToGetStockExchangeResponse(StockExchange stockExchange) {
        return GetStockExchangeResponse.builder()
                .name(stockExchange.getName())
                .description(stockExchange.getDescription())
                .liveInMarket(stockExchange.isLiveInMarket())
                .stocks(stockExchange.getStocks().stream().map(stock -> StockDto.builder()
                        .name(stock.getName())
                        .description(stock.getDescription())
                        .currentPrice(stock.getCurrentPrice())
                        .lastUpdate(stock.getLastUpdate()).build()).collect(Collectors.toSet()))
                .build();

    }

    public static GetStockResponse convertToGetStockResponse(Stock stock) {
        return GetStockResponse.builder()
                .name(stock.getName())
                .description(stock.getDescription())
                .currentPrice(stock.getCurrentPrice())
                .stockExchanges(stock.getStockExchanges().stream().map(stockExchange -> StockExchangeDto.builder()
                        .name(stockExchange.getName())
                        .description(stockExchange.getDescription())
                        .liveInMarket(stockExchange.isLiveInMarket()).build()).collect(Collectors.toSet()))
                .build();
    }

    public static Stock convertToStock(CreateStockRequest request) {
        return Stock.builder()
                .name(request.getName())
                .description(request.getDescription())
                .currentPrice(request.getPrice())
                .build();
    }

    public static StockExchange convertToStockExchange(CreateStockExchangeRequest request) {
        return StockExchange.builder()
                .name(request.getName())
                .description(request.getDescription())
                .liveInMarket(false)
                .build();
    }
}
