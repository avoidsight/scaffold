package com.ruoyi.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 库存出入库杂费明细对象 inventory_fee
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@ApiModel("杂费明细")
public class InventoryFee extends BaseEntity
{
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 出入库表id */
    @Excel(name = "出入库表id" )
    @ApiModelProperty(value = "出入库表id",example = "1")
    private Long inventoryId;

    /** 物料分类id */
    @Excel(name = "物料分类id" )
    @ApiModelProperty(value = "物料分类id",example = "1")
    private Long materialCategoryId;

    /** 详细类型id */
    @Excel(name = "详细类型id" )
    @ApiModelProperty(value = "详细类型id",example = "1")
    private Long materialSpecId;

    /** 杂费名称id */
    @Excel(name = "杂费名称id" )
    @ApiModelProperty(value = "杂费名称id",example = "1")
    private Long feeId;

    /** 收货数量 */
    @Excel(name = "收货数量" )
    @ApiModelProperty(value = "收货数量",example = "1")
    private Long receivedCount;

    /** 计费数量 */
    @Excel(name = "计费数量" )
    @ApiModelProperty(value = "计费数量",example = "1")
    private Long chargedCount;

    /** 金额 */
    @Excel(name = "金额")
    @ApiModelProperty(value = "金额", example = "1.0")
    private BigDecimal totalAmount;




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
    public void setFeeId(Long feeId)
    {
        this.feeId = feeId;
    }

    public Long getFeeId()
    {
        return feeId;
    }
    public void setReceivedCount(Long receivedCount)
    {
        this.receivedCount = receivedCount;
    }

    public Long getReceivedCount()
    {
        return receivedCount;
    }
    public void setChargedCount(Long chargedCount)
    {
        this.chargedCount = chargedCount;
    }

    public Long getChargedCount()
    {
        return chargedCount;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("inventoryId" ,getInventoryId())
                .append("materialCategoryId" ,getMaterialCategoryId())
                .append("materialSpecId" ,getMaterialSpecId())
                .append("feeId" ,getFeeId())
                .append("receivedCount" ,getReceivedCount())
                .append("chargedCount" ,getChargedCount())
                .append("remark" ,getRemark())
                .append("createBy" ,getCreateBy())
                .append("createTime" ,getCreateTime())
                .append("updateBy" ,getUpdateBy())
                .append("updateTime" ,getUpdateTime())
                .append("isDeleted" ,getIsDeleted())
                .append("totalAmount" ,getTotalAmount())
                .toString();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
