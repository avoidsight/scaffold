package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("进度对账单汇总")
public class SummaryVo {
    /** 自增id作为主键 */
    private Long id;

    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("物资名称")
    private String materialName;

    @ApiModelProperty("期初")
    private BigDecimal beginTotal;

    @ApiModelProperty("理论发出(kg)")
    private BigDecimal theoreticalOutTotal;

    @ApiModelProperty("理论退入(kg)")
    private BigDecimal theoreticalInTotal;

    @ApiModelProperty("仓库称重发出(kg)")
    private BigDecimal warehouseOutTotal;

    @ApiModelProperty("仓库称重退入(kg)")
    private BigDecimal warehouseInTotal;

    @ApiModelProperty("场地称重发出(kg)")
    private BigDecimal sceneOutTotal;

    @ApiModelProperty("场地称重退入(kg)")
    private BigDecimal sceneInTotal;

    @ApiModelProperty("期末")
    private BigDecimal endTotal;

    @ApiModelProperty("备注")
    private String remark;
}
