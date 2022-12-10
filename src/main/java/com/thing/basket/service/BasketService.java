package com.thing.basket.service;
import com.thing.basket.domain.Basket;
import java.util.List;

public interface BasketService {
    Integer countBasket(Integer itemId);
    void addBasket(int clientIndex, int itemId);
    void deleteBasket(int clientIndex, int itemId);
    boolean existBasket(int clientIndex, int itemId);
    List<Basket> getClientBaskets(int clientIndex);
}
