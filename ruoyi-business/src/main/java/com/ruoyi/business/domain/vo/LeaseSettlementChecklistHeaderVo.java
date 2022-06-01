package com.ruoyi.business.domain.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("结算单台账列表头部数据")
public class LeaseSettlementChecklistHeaderVo {

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("合同Id")
    private Long contractId;

    @ApiModelProperty("合同编码")
    private String contractCode;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("附件")
    private String resources;

    @ApiModelProperty("租金日期")
    private String rentalDate;

    @ApiModelProperty("结算id")
    private Long id;

    @ApiModelProperty("实际总金额")
    private BigDecimal totalMoney;

    @ApiModelProperty("总实际结算重量")
    private BigDecimal totalWeight;

    @ApiModelProperty("进度对账单id")
    private Long settleId;

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


    @ApiModelProperty("0:采购,1:租赁,2:外借,3:寄存")
    private Long type;

    @ApiModelProperty("0:未归档；2：已归档")
    private Long status;

}
