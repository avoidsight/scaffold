package com.ruoyi.business.domain.vo;

import com.ruoyi.business.domain.Settle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("进度单详情")
public class SettleVo extends Settle {
    @ApiModelProperty("进度单对应的出入库单")
    private List<InventoryVo> inventoryVoList;
}
