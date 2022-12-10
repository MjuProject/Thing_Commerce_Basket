package com.thing.basket.advice;

import com.thing.basket.dto.APIResponseDTO;
import com.thing.basket.exception.BasketExceptionType;
import com.thing.basket.exception.BasketNotFoundException;
import com.thing.basket.exception.DuplicateBasketException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BasketExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO unknown(Exception e){
        log.error("unknown exception", e);
        BasketExceptionType exceptionType = BasketExceptionType.UNKNOWN;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(BasketNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO basketNotFoundException(){
        BasketExceptionType exceptionType = BasketExceptionType.BASKET_NOT_FOUND;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(DuplicateBasketException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO duplicateBasketException(){
        BasketExceptionType exceptionType = BasketExceptionType.BASKET_NOT_FOUND;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

}
