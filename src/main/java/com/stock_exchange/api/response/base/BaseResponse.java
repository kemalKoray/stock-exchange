package com.stock_exchange.api.response.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private Boolean isSuccess;
    private String errorCode;
    private String errorDescription;
    private String errorType;
    private T payload;

    public BaseResponse(T payload) {
        this.payload = payload;
    }
}
