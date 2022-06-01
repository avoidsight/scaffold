package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/23 2:17 PM
 */
@Data
@ApiModel("入库单详情")
public class InventoryResultVo {
    @ApiModelProperty(value = "主键", example = "1")
    private Long id;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "业务日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    @ApiModelProperty(value = "业务日期", example = "2022-03-22")
    private Date businessDate;

    /** 流水单号 */
    @Excel(name = "流水单号" )
    @ApiModelProperty(value = "流水单号(合同类型+时间戳)", example = "ZL12344123")
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

    @Excel(name = "附件url(使用,分割)")
    @ApiModelProperty("附件url(使用,分割)")
    private String resources;

    @ApiModelProperty(value = "制单人", example = "张三")
    private String createBy;

    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;

    @ApiModelProperty(value = "制单人", example = "张三")
    @JsonFormat(pattern = "yyyy-MM-dd" )
    private Date createTime;
    /** 库存出入库明细信息 */
    private List<InventoryDetailVo> inventoryDetailList;

    /** 库存出入库杂费明细信息 */
    private List<InventoryFeeVo> inventoryFeeList;

    /** 合同信息 */
    @ApiModelProperty(hidden = true)
    private ContractVo contractVo;
}
