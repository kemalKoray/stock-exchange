package com.stock_exchange.domain.entity.stockexchange;

import com.stock_exchange.domain.entity.base.BaseEntity;
import com.stock_exchange.domain.entity.stock.Stock;
import com.stock_exchange.exception.BusinessException;
import com.stock_exchange.exception.enums.stockexchange.StockExchangeBusinessError;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

import static com.stock_exchange.domain.constants.GenericConstants.STOCK_EXCHANGE_LIVE_CONSTANT;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "stock_exchange")
public class StockExchange extends BaseEntity {

    private boolean liveInMarket;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "stock_exchange_stock",
            joinColumns = @JoinColumn(name = "stock_exchange_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private Set<Stock> stocks = new HashSet<>();

    public void addStock(Stock stock) {
        if (stocks.contains(stock)) {
            throw new BusinessException(StockExchangeBusinessError.STOCK_EXISTS);
        }
        checkAndSetIfShouldBeLive();
        stocks.add(stock);
        stock.getStockExchanges().add(this);
    }

    public void removeStock(Stock stock, boolean removeFromStock) {
        if (!stocks.contains(stock)) {
            throw new BusinessException(StockExchangeBusinessError.STOCK_NOT_EXISTS);
        }
        checkAndSetIfShouldNotBeLive();
        stocks.remove(stock);
        if (removeFromStock) {
            stock.getStockExchanges().remove(this);
        }
    }

    private void checkAndSetIfShouldBeLive() {
        int stockSize = stocks.size();
        if (stockSize + 1 >= STOCK_EXCHANGE_LIVE_CONSTANT && !isLiveInMarket()) {
            setLiveInMarket(true);
        }
    }

    private void checkAndSetIfShouldNotBeLive() {
        int stockSize = stocks.size();
        if (stockSize - 1 < STOCK_EXCHANGE_LIVE_CONSTANT && isLiveInMarket()) {
            setLiveInMarket(false);
        }
    }

}
