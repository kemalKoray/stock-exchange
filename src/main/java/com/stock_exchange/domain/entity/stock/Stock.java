package com.stock_exchange.domain.entity.stock;

import com.stock_exchange.domain.entity.base.BaseEntity;
import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import com.stock_exchange.exception.BusinessException;
import com.stock_exchange.exception.enums.stock.StockBusinessError;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "stock")
public class Stock  extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal currentPrice;

    @ManyToMany(mappedBy = "stocks", fetch = FetchType.LAZY)
    private Set<StockExchange> stockExchanges;

    public void updatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException(StockBusinessError.PRICE_MUST_BE_GREATER_THAN_ZERO);
        }
        setCurrentPrice(price);
    }

    public void clearStockExchanges() {
        stockExchanges.clear();
    }

}
