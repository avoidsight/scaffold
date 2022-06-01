package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("结算重量")
public class SettleWeight {
    @ApiModelProperty("已结算的重量")
    private BigDecimal settledWeight;

    @ApiModelProperty("未结算的重量")
    private BigDecimal unSettledWeight;
}
