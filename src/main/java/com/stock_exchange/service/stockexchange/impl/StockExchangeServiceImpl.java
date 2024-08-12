package com.stock_exchange.service.stockexchange.impl;

import com.stock_exchange.api.request.stockexchange.CreateStockExchangeRequest;
import com.stock_exchange.api.response.stockexchange.GetStockExchangeResponse;
import com.stock_exchange.domain.entity.stock.Stock;
import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import com.stock_exchange.domain.repository.stock.service.StockRepositoryService;
import com.stock_exchange.domain.repository.stockexchange.service.StockExchangeRepositoryService;
import com.stock_exchange.service.stockexchange.StockExchangeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.stock_exchange.api.converter.ModelConverterUtil.convertToGetStockExchangeResponse;
import static com.stock_exchange.api.converter.ModelConverterUtil.convertToStockExchange;

@RequiredArgsConstructor
@Service
public class StockExchangeServiceImpl implements StockExchangeService {

    private final StockExchangeRepositoryService stockExchangeRepositoryService;
    private final StockRepositoryService stockRepositoryService;

    @Override
    public GetStockExchangeResponse getStockExchange(String stockExchangeName) {
        StockExchange stockExchange = stockExchangeRepositoryService.findByNameWithStocks(stockExchangeName);
        return convertToGetStockExchangeResponse(stockExchange);
    }

    @Transactional
    @Override
    public void createStockExchange(CreateStockExchangeRequest request) {
        stockExchangeRepositoryService.save(convertToStockExchange(request));
    }

    @Transactional
    @Override
    public void addStock(String stockExchangeName, String stockName) {
        StockExchange stockExchange = stockExchangeRepositoryService.findByNameWithStocksWithLock(stockExchangeName);
        Stock stock = stockRepositoryService.findByName(stockName);
        stockExchange.addStock(stock);
        stockExchangeRepositoryService.save(stockExchange);
        stockRepositoryService.save(stock);
    }

    @Transactional
    @Override
    public void removeStock(String stockExchangeName, String stockName) {
        StockExchange stockExchange = stockExchangeRepositoryService.findByNameWithStocksWithLock(stockExchangeName);
        Stock stock = stockRepositoryService.findByName(stockName);
        stockExchange.removeStock(stock, true);
        stockExchangeRepositoryService.save(stockExchange);
        stockRepositoryService.save(stock);
    }

}
