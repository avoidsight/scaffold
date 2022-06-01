package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel("进度对账参数")
public class SettleParam {

    @ApiModelProperty(value = "合同id", example = "1")
    private Long contractId;

    @ApiModelProperty(value = "开始日期", example = "2022-03-21")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    @ApiModelProperty(value = "结束日期", example = "2022-03-25")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    @ApiModelProperty(value = "对账类型", example = "0")
    private Integer contractType;

    @ApiModelProperty(value = "汇总状态(0:未结算 1:已结算 2:已归档)", example = "0")
    private Integer status;
}
