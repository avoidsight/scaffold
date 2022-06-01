package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 结算明细对象 settlement_detail
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public class SettlementDetail extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 结算单id */
    @Excel(name = "结算单id" )
    private Long settlementId;

    /** 出入库单id */
    @Excel(name = "出入库单id" )
    private Long inventoryId;

    /** 实际结算重量 */
    @Excel(name = "实际结算重量" )
    private BigDecimal realWeight;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public Long getSettlementId() {
        return settlementId;
    }
    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }
    public void setRealWeight(BigDecimal realWeight) {
        this.realWeight = realWeight;
    }

    public BigDecimal getRealWeight() {
        return realWeight;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("settlementId" ,getSettlementId())
            .append("inventoryId" ,getInventoryId())
            .append("realWeight" ,getRealWeight())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
