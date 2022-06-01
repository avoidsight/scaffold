package com.ruoyi.business.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进度对账单汇总对象 settle_summary
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public class SettleSummary extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 合同id */
    @Excel(name = "合同id" )
    private Long contractId;

    /** 汇总日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "汇总日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date summaryDate;

    /** 归档日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "归档日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date fileDate;

    /** 附件 */
    @Excel(name = "附件" )
    private String resources;

    /** 汇总单与进度单关系信息 */
    private List<SettleSummarySettle> settleSummarySettleList;

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
    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    public Date getSummaryDate() {
        return summaryDate;
    }
    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("contractId" ,getContractId())
            .append("summaryDate" ,getSummaryDate())
            .append("fileDate" ,getFileDate())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
            .append("resources" ,getResources())
        .toString();
    }
}
