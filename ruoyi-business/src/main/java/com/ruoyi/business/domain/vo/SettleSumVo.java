package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("进度对账单汇总全部信息")
public class SettleSumVo {
    private Long id;

    @ApiModelProperty("合同id")
    private Long contractId;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("合同编号")
    private String contractCode;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("附件路径")
    private String resources;

    @ApiModelProperty("对账期")
    private String date;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    @ApiModelProperty("合同签订时间")
    private String signedDate;

    @ApiModelProperty("进度对账单汇总")
    private List<SummaryVo> summaryVoList;

    @ApiModelProperty("进度对账单汇总备注")
    private String remark;

    @ApiModelProperty("对账类型")
    private Integer type;

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
}
