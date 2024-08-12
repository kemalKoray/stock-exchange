package com.stock_exchange.domain.repository.stockexchange;

import com.stock_exchange.domain.entity.stockexchange.StockExchange;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT se FROM stock_exchange se LEFT JOIN FETCH se.stocks WHERE se.name = :name")
    Optional<StockExchange> findByNameWithStocksWithLock(String name);

    @Query("SELECT se FROM stock_exchange se LEFT JOIN FETCH se.stocks WHERE se.name = :name")
    Optional<StockExchange> findByNameWithStocks(String name);

}
