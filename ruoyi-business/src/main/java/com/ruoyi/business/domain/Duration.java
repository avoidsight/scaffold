package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 统计期间管理对象 duration
 *
 * @author ruoyi
 * @date 2022-03-08
 */
public class Duration extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 起始日期 */
    @Excel(name = "起始日期" )
    private Long startDate;

    /** 结束日期 */
    @Excel(name = "结束日期" )
    private Long endDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getStartDate() {
        return startDate;
    }
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Long getEndDate() {
        return endDate;
    }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("startDate" ,getStartDate())
            .append("endDate" ,getEndDate())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
        }
        }
