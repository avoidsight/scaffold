package com.ruoyi.business.controller;

import com.ruoyi.business.service.IStockService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "库存管理")
@RestController
@RequestMapping("/api/v2/business/stock" )
public class StockController extends BaseController {
    @Autowired
    private IStockService stockService;

    @GetMapping("/realtime/amount")
    @ApiOperation("查询库存实况总量")
    public AjaxResult selectRealtimeStockAmount() {
        return AjaxResult.success(stockService.selectRealtimeStockAmount());
    }

    @GetMapping("/realtime/detail")
    @ApiOperation("查询实时库存明细")
    public TableDataInfo selectRealtimeStockDetail() {
        startPage();
        return getDataTable(stockService.selectRealtimeStockDetail());
    }

    @GetMapping("/longRental/detail")
    @ApiOperation("查询长期租赁明细")
    public TableDataInfo selectLongRentalDetail() {
        startPage();
        return getDataTable(stockService.selectLongRentalDetail());
    }
}
