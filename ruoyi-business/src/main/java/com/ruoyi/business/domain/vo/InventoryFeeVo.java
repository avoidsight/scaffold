package com.ruoyi.business.domain.vo;

import com.ruoyi.business.domain.InventoryFee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/23 9:14 AM
 */
@Data
@ApiModel("杂费详情明细")
public class InventoryFeeVo extends InventoryFee {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("型号规格")
    private String specsName;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("单价")
    private BigDecimal unitPrice;

}
