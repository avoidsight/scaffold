package com.ruoyi.business.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("进度对账单台账查询参数")
public class SettleSummarySearchParam {
    private String date;

    @ApiModelProperty(value = "对账类型(0:采购,1:租赁,2:外借,3:寄存)", example = "0")
    private Long type;

    @ApiModelProperty(value = "模糊查询字段",example = "羿云合同")
    private String content;
}
