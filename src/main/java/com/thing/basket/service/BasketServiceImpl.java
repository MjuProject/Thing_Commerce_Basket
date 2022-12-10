package com.thing.basket.service;
import com.thing.basket.domain.Basket;
import com.thing.basket.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService{
    private final BasketRepository basketRepository;
    @Override
    public Integer countBasket(Integer itemId) {
        return basketRepository.countByItemId(itemId);
    }
    @Override
    @Transactional
    public void addBasket(int clientIndex, int itemId) {
        List<Basket> baskets = basketRepository.findByClientIndexAndItemId(clientIndex, itemId);
        if (!baskets.isEmpty()) {
            return;
        }
        Basket basket = new Basket(null, clientIndex, itemId);
        basketRepository.save(basket);
    }
    @Override
    @Transactional
    public void deleteBasket(int clientIndex, int itemId) {
        List<Basket> baskets = basketRepository.findByClientIndexAndItemId(clientIndex, itemId);
        if (baskets.isEmpty()) {
            return;
        }
        Basket basket = baskets.get(0);
        basketRepository.delete(basket);
    }

    @Override
    public boolean existBasket(int clientIndex, int itemId) {
        List<Basket> baskets = basketRepository.findByClientIndexAndItemId(clientIndex, itemId);
        return !baskets.isEmpty();
    }

    @Override
    public List<Basket> getClientBaskets(int clientIndex) {
        return basketRepository.findByClientIndex(clientIndex);
    }
}
