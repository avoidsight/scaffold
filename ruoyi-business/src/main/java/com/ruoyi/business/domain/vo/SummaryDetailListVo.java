package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("进度对账单明细表字段")
public class SummaryDetailListVo {
    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("型号规格")
    private String specsName;

    @ApiModelProperty("数量")
    private Integer number;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("单件重量（kg）")
    private BigDecimal singleWeight;

    @ApiModelProperty("重量（kg）")
    private BigDecimal weight;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("费用类型")
    private String expenseType;
}
