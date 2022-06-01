package com.ruoyi.business.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/22 2:14 PM
 */
@Data
@ApiModel("出入库台账列表")
public class InventoryBookVo {
    @ApiModelProperty("出入库单id")
    private String inventoryId;
    @ApiModelProperty("业务日期")
    @Excel(name = "业务日期")
    private String businessDate;
    @ApiModelProperty("入库类型")
    @Excel(name = "入库类型")
    private String contractType;
    @ApiModelProperty("合同编号")
    @Excel(name = "合同编号")
    private String contractCode;
    @ApiModelProperty("名称")
    @Excel(name = "名称")
    private String categoryName;
    @ApiModelProperty("型号规格")
    @Excel(name = "型号规格")
    private String specsName;
    @ApiModelProperty("数量")
    @Excel(name = "数量")
    private String materialQuantity;
    @ApiModelProperty("单位")
    @Excel(name = "单位")
    private String materialUnits;
    @ApiModelProperty("单件重量(kg)")
    @Excel(name = "单件重量")
    private String singleWeight;
    @ApiModelProperty("重量(kg)")
    @Excel(name = "重量")
    private String total;
    @ApiModelProperty("流水单号")
    @Excel(name = "流水单号")
    private String flowNo;
    @ApiModelProperty("业务单号")
    @Excel(name = "业务单号")
    private String businessNo;
    @ApiModelProperty("车次")
    @Excel(name = "车次")
    private String carSerial;
    @ApiModelProperty("所在地")
    @Excel(name = "所在地")
    private String destination;
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;
}
