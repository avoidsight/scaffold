package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 合同计费模板对象 contract_billing
 *
 * @author menmenz
 * @date 2022-05-13
 */
public class ContractBilling extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 合同id */
    @Excel(name = "合同id" )
    private Long contractId;

    /** 品名 */
    @Excel(name = "品名" )
    private String billingName;

    /** 费用类型 */
    @Excel(name = "费用类型" )
    private String expenseType;

    /** 物料分类id */
    @Excel(name = "物料分类id" )
    @ApiModelProperty(value = "物料分类id", example = "1")
    private Long materialCategoryId;

    /** 详细类型id */
    @Excel(name = "详细类型id" )
    @ApiModelProperty(value = "详细类型id", example = "1")
    private Long materialSpecId;

    /** 单位 */
    @Excel(name = "单位" )
    private String unit;

    /** 单价 */
    @Excel(name = "单价" )
    private BigDecimal unitPrice;

    /** 税率 */
    @Excel(name = "税率" )
    private BigDecimal rate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getContractId() {
        return contractId;
    }
    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingName() {
        return billingName;
    }
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return expenseType;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("contractId" ,getContractId())
                .append("billingName" ,getBillingName())
                .append("expenseTypeId" ,getExpenseType())
                .append("unit" ,getUnit())
                .append("unitPrice" ,getUnitPrice())
                .append("rate" ,getRate())
                .append("remark" ,getRemark())
                .append("createBy" ,getCreateBy())
                .append("createTime" ,getCreateTime())
                .append("updateBy" ,getUpdateBy())
                .append("updateTime" ,getUpdateTime())
                .append("isDeleted" ,getIsDeleted())
                .toString();
    }

    public Long getMaterialCategoryId() {
        return materialCategoryId;
    }

    public void setMaterialCategoryId(Long materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public Long getMaterialSpecId() {
        return materialSpecId;
    }

    public void setMaterialSpecId(Long materialSpecId) {
        this.materialSpecId = materialSpecId;
    }
}
