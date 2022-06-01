package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产商对象 manufacturer
 *
 * @author ruoyi
 * @date 2022-05-09
 */
public class Manufacturer extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 单位名称 */
    @Excel(name = "单位名称" )
    private String name;

    /** 单位地址 */
    @Excel(name = "单位地址" )
    private String address;

    /** 法人代表 */
    @Excel(name = "法人代表" )
    private String legal;

    /** 注册资金 */
    @Excel(name = "注册资金" )
    private BigDecimal registerFunds;

    /** 联系人 */
    @Excel(name = "联系人" )
    private String contacts;

    /** 联系方式 */
    @Excel(name = "联系方式" )
    private String contactPhone;

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
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContacts() {
        return contacts;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("name" ,getName())
            .append("address" ,getAddress())
            .append("legal" ,getLegal())
            .append("registerFunds" ,getRegisterFunds())
            .append("contacts" ,getContacts())
            .append("contactPhone" ,getContactPhone())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
