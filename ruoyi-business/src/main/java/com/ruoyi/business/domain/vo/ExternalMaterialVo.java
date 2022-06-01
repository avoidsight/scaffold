package com.ruoyi.business.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel("外部物料配置")
@Data
public class ExternalMaterialVo {
    /** 主键id */
    @ApiModelProperty("主键id")
    private Long id;

    /** 物料分类id */
    @Excel(name = "物料分类id" )
    @ApiModelProperty("物料分类id" )
    private Long materialCategoryId;

    /** 物料分类名称 */
    @Excel(name = "物料分类名称" )
    @ApiModelProperty("物料分类名称" )
    private String materialCategoryName;

    /** 详细类型id */
    @Excel(name = "详细类型id" )
    @ApiModelProperty("详细类型id" )
    private Long materialSpecId;

    /** 详细类型名称 */
    @Excel(name = "详细类型名称" )
    @ApiModelProperty("详细类型名称" )
    private String materialSpecName;

    /** 主计量单位 */
    @Excel(name = "主计量单位" )
    @ApiModelProperty("主计量单位" )
    private String mainUnit;

    /** 单件重量，公斤 */
    @Excel(name = "单件重量，公斤" )
    @ApiModelProperty("单件重量，公斤" )
    private BigDecimal singleWeight;

    /** 供应商id */
    @Excel(name = "供应商id" )
    @ApiModelProperty("供应商id" )
    private Long supplierId;

    /** 供应商id */
    @Excel(name = "供应商id" )
    @ApiModelProperty("供应商id" )
    private String supplierName;


}
