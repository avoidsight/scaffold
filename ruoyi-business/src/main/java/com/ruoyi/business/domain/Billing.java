package com.ruoyi.business.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计费模板对象 billing
 *
 * @author ruoyi
 * @date 2022-03-15
 */
public class Billing extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 模板名称 */
    @Excel(name = "模板名称" )
    private String templateName;

    /** 计费模板明细信息 */
    private List<BillingDetail> billingDetailList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public List<BillingDetail> getBillingDetailList() {
        return billingDetailList;
    }

    public void setBillingDetailList(List<BillingDetail> billingDetailList) {
        this.billingDetailList= billingDetailList;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("templateName" ,getTemplateName())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
            .append("billingDetailList" ,getBillingDetailList())
        .toString();
    }
}
