package com.ruoyi.business.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("结算单台账列表")
public class LeaseSettlementChecklistVo {

    /** 出入库表id */
    private Long id;

    /** 结算表id */
    private Long settlementId;

    /** 进度对账单表id */
    private Long settleId;

    /** 合同表id */
    private Long contractId;

    /**结算表子表id */
    private Long settlementDetailId;

    @ApiModelProperty(value = "物资名称")
    private String materialName;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd" )
    @Excel(name = "日期" , width = 30, dateFormat = "yyyy-MM-dd" )
    private Date date;

    @ApiModelProperty("理论重量")
    private BigDecimal theoreticalWeight;

    @ApiModelProperty("仓库称重")
    private BigDecimal warehouseWeight;

    @ApiModelProperty("场地称重")
    private BigDecimal sceneWeight;

    @ApiModelProperty("租费")
    private BigDecimal totalMoney;

    @ApiModelProperty("其他费用")
    private BigDecimal otherMoney;

    @ApiModelProperty("合计")
    private BigDecimal allMoney;

    @ApiModelProperty("税率")
    private BigDecimal rate;

    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;

    @ApiModelProperty("费用")
    private List<SettlementFeesVo> list;
}
