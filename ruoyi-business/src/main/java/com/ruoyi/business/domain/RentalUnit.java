package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租赁商对象 rental_unit
 *
 * @author ruoyi
 * @date 2022-05-09
 */
public class RentalUnit extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 单位名称 */
    @Excel(name = "单位名称" )
    private String name;

    /** 单位地址 */
    @Excel(name = "单位地址" )
    private String address;

    /** 0:白名单,1:黑名单 */
    @Excel(name = "0:白名单,1:黑名单" )
    private Long status;

    /** 法人代表 */
    @Excel(name = "法人代表" )
    private String legal;

    /** 注册资金 */
    @Excel(name = "注册资金" )
    private BigDecimal registerFunds;

    /** 自有盘扣 */
    @Excel(name = "自有盘扣" )
    private BigDecimal selfFrog;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }
    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getLegal() {
        return legal;
    }
    public void setRegisterFunds(BigDecimal registerFunds) {
        this.registerFunds = registerFunds;
    }

    public BigDecimal getRegisterFunds() {
        return registerFunds;
    }
    public void setSelfFrog(BigDecimal selfFrog) {
        this.selfFrog = selfFrog;
    }

    public BigDecimal getSelfFrog() {
        return selfFrog;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("name" ,getName())
            .append("address" ,getAddress())
            .append("status" ,getStatus())
            .append("legal" ,getLegal())
            .append("registerFunds" ,getRegisterFunds())
            .append("selfFrog" ,getSelfFrog())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
