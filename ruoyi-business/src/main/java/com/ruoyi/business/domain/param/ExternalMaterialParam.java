package com.ruoyi.business.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExternalMaterialParam {
    @ApiModelProperty("物料分类id")
    private Long materialCategoryId;

    @ApiModelProperty("物料详情id")
    private Long materialSpecId;

    @ApiModelProperty("合同id")
    private Long contractId;
}
