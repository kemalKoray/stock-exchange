package com.stock_exchange.service.stock.impl;

import com.stock_exchange.api.request.stock.CreateStockRequest;
import com.stock_exchange.api.request.stock.StockPriceUpdateRequest;
import com.stock_exchange.api.response.stock.GetStockResponse;
import com.stock_exchange.domain.entity.stock.Stock;
import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import com.stock_exchange.domain.repository.stock.service.StockRepositoryService;
import com.stock_exchange.domain.repository.stockexchange.service.StockExchangeRepositoryService;
import com.stock_exchange.service.stock.StockService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.stock_exchange.api.converter.ModelConverterUtil.convertToGetStockResponse;
import static com.stock_exchange.api.converter.ModelConverterUtil.convertToStock;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {

    private final StockRepositoryService stockRepositoryService;
    private final StockExchangeRepositoryService stockExchangeRepositoryService;

    @Override
    public GetStockResponse getStock(String stockName) {
        Stock stock = stockRepositoryService.findByNameWithStockExchanges(stockName);
        return convertToGetStockResponse(stock);
    }

    @Override
    @Transactional
    public void createStock(CreateStockRequest request) {
        stockRepositoryService.save(convertToStock(request));
    }

    @Override
    @Transactional
    public void updatePrice(String stockName, StockPriceUpdateRequest request) {
        Stock stock = stockRepositoryService.findByNameWithLock(stockName);
        stock.updatePrice(request.getPrice());
        stockRepositoryService.save(stock);
    }

    @Override
    @Transactional
    public void deleteStock(String stockName) {
        Stock stock = stockRepositoryService.findByNameWithStockExchangesWithLock(stockName);
        for (StockExchange stockExchange : stock.getStockExchanges()) {
            stockExchange.removeStock(stock, false);
            stockExchangeRepositoryService.save(stockExchange);
        }
        stock.clearStockExchanges();
        stockRepositoryService.delete(stock);
    }

}
