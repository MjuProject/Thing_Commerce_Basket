package com.thing.basket.repository;
import com.thing.basket.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findByClientIndexAndItemId(int clientIndex, int itemId);
    int countByItemId(int itemId);
    List<Basket> findByClientIndex(int clientIndex);
}
