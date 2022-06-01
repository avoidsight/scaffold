package com.ruoyi.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("进度对账单明细全部信息")
public class SettleDetailVo {
    @ApiModelProperty("进度对账单明细基本信息")
    private SettleSumVo settleBaseInfo;

    @ApiModelProperty("对账期新增供货量表")
    private SummaryDetailVo addList;

    @ApiModelProperty("对账期内退场量表")
    private SummaryDetailVo offList ;

    @ApiModelProperty("其他费用表")
    private List<SummaryDetailListVo> OtherFeeList;
}
