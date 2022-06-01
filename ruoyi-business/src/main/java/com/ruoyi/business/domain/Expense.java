package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用类型设置对象 expense
 *
 * @author ruoyi
 * @date 2022-03-09
 */
public class Expense extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id作为主键
     */
    private Long id;

    /**
     * 费用名称
     */
    @Excel(name = "费用名称")
    private String expenseName;

    /**
     * 费用类型
     */
    @Excel(name = "费用类型")
    private Long expenseType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseType(Long expenseType) {
        this.expenseType = expenseType;
    }

    public Long getExpenseType() {
        return expenseType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("expenseName", getExpenseName())
                .append("expenseType", getExpenseType())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}
