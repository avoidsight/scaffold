package com.ruoyi.business.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ApiModel("结算单台账列表")
public class SettlementVo {

    /** 结算表id */
    private Long id;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "制单日期")
    private Date createTime;

//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "业务日期")
    private String professionDate;

    @ApiModelProperty("0:采购,1:租赁,2:外借,3:寄存")
    private Long type;

    @ApiModelProperty("供货单位(甲方)")
    private String supplyDepartment;

    @ApiModelProperty("收货单位（乙方）")
    private String collectDepartment;

    @ApiModelProperty("合同编号")
    private String contractCode;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("流水单号")
    private String formCode;

    @ApiModelProperty("业务单号")
    private String businessCode;

    @ApiModelProperty("总重")
    private BigDecimal totalWeight;

    @ApiModelProperty("经办人")
    private String operator;

    /** 0:未归档 2:已归档 */
    @ApiModelProperty("0:未归档 2:已归档")
    private Long status;

}
