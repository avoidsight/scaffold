package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出租人对象 lessor
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public class Lessor extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 租赁公司名称 */
    @Excel(name = "租赁公司名称" )
    private String companyName;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码" )
    private String usc;

    /** 公司地址 */
    @Excel(name = "公司地址" )
    private String address;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setUsc(String usc) {
        this.usc = usc;
    }

    public String getUsc() {
        return usc;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("companyName" ,getCompanyName())
            .append("usc" ,getUsc())
            .append("address" ,getAddress())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
        }
        }
