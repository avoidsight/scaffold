package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.domain.vo.ContractVo;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * 库存出入库对象 inventory
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@ApiModel("出入库单")
public class Inventory extends BaseEntity{
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    @ApiModelProperty(value = "主键", example = "1")
    private Long id;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "业务日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    @ApiModelProperty(value = "业务日期", example = "2022-03-22")
    private Date businessDate;

    /** 流水单号 */
    @Excel(name = "流水单号" )
    @ApiModelProperty(value = "流水单号(合同类型+时间戳)", example = "ZL-12344123")
    private String flowNo;

    /** 业务单号 */
    @Excel(name = "业务单号" )
    @ApiModelProperty(value = "业务单号", example = "HT001")
    private String businessNo;

    /** 合同id */
    @Excel(name = "合同id" )
    @ApiModelProperty(value = "合同id", example = "1")
    private Long contractId;

    /** 0: 入库, 1: 出库 */
    @Excel(name = "0: 入库, 1: 出库" )
    @ApiModelProperty(value = "0: 入库, 1: 出库", example = "0")
    private Long stockType;

    /** 出租运费 */
    @Excel(name = "出租运费" )
    @ApiModelProperty(value = "出租运费", example = "12")
    private BigDecimal carRentalFee;

    /** 装车费 */
    @Excel(name = "装车费" )
    @ApiModelProperty(value = "装车费", example = "12")
    private BigDecimal loadingFee;

    /** 卸车费 */
    @Excel(name = "卸车费" )
    @ApiModelProperty(value = "卸车费", example = "12")
    private BigDecimal unloadingFee;

    /** 线路起点 */
    @Excel(name = "线路起点" )
    @ApiModelProperty(value = "线路起点", example = "浦东大道")
    private String origin;

    /** 线路终点 */
    @Excel(name = "线路终点" )
    @ApiModelProperty(value = "线路终点", example = "建工集团")
    private String destination;

    /** 运输单价，元/吨 */
    @Excel(name = "运输单价，元/吨" )
    @ApiModelProperty(value = "运输单价，元/吨", example = "10")
    private BigDecimal transportationUnitPrice;

    /** 运输单位 */
    @Excel(name = "运输单位" )
    @ApiModelProperty(value = "运输单位", example = "上海运输")
    private String transportUnit;

    /** 车牌号 */
    @Excel(name = "车牌号" )
    @ApiModelProperty(value = "车牌号", example = "沪A88888")
    private String carNumber;

    /** 运输费 */
    @Excel(name = "运输费" )
    @ApiModelProperty(value = "运输费", example = "1000")
    private BigDecimal freight;

    /** 出租方理论重量，公斤，整车重量 */
    @Excel(name = "出租方理论重量，公斤，整车重量" )
    @ApiModelProperty(value = "出租方理论重量，公斤，整车重量", example = "111")
    private BigDecimal lessorTheoreticalWeight;

    /** 供应商理论重量，公斤，整车重量 */
    @Excel(name = "供应商理论重量，公斤，整车重量" )
    @ApiModelProperty(value = "供应商理论重量，公斤，整车重量", example = "111")
    private BigDecimal supplierTheoreticalWeight;

    /** 仓库称重 */
    @Excel(name = "仓库称重" )
    @ApiModelProperty(value = "仓库称重", example = "222")
    private BigDecimal warehouseWeight;

    /** 场地称重 */
    @Excel(name = "场地称重" )
    @ApiModelProperty(value = "场地称重", example = "222")
    private BigDecimal sceneWeight;

    /** 总杂费，元 */
    @Excel(name = "总杂费，元" )
    @ApiModelProperty(value = "总杂费，元", example = "111")
    private BigDecimal totalMiscelFee;

    /** 经办人 */
    @Excel(name = "经办人" )
    @ApiModelProperty(value = "经办人", example = "张亮")
    private String operator;

    /** 附件url(使用,分割) */
    @ApiModelProperty(value = "附件url(使用,分割)", example = "xxx/xxx.pdf,xxx/xxx1.pdf")
    @Excel(name = "附件url(使用,分割)" )
    private String resources;


    /** 0:未确认 1:已确认 2:已结算 */
    @Excel(name = "0:未确认 1:已确认 2:已结算" )
    @ApiModelProperty(value = "0:未确认 1:已确认 2:已结算", example = "0")
    private Long statisticsStatus;

    /**
     * 组织(部门)id
     */
    private Long deptId;

    /** 库存出入库明细信息 */
    private List<InventoryDetail> inventoryDetailList;

    /** 库存出入库杂费明细信息 */
    private List<InventoryFee> inventoryFeeList;

    /** 合同信息 */
    @ApiModelProperty(hidden = true)
    private ContractVo contractVo;

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
    public void setStockType(Long stockType) {
        this.stockType = stockType;
    }

    public Long getStockType() {
        return stockType;
    }
    public void setCarRentalFee(BigDecimal carRentalFee) {
        this.carRentalFee = carRentalFee;
    }

    public BigDecimal getCarRentalFee() {
        return carRentalFee;
    }
    public void setLoadingFee(BigDecimal loadingFee) {
        this.loadingFee = loadingFee;
    }

    public BigDecimal getLoadingFee() {
        return loadingFee;
    }
    public void setUnloadingFee(BigDecimal unloadingFee) {
        this.unloadingFee = unloadingFee;
    }

    public BigDecimal getUnloadingFee() {
        return unloadingFee;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }
    public void setTransportationUnitPrice(BigDecimal transportationUnitPrice) {
        this.transportationUnitPrice = transportationUnitPrice;
    }

    public BigDecimal getTransportationUnitPrice() {
        return transportationUnitPrice;
    }
    public void setTransportUnit(String transportUnit) {
        this.transportUnit = transportUnit;
    }

    public String getTransportUnit() {
        return transportUnit;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getFreight() {
        return freight;
    }
    public void setLessorTheoreticalWeight(BigDecimal lessorTheoreticalWeight) {
        this.lessorTheoreticalWeight = lessorTheoreticalWeight;
    }

    public BigDecimal getLessorTheoreticalWeight() {
        return lessorTheoreticalWeight;
    }
    public void setSupplierTheoreticalWeight(BigDecimal supplierTheoreticalWeight) {
        this.supplierTheoreticalWeight = supplierTheoreticalWeight;
    }

    public BigDecimal getSupplierTheoreticalWeight() {
        return supplierTheoreticalWeight;
    }
    public void setWarehouseWeight(BigDecimal warehouseWeight) {
        this.warehouseWeight = warehouseWeight;
    }

    public BigDecimal getWarehouseWeight() {
        return warehouseWeight;
    }
    public void setSceneWeight(BigDecimal sceneWeight) {
        this.sceneWeight = sceneWeight;
    }

    public BigDecimal getSceneWeight() {
        return sceneWeight;
    }
    public void setTotalMiscelFee(BigDecimal totalMiscelFee) {
        this.totalMiscelFee = totalMiscelFee;
    }

    public BigDecimal getTotalMiscelFee() {
        return totalMiscelFee;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }



    public List<InventoryDetail> getInventoryDetailList()
    {
        return inventoryDetailList;
    }

    public void setInventoryDetailList(List<InventoryDetail> inventoryDetailList)   {
        this.inventoryDetailList= inventoryDetailList;
    }

    public List<InventoryFee> getInventoryFeeList() {
        return inventoryFeeList;
    }

    public void setInventoryFeeList(List<InventoryFee> inventoryFeeList) {
        this.inventoryFeeList= inventoryFeeList;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("flowNo" ,getFlowNo())
                .append("businessNo" ,getBusinessNo())
                .append("inventoryFeeList" ,getInventoryFeeList())
                .append("contractId" ,getContractId())
                .append("stockType" ,getStockType())
                .append("carRentalFee" ,getCarRentalFee())
                .append("loadingFee" ,getLoadingFee())
                .append("unloadingFee" ,getUnloadingFee())
                .append("origin" ,getOrigin())
                .append("destination" ,getDestination())
                .append("transportationUnitPrice" ,getTransportationUnitPrice())
                .append("transportUnit" ,getTransportUnit())
                .append("carNumber" ,getCarNumber())
                .append("freight" ,getFreight())
                .append("lessorTheoreticalWeight" ,getLessorTheoreticalWeight())
                .append("supplierTheoreticalWeight" ,getSupplierTheoreticalWeight())
                .append("warehouseWeight" ,getWarehouseWeight())
                .append("sceneWeight" ,getSceneWeight())
                .append("totalMiscelFee" ,getTotalMiscelFee())
                .append("operator" ,getOperator())
                .append("resources" ,getResources())
                .append("remark" ,getRemark())
                .append("createBy" ,getCreateBy())
                .append("createTime" ,getCreateTime())
                .append("updateBy" ,getUpdateBy())
                .append("updateTime" ,getUpdateTime())
                .append("isDeleted" ,getIsDeleted())
                .append("inventoryDetailList" ,getInventoryDetailList())
                .append("inventoryFeeList" ,getInventoryFeeList())
                .toString();
    }

    public ContractVo getContractVo() {
        return contractVo;
    }

    public void setContractVo(ContractVo contractVo) {
        this.contractVo = contractVo;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Long getStatisticsStatus() {
        return statisticsStatus;
    }

    public void setStatisticsStatus(Long statisticsStatus) {
        this.statisticsStatus = statisticsStatus;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}