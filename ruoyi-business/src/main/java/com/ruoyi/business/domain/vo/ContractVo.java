package com.ruoyi.business.domain.vo;

import com.ruoyi.business.domain.Contract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/7 3:45 PM
 */
@Data
@ApiModel("合同详情")
public class ContractVo extends Contract {
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    @ApiModelProperty("采购乙方")
    private String purchaseSupplierName;

    @ApiModelProperty("租赁甲方")
    private String rentalLesseeName;

    @ApiModelProperty("外借乙方")
    private String lendingSupplierName;

    @ApiModelProperty("寄存乙方")
    private String bailmentLesseeName;

    @ApiModelProperty("组织名称")
    @Deprecated
    private String deptName;

    @ApiModelProperty("客户名称")
    @Deprecated
    private String customerName;

    @ApiModelProperty("计费模板名称")
    private String templateName;
}
