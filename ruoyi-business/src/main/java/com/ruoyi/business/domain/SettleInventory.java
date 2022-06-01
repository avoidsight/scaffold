package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进度单出入库单关系对象 settle_inventory
 *
 * @author ruoyi
 * @date 2022-05-03
 */
public class SettleInventory extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 进度对账单id */
    @Excel(name = "进度对账单id" )
    private Long settleId;

    /** 出入库单id */
    @Excel(name = "出入库单id" )
    private Long inventoryId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public Long getSettleId() {
        return settleId;
    }
    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("settleId" ,getSettleId())
                .append("inventoryId" ,getInventoryId())
                .append("createBy" ,getCreateBy())
                .append("createTime" ,getCreateTime())
                .append("updateBy" ,getUpdateBy())
                .append("updateTime" ,getUpdateTime())
                .append("isDeleted" ,getIsDeleted())
                .toString();
    }
}
