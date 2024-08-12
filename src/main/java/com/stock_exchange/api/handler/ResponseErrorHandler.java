package com.stock_exchange.api.handler;

import com.stock_exchange.api.response.base.BaseResponse;
import com.stock_exchange.exception.BusinessException;
import com.stock_exchange.exception.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ResponseErrorHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Void> businessException(BusinessException exception) {
        log.error("Business exception occurred : Error code: {} || Error description : {}",
                exception.getBusinessError().getCode(), exception.getBusinessError().getDescription(), exception);
        BaseResponse<Void> response = new BaseResponse<>();
        response.setErrorCode(exception.getBusinessError().getCode());
        response.setErrorDescription(exception.getBusinessError().getDescription());
        response.setErrorType(ErrorType.BUSINESS.toString());
        response.setIsSuccess(Boolean.FALSE);

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Method argument violation exception occurred : Error description : {}", exception.getMessage(), exception);
        String errorSummary = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .distinct()
                .collect(Collectors.joining(", "));
        BaseResponse<Void> response = new BaseResponse<>();
        response.setErrorDescription("Validation failed for fields: " + errorSummary);
        response.setErrorType(ErrorType.CONSTRAINT_VIOLATION.toString());
        response.setIsSuccess(Boolean.FALSE);

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Void> exception(Exception exception) {
        log.error("Unhandled exception occurred : Error description : {}", exception.getMessage(), exception);
        BaseResponse<Void> response = new BaseResponse<>();
        response.setErrorDescription(exception.getMessage());
        response.setErrorType(ErrorType.INTERNAL.toString());
        response.setIsSuccess(Boolean.FALSE);

        return response;
    }

}
