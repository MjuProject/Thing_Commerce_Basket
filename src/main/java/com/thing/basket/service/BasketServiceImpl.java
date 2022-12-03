package com.thing.basket.service;

import com.thing.basket.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService{

    private final BasketRepository basketRepository;

    @Override
    public Integer countBasket(Integer itemId) {
        int count = 2;
        return count;
    }
}
