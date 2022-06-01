package com.ruoyi.business.domain.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/14 3:58 PM
 */
@Data
@ApiModel("出入库台账参数")
public class InventoryBookParam {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间",example = "2022-03-18")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间",example = "2022-03-19")
    private Date endDate;

    @ApiModelProperty(value = "0:入库,1:出库",example = "0")
    private Integer stockType;

    @ApiModelProperty(value = "0:租赁,1:外借,2:寄存,3:采购,4:报废",example = "0")
    private Integer contractType;

    @ApiModelProperty(value = "模糊查询字段",example = "羿云合同")
    private String content;

}