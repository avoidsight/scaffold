package com.ruoyi.business.domain.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("结算单台账列表")
public class SettlementFeesVo {

    @ApiModelProperty("费用类型")
    private String typesOfFee;

    @ApiModelProperty("物料名称")
    private String materialName;

    @ApiModelProperty("规格")
    private String standard;

    @ApiModelProperty("费用名称")
    private String feeName;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("数量")
    private BigDecimal counts;

    @ApiModelProperty("单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("金额")
    private BigDecimal money;

    @ApiModelProperty("税率")
    private BigDecimal rate;
}
