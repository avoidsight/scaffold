package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("结算台账详情实体")
public class LeaseSettlementVo {
    @ApiModelProperty("结算单台账列表头部数据")
    private LeaseSettlementChecklistHeaderVo checklistHeaderVo;

    @ApiModelProperty("结算单台账列表")
    private List<LeaseSettlementChecklistVo> list;
}
