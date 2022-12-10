package com.thing.basket.controller;

import com.thing.basket.domain.Basket;
import com.thing.basket.dto.APIResponseDTO;
import com.thing.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/baskets")
public class BasketController {
    private final BasketService basketService;

    @GetMapping(value = "/items/{item-id}")
    public APIResponseDTO countBasket(@PathVariable("item-id") Integer itemId){
        int count = basketService.countBasket(itemId);
        return APIResponseDTO.success(count);
    }

    @GetMapping(value = "/clients/{client-index}/items/{item-id}")
    public APIResponseDTO showBasket(@PathVariable("client-index") Integer clientIndex, @PathVariable("item-id") Integer itemId){
        boolean exists = basketService.existBasket(clientIndex, itemId);
        return APIResponseDTO.success(exists);
    }

    @PostMapping(value = "/clients/{client-index}/items/{item-id}")
    public APIResponseDTO addBasket(@PathVariable("client-index") Integer clientIndex, @PathVariable("item-id") Integer itemId){
        basketService.addBasket(clientIndex, itemId);
        return APIResponseDTO.success();
    }

    @DeleteMapping(value = "/clients/{client-index}/items/{item-id}")
    public APIResponseDTO deleteBasket(@PathVariable("client-index") Integer clientIndex, @PathVariable("item-id") Integer itemId){
        basketService.deleteBasket(clientIndex, itemId);
        return APIResponseDTO.success();
    }

    @GetMapping(value = "/clients/{client-index}")
    public APIResponseDTO showBasketList(@PathVariable("client-index") Integer clientIndex){
        List<Basket> baskets = basketService.getClientBaskets(clientIndex);
        List<Integer> itemIds = new ArrayList<>();
        for (Basket basket : baskets){
            itemIds.add(basket.getItemId());
        }
        return APIResponseDTO.success(itemIds);
    }

}
