package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("进度对账单明细信息")
public class SummaryDetailVo {
    @ApiModelProperty("进度对账单主键id")
    public Long id;

    @ApiModelProperty("0: 入库, 1: 出库")
    public Integer type;

    @ApiModelProperty("仓库称重（kg）")
    public BigDecimal warehouseWeight;

    @ApiModelProperty("场地称重（kg）")
    public BigDecimal sceneWeight;

    @ApiModelProperty("进度对账单明细表信息")
    public List<SummaryDetailListVo> list;
}
