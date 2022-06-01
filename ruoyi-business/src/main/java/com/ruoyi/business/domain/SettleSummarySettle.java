package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 汇总单与进度单关系对象 settle_summary_settle
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public class SettleSummarySettle extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 汇总单id */
    @Excel(name = "汇总单id" )
    private Long settleSummaryId;

    /** 进度对账单id */
    @Excel(name = "进度对账单id" )
    private Long settleId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setSettleSummaryId(Long settleSummaryId) {
        this.settleSummaryId = settleSummaryId;
    }

    public Long getSettleSummaryId() {
        return settleSummaryId;
    }
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public Long getSettleId() {
        return settleId;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("settleSummaryId" ,getSettleSummaryId())
            .append("settleId" ,getSettleId())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
