package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel("结算单台账参数")
public class BillingAccountParam {
    @ApiModelProperty(value = "名称", example = "ZL-16727277218"    )
    private String name;

    @ApiModelProperty(value = "开始日期", example = "2022-03-21")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    @ApiModelProperty(value = "结束日期", example = "2022-03-25")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    @ApiModelProperty(value = "入库类型", example = "0")
    private Integer contractType;

}
