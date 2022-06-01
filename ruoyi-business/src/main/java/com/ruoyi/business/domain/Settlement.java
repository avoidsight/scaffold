package com.ruoyi.business.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.domain.vo.LeaseSettlementChecklistVo;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 结算对象 settlement
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public class Settlement extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 进度对账单id */
    @Excel(name = "进度对账单id" )
    private Long settleId;

    /** 结算日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "结算日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date settlementDate;

    /** 归档日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "归档日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date fileDate;

    /** 0:未归档 2:已归档 */
    @Excel(name = "0:未归档 2:已归档" )
    private Long status;

    /** 合同id */
    @Excel(name = "合同id" )
    private Long contractId;

    /** 总实际结算重量 */
    @Excel(name = "总实际结算重量" )
    private BigDecimal totalWeight;

    /** 总实际结算重量 */
    @Excel(name = "总实际金额" )
    private BigDecimal totalMoney;

    /** 附件(,分割) */
    @Excel(name = "附件(,分割)" )
    @ApiModelProperty("附件")
    private String resources;

    /*
    * 该条结算数据对应的子表数据
    * */
    private List<LeaseSettlementChecklistVo> leaseSettlementChecklistVos;

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
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }
    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Date getFileDate() {
        return fileDate;
    }
    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getContractId() {
        return contractId;
    }
    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public List<LeaseSettlementChecklistVo> getLeaseSettlementChecklistVos() {
        return leaseSettlementChecklistVos;
    }

    public void setLeaseSettlementChecklistVos(List<LeaseSettlementChecklistVo> leaseSettlementChecklistVos) {
        this.leaseSettlementChecklistVos = leaseSettlementChecklistVos;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("settleId" ,getSettleId())
            .append("settlementDate" ,getSettlementDate())
            .append("fileDate" ,getFileDate())
            .append("status" ,getStatus())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
            .append("contractId" ,getContractId())
            .append("totalWeight" ,getTotalWeight())
            .append("resources" ,getResources())
            .append("leaseSettlementChecklistVos" ,getLeaseSettlementChecklistVos())
            .append("totalMoney" ,getTotalMoney())
        .toString();
    }
}
