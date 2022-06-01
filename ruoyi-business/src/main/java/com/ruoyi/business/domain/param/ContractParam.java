package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel("合同查询参数")
public class ContractParam {
    @ApiModelProperty(value = "开始日期", example = "2022-03-21")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "结束日期", example = "2022-03-25")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "合同名称", example = "测试合同")
    private String contractName;

    @ApiModelProperty(value = "合同类型", example = "1")
    private Integer type;
}
