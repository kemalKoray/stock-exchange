package com.stock_exchange.domain.repository.stockexchange.service;

import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import com.stock_exchange.domain.repository.stockexchange.StockExchangeRepository;
import com.stock_exchange.exception.BusinessException;
import com.stock_exchange.exception.enums.stockexchange.StockExchangeBusinessError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockExchangeRepositoryService {

    private final StockExchangeRepository repository;

    public StockExchange findByNameWithStocks(String stockExchangeName) {
        return repository.findByNameWithStocks(stockExchangeName)
                .orElseThrow(() -> new BusinessException(StockExchangeBusinessError.STOCK_EXCHANGE_COULD_NOT_BE_FOUND));
    }
    public StockExchange findByNameWithStocksWithLock(String stockExchangeName) {
        return repository.findByNameWithStocksWithLock(stockExchangeName)
                .orElseThrow(() -> new BusinessException(StockExchangeBusinessError.STOCK_EXCHANGE_COULD_NOT_BE_FOUND));
    }

    public void save(StockExchange stockExchange) {
        repository.save(stockExchange);
    }

}
