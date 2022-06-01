package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 进度对账单对象 settle
 *
 * @author ruoyi
 * @date 2022-05-03
 */
public class Settle extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 合同id */
    @Excel(name = "合同id" )
    private Long contractId;

    /**
     * 对账开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "对账开始日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date reconciliationStartDate;

    /**
     * 对账结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "对账结束日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date reconciliationEndDate;

    /** 理论入库(供应商/中成) */
    @Excel(name = "理论入库(供应商/中成)" )
    private BigDecimal theoreticalInTotal;

    /** 理论出库(供应商/中成) */
    @Excel(name = "理论出库(供应商/中成)" )
    private BigDecimal theoreticalOutTotal;

    /** 仓库称重入库 */
    @Excel(name = "仓库称重入库" )
    private BigDecimal warehouseInTotal;

    /** 仓库称重出库 */
    @Excel(name = "仓库称重出库" )
    private BigDecimal warehouseOutTotal;

    /** 场地称重入库 */
    @Excel(name = "场地称重入库" )
    private BigDecimal sceneInTotal;

    /** 场地称重出库 */
    @Excel(name = "场地称重出库" )
    private BigDecimal sceneOutTotal;

    /** 0:未结算1:已结算2:已归档 */
    @Excel(name = "0:未结算1:已结算2:已归档" )
    private Long status;

    /** 进度单出入库单关系信息 */
    private List<SettleInventory> settleInventoryList;

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
    public void setTheoreticalInTotal(BigDecimal theoreticalInTotal) {
        this.theoreticalInTotal = theoreticalInTotal;
    }

    public BigDecimal getTheoreticalInTotal() {
        return theoreticalInTotal;
    }
    public void setTheoreticalOutTotal(BigDecimal theoreticalOutTotal) {
        this.theoreticalOutTotal = theoreticalOutTotal;
    }

    public BigDecimal getTheoreticalOutTotal() {
        return theoreticalOutTotal;
    }
    public void setWarehouseInTotal(BigDecimal warehouseInTotal) {
        this.warehouseInTotal = warehouseInTotal;
    }

    public BigDecimal getWarehouseInTotal() {
        return warehouseInTotal;
    }
    public void setWarehouseOutTotal(BigDecimal warehouseOutTotal) {
        this.warehouseOutTotal = warehouseOutTotal;
    }

    public BigDecimal getWarehouseOutTotal() {
        return warehouseOutTotal;
    }
    public void setSceneInTotal(BigDecimal sceneInTotal) {
        this.sceneInTotal = sceneInTotal;
    }

    public BigDecimal getSceneInTotal() {
        return sceneInTotal;
    }
    public void setSceneOutTotal(BigDecimal sceneOutTotal) {
        this.sceneOutTotal = sceneOutTotal;
    }

    public BigDecimal getSceneOutTotal() {
        return sceneOutTotal;
    }
    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public List<SettleInventory> getSettleInventoryList() {
        return settleInventoryList;
    }

    public void setSettleInventoryList(List<SettleInventory> settleInventoryList) {
        this.settleInventoryList= settleInventoryList;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("contractId" ,getContractId())
                .append("theoreticalInTotal" ,getTheoreticalInTotal())
                .append("theoreticalOutTotal" ,getTheoreticalOutTotal())
                .append("warehouseInTotal" ,getWarehouseInTotal())
                .append("warehouseOutTotal" ,getWarehouseOutTotal())
                .append("sceneInTotal" ,getSceneInTotal())
                .append("sceneOutTotal" ,getSceneOutTotal())
                .append("status" ,getStatus())
                .append("remark" ,getRemark())
                .append("createBy" ,getCreateBy())
                .append("createTime" ,getCreateTime())
                .append("updateBy" ,getUpdateBy())
                .append("updateTime" ,getUpdateTime())
                .append("isDeleted" ,getIsDeleted())
                .append("settleInventoryList" ,getSettleInventoryList())
                .toString();
    }

    public Date getReconciliationStartDate() {
        return reconciliationStartDate;
    }

    public void setReconciliationStartDate(Date reconciliationStartDate) {
        this.reconciliationStartDate = reconciliationStartDate;
    }

    public Date getReconciliationEndDate() {
        return reconciliationEndDate;
    }

    public void setReconciliationEndDate(Date reconciliationEndDate) {
        this.reconciliationEndDate = reconciliationEndDate;
    }
}
