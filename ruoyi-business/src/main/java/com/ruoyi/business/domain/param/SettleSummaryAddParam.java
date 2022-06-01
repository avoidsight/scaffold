package com.ruoyi.business.domain.param;

import com.ruoyi.business.domain.vo.SummaryVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("新建进度对账单汇总参数")
public class SettleSummaryAddParam {
    @ApiModelProperty(value = "合同id", example = "1")
    private Long contractId;

    @ApiModelProperty(value = "进度对账单id数组", example = "1,2,3")
    private Long[] SettleIds;

    @ApiModelProperty(value = "附件url(以','分割)", example = "xxx/xxx.pdf,xxx/xxx1.pdf")
    private String resources;

    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;
}
