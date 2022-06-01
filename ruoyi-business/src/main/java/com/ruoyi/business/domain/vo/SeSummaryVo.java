package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("进度对账单汇总台账")
public class SeSummaryVo {
    @ApiModelProperty("id主键")
    private Long id;

    @ApiModelProperty("合同id")
    private Long contractId;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("合同编号")
    private String contractCode;

    @ApiModelProperty("0:采购,1:租赁,2:外借,3:寄存")
    private Integer type;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    @ApiModelProperty("汇总日期")
    private Date summaryDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "对账期")
    private String reconciliationPeriod;

    @ApiModelProperty("采购-甲方")
    private String purchaseDeptName;

    @ApiModelProperty("采购-乙方")
    private String purchaseSupplierName;

    @ApiModelProperty("租赁-甲方")
    private String rentalLesseeName;

    @ApiModelProperty("租赁-乙方")
    private String rentalDeptName;

    @ApiModelProperty("外借-甲方")
    private String lendingDeptName;

    @ApiModelProperty("外借-乙方")
    private String lendingSupplierName;

    @ApiModelProperty("寄存-甲方")
    private String bailmentDeptName;

    @ApiModelProperty("寄存-乙方")
    private String bailmentLesseeName;

    @ApiModelProperty("供货单位(甲方)")
    private String supplyDepartment;

    @ApiModelProperty("收货单位（乙方）")
    private String collectDepartment;
}
