package com.stock_exchange.domain.repository.stock;

import com.stock_exchange.domain.entity.stock.Stock;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM stock s LEFT JOIN FETCH s.stockExchanges WHERE s.name = :name")
    Optional<Stock> findByNameWithStockExchangesWithLock(String name);

    @Query("SELECT s FROM stock s LEFT JOIN FETCH s.stockExchanges WHERE s.name = :name")
    Optional<Stock> findByNameWithStockExchanges(String name);

    Optional<Stock> findByName(String name);

}
