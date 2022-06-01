package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("库存实况")
public class StockAmountVo {

    @ApiModelProperty("库存总量")
    private BigDecimal stockAmount;

    @ApiModelProperty("自有总量")
    private BigDecimal selfAmount;

    @ApiModelProperty("外借总量")
    private BigDecimal lendingAmount;

    @ApiModelProperty("长期租赁总量")
    private BigDecimal longRentalAmount;

    @ApiModelProperty("短期租赁总量")
    private BigDecimal shortRentalAmount;

    @ApiModelProperty("实时库存")
    private BigDecimal realtimeStock;

    public StockAmountVo calculate() {
        // 库存总量=自有总量+外借总量
        this.stockAmount = selfAmount.add(lendingAmount);
        //实时库存理论=库存总量-长期租赁-短期租赁
        this.realtimeStock = this.stockAmount.subtract(longRentalAmount).subtract(shortRentalAmount);
        return this;
    }
}
