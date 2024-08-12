package com.stock_exchange.api.controller.stockexchange;

import com.stock_exchange.api.controller.base.BaseController;
import com.stock_exchange.api.request.stockexchange.AddStockRequest;
import com.stock_exchange.api.request.stockexchange.CreateStockExchangeRequest;
import com.stock_exchange.api.response.base.BaseResponse;
import com.stock_exchange.api.response.stockexchange.GetStockExchangeResponse;
import com.stock_exchange.service.stockexchange.StockExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.stock_exchange.api.HeaderConstants.X_ACCESS_TOKEN;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/stock-exchange")
public class StockExchangeController extends BaseController {

    private final StockExchangeService service;

    @GetMapping("/{name}")
    @Operation(summary = "Gets stock exchange", description = "Gets stock exchange and all of its stocks")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<GetStockExchangeResponse> getStockExchange(@Parameter(description = "stock exchange name") @PathVariable("name") String stockExchangeName) {
        return successResponse(service.getStockExchange(stockExchangeName));
    }

    @PostMapping
    @Operation(summary = "Creates stock exchange", description = "Creates stock exchange with given parameters")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> createStockExchange(@Valid @RequestBody CreateStockExchangeRequest request) {
        service.createStockExchange(request);
        return successResponse();
    }

    @PostMapping("/{name}")
    @Operation(summary = "Add stock to stock exchange", description = "Adds stock with given stock name to stock exchange with given stock exchange name")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> addStock(@Parameter(description = "stock exchange name") @PathVariable("name") String stockExchangeName,
                                       @Valid @RequestBody AddStockRequest request) {
        service.addStock(stockExchangeName, request.getStockName());
        return successResponse();
    }

    @DeleteMapping("/{name}/{stock-name}")
    @Operation(summary = "Removes stock from stock exchange", description = "Removes stock with given stock name from stock exchange with given stock exchange name")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> removeStock(@Parameter(description = "stock exchange name") @PathVariable("name") String stockExchangeName,
                                          @Parameter(description = "stock name") @PathVariable("stock-name") String stockName) {
        service.removeStock(stockExchangeName, stockName);
        return successResponse();
    }
}
