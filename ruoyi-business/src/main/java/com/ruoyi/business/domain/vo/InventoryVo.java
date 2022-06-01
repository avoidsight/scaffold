package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/21 11:38 AM
 */
@Data
@ApiModel("出入库列表")
public class InventoryVo {
    @ApiModelProperty("出入库单id")
    private Integer inventoryId;

    @ApiModelProperty("制单日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp createTime;

    @ApiModelProperty("业务日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp businessTime;

    @ApiModelProperty("入库类型")
    private Integer contractType;

    @ApiModelProperty("出入库类型")
    private Integer stockType;

    @ApiModelProperty("供货单位")
    private String supplierName;

    @ApiModelProperty("甲方")
    private String partA;

    @ApiModelProperty("乙方")
    private String partB;

    @ApiModelProperty("合同编号")
    private String contractCode;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("流水单号")
    private String flowNo;

    @ApiModelProperty("业务单号")
    private String businessNo;

    @ApiModelProperty("总重(kg)")
    private BigDecimal total;

    @ApiModelProperty("经办人")
    private String operator;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("出入库单状态")
    private Integer status;


}