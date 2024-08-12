package com.stock_exchange.domain.repository.stock.service;

import com.stock_exchange.domain.entity.stock.Stock;
import com.stock_exchange.domain.repository.stock.StockRepository;
import com.stock_exchange.exception.BusinessException;
import com.stock_exchange.exception.enums.stock.StockBusinessError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockRepositoryService {

    private final StockRepository repository;

    public Stock findByName(String stockName) {
        return repository.findByName(stockName)
                .orElseThrow(() -> new BusinessException(StockBusinessError.STOCK_COULD_NOT_BE_FOUND));
    }

    public Stock findByNameWithStockExchangesWithLock(String stockName) {
        return repository.findByNameWithStockExchangesWithLock(stockName)
                .orElseThrow(() -> new BusinessException(StockBusinessError.STOCK_COULD_NOT_BE_FOUND));
    }

    public Stock findByNameWithStockExchanges(String stockName) {
        return repository.findByNameWithStockExchanges(stockName)
                .orElseThrow(() -> new BusinessException(StockBusinessError.STOCK_COULD_NOT_BE_FOUND));
    }

    public void save(Stock stock) {
        repository.save(stock);
    }

    public void delete(Stock stock) {
        repository.delete(stock);
    }

}
