package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ApiModel("进度对账列表")
public class SettleListVo {
    @ApiModelProperty("进度单id")
    private Integer settleId;

    @ApiModelProperty("合同id")
    private Integer contractId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "日期")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "对账开始日期")
    private Date reconciliationStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "对账结束日期")
    private Date reconciliationEndDate;

    @ApiModelProperty("合同编号")
    private String contractCode;

    @ApiModelProperty("合同类型")
    private Integer contractType;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("理论入库(kg)")
    private BigDecimal theoreticalInTotal;

    @ApiModelProperty("理论出库(kg)")
    private BigDecimal theoreticalOutTotal;

    @ApiModelProperty("仓库称重入库(kg)")
    private BigDecimal warehouseInTotal;

    @ApiModelProperty("仓库称重出库(kg)")
    private BigDecimal warehouseOutTotal;

    @ApiModelProperty("场地称重入库(kg)")
    private BigDecimal sceneInTotal;

    @ApiModelProperty("场地称重出库(kg)")
    private BigDecimal sceneOutTotal;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态0:未结算 1:已结算 2:已归档")
    private Integer status;
}
