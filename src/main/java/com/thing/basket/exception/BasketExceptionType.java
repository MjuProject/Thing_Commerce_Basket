package com.thing.basket.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BasketExceptionType {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),
    BASKET_NOT_FOUND(-5000, "해당 찜이 존재하지 않습니다."),
    DUPLICATION_BASKET(-5001, "이미 찜이 되어있는 물품입니다.");

    private final int code;
    private final String message;

}
