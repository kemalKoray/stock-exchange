package com.stock_exchange.api.controller.base;

import com.stock_exchange.api.response.base.BaseResponse;

public abstract class BaseController {

    protected <T> BaseResponse<T> successResponse(T payload) {
        var response = new BaseResponse<>(payload);
        response.setIsSuccess(Boolean.TRUE);
        return response;
    }

    protected <T> BaseResponse<T> successResponse() {
        BaseResponse response = new BaseResponse<Void>();
        response.setIsSuccess(Boolean.TRUE);
        return response;
    }

}
