package com.ruoyi.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 库存出入库明细对象 inventory_detail
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@ApiModel("物料明细")
public class InventoryDetail extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 出入库表id */
    @Excel(name = "出入库表id" )
    @ApiModelProperty(value = "出入库表id", example = "1")
    private Long inventoryId;

    /** 外部盘扣合同id */
    @Excel(name = "外部盘扣合同id" )
    @ApiModelProperty(value = "外部盘扣合同id", example = "1")
    private Long externalContractId;

    /** 物料分类id */
    @Excel(name = "物料分类id" )
    @ApiModelProperty(value = "物料分类id", example = "1")
    private Long materialCategoryId;

    /** 详细类型id */
    @Excel(name = "详细类型id" )
    @ApiModelProperty(value = "详细类型id", example = "1")
    private Long materialSpecId;

    /**
     * 费用名称id
     */
    @Excel(name = "费用名称id" )
    @ApiModelProperty(value = "费用名称id", example = "1")
    private Long feeId;

    /** 盘扣数量 */
    @Excel(name = "盘扣数量" )
    @ApiModelProperty(value = "盘扣数量", example = "1")
    private Long materialQuantity;

    @Excel(name = "件数" )
    @ApiModelProperty(value = "件数", example = "1")
    private Long packages;

    /** 合计重量 */
    @Excel(name = "合计重量" )
    @ApiModelProperty(value = "合计重量", example = "1")
    private BigDecimal total;


    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setInventoryId(Long inventoryId)
            {
            this.inventoryId = inventoryId;
            }

    public Long getInventoryId()
            {
            return inventoryId;
            }
    public void setMaterialCategoryId(Long materialCategoryId)
            {
            this.materialCategoryId = materialCategoryId;
            }

    public Long getMaterialCategoryId()
            {
            return materialCategoryId;
            }
    public void setMaterialSpecId(Long materialSpecId)
            {
            this.materialSpecId = materialSpecId;
            }

    public Long getMaterialSpecId()
            {
            return materialSpecId;
            }
    public void setMaterialQuantity(Long materialQuantity)
            {
            this.materialQuantity = materialQuantity;
            }

    public Long getMaterialQuantity()
            {
            return materialQuantity;
            }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("inventoryId" ,getInventoryId())
            .append("materialCategoryId" ,getMaterialCategoryId())
            .append("materialSpecId" ,getMaterialSpecId())
            .append("materialQuantity" ,getMaterialQuantity())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
            .append("total" ,getTotal())
            .append("packages" ,getPackages())
        .toString();
        }

    public Long getPackages() {
        return packages;
    }

    public void setPackages(Long packages) {
        this.packages = packages;
    }

    public Long getExternalContractId() {
        return externalContractId;
    }

    public void setExternalContractId(Long externalContractId) {
        this.externalContractId = externalContractId;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }
}
