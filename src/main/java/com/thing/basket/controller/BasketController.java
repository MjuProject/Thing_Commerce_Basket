package com.thing.basket.controller;

import com.thing.basket.dto.APIResponseDTO;
import com.thing.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @PostMapping(value = "/clients/{client-index}/items/{item-id}")
    public APIResponseDTO addBasket(@PathVariable("client-index") Integer clientIndex, @PathVariable("item-id") Integer itemId){
        return null;
    }

    @DeleteMapping(value = "/clients/{client-index}/items/{item-id}")
    public APIResponseDTO deleteBasket(@PathVariable("client-index") Integer clientIndex, @PathVariable("item-id") Integer itemId){
        return null;
    }

    @GetMapping(value = "/clients/{client-index}")
    public APIResponseDTO showBasketList(@PathVariable("client-index") Integer clientIndex){
        return null;
    }

}
