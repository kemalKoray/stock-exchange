package com.stock_exchange.api.controller.stock;

import com.stock_exchange.api.controller.base.BaseController;
import com.stock_exchange.api.request.stock.CreateStockRequest;
import com.stock_exchange.api.request.stock.StockPriceUpdateRequest;
import com.stock_exchange.api.response.base.BaseResponse;
import com.stock_exchange.api.response.stock.GetStockResponse;
import com.stock_exchange.service.stock.StockService;
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
@RequestMapping(value = "/api/v1/stock")
public class StockController extends BaseController {

    private final StockService service;

    @GetMapping("/{name}")
    @Operation(summary = "Gets stock by stock name", description = "Gets stock and related stock exchanges by given stock name")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<GetStockResponse> getStock(@Parameter(description = "stock name") @PathVariable("name") String stockName) {
        return successResponse(service.getStock(stockName));
    }

    @PostMapping
    @Operation(summary = "Creates stock", description = "Creates stock with given parameters")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> createStock(@Valid @RequestBody CreateStockRequest request) {
        service.createStock(request);
        return successResponse();
    }

    @PatchMapping("/{name}")
    @Operation(summary = "Updates price", description = "Updates the price of the stock with given name")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> updatePrice(@Parameter(description = "stock name") @PathVariable("name") String stockName,
                                          @Valid @RequestBody StockPriceUpdateRequest request) {
        service.updatePrice(stockName, request);
        return successResponse();
    }

    @DeleteMapping("/{name}")
    @Operation(summary = "Deletes stock", description = "Deletes the stock with given name and removes it from all stock exchanges to which it is linked")
    @Parameter(name = X_ACCESS_TOKEN, in = ParameterIn.HEADER, schema = @Schema(type = "String"))
    public BaseResponse<Void> deleteStock(@Parameter(description = "stock name") @PathVariable("name") String stockName) {
        service.deleteStock(stockName);
        return successResponse();
    }
}
