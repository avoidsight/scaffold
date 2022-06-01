package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel("租赁结算清单查询结算列表参数")
public class LeaseSettlementParam {

    @ApiModelProperty(value = "合同id", example = "1")
    private Long contractId;

    @ApiModelProperty(value = "进度对账单id", example = "1")
    private Long settleId;

}
