package com.ruoyi.business.domain.vo;

import com.ruoyi.business.domain.InventoryDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/23 9:04 AM
 */
@Data
@ApiModel("物料详情明细")
public class InventoryDetailVo extends InventoryDetail {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("型号规格")
    private String specsName;

    @ApiModelProperty("材料编码")
    private String material;

    @ApiModelProperty("费用名称")
    private String billingName;

    @ApiModelProperty("单位")
    private String units;

    @ApiModelProperty("默认单间重量")
    private BigDecimal defaultWeight;

    @ApiModelProperty("单件重量")
    private BigDecimal singleWeight;

    @ApiModelProperty("打包数量")
    private Integer packagesNumber;

}
