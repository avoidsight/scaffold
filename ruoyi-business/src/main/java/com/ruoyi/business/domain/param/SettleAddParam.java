package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel("新建进度单参数")
public class SettleAddParam {
    @ApiModelProperty(value = "合同id", example = "1")
    private Long contractId;

    @ApiModelProperty(value = "出入库单id数组", example = "1,2,3")
    private Long[] inventoryIds;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "对账开始日期",example = "2022-03-18")
    private Date reconciliationStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "对账结束日期",example = "2022-03-19")
    private Date reconciliationEndDate;

    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;
}
