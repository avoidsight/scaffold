package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 外部物料信息对象 external_material
 *
 * @author menmenz
 * @date 2022-04-12
 */
public class ExternalMaterial extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 合同id */
    @Excel(name = "合同id" )
    @ApiModelProperty("合同id" )
    private Long contractId;

    /** 物料分类id */
    @Excel(name = "物料分类id" )
    @ApiModelProperty("物料分类id" )
    private Long materialCategoryId;

    /** 详细类型id */
    @Excel(name = "详细类型id" )
    @ApiModelProperty("详细类型id" )
    private Long materialSpecId;

    /** 单件重量，公斤 */
    @Excel(name = "单件重量，公斤" )
    @ApiModelProperty("单件重量，公斤" )
    private BigDecimal singleWeight;

    /** 供应商id */
    @Excel(name = "供应商id" )
    @ApiModelProperty("供应商id" )
    private Long supplierId;

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
    public void setMaterialCategoryId(Long materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public Long getMaterialCategoryId() {
        return materialCategoryId;
    }
    public void setMaterialSpecId(Long materialSpecId) {
        this.materialSpecId = materialSpecId;
    }

    public Long getMaterialSpecId() {
        return materialSpecId;
    }
    public void setSingleWeight(BigDecimal singleWeight) {
        this.singleWeight = singleWeight;
    }

    public BigDecimal getSingleWeight() {
        return singleWeight;
    }
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("contractId" ,getContractId())
                .append("materialCategoryId" ,getMaterialCategoryId())
                .append("materialSpecId" ,getMaterialSpecId())
                .append("singleWeight" ,getSingleWeight())
                .append("supplierId" ,getSupplierId())
                .toString();
    }
}