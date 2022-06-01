package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ApiModel("结算汇总")
public class SettleSummaryVo {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "日期")
    private Date businessDate;

    @ApiModelProperty("物资名称")
    private String materialName;

    @ApiModelProperty("期初")
    private BigDecimal beginTotal;

    @ApiModelProperty("发出")
    private BigDecimal outTotal;

    @ApiModelProperty("退入")
    private BigDecimal inTotal;

    @ApiModelProperty("期末")
    private BigDecimal endTotal;

    @ApiModelProperty("备注")
    private String remark;
}
