package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 supplier
 *
 * @author ruoyi
 * @date 2022-05-12
 */
public class Supplier extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 供应商单位名称 */
    @Excel(name = "供应商单位名称" )
    private String supplierName;

    /** 供应商类型,0:生产商,1:租赁商 */
    @Excel(name = "供应商类型,0:生产商,1:租赁商" )
    private Long supplierType;

    /** 省 */
    @Excel(name = "省" )
    private String province;

    /** 市 */
    @Excel(name = "市" )
    private String city;

    /** 地址 */
    @Excel(name = "地址" )
    private String address;

    /** 法人代表 */
    @Excel(name = "法人代表" )
    private String legal;

    /** 注册资金(万元) */
    @Excel(name = "注册资金(万元)" )
    private BigDecimal registerFunds;

    /** 状态,0:白名单,1:黑名单 */
    @Excel(name = "状态,0:白名单,1:黑名单" )
    private Long isBlacklist;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierType(Long supplierType) {
        this.supplierType = supplierType;
    }

    public Long getSupplierType() {
        return supplierType;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
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
    public void setIsBlacklist(Long isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public Long getIsBlacklist() {
        return isBlacklist;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("supplierName" ,getSupplierName())
            .append("supplierType" ,getSupplierType())
            .append("province" ,getProvince())
            .append("city" ,getCity())
            .append("address" ,getAddress())
            .append("legal" ,getLegal())
            .append("registerFunds" ,getRegisterFunds())
            .append("isBlacklist" ,getIsBlacklist())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
