package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 承租人对象 lessee
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public class Lessee extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 承租人公司名称 */
    @Excel(name = "承租人公司名称" )
    private String companyName;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码" )
    private String usc;

    /** 联系人 */
    @Excel(name = "联系人" )
    private String contactor;

    /** 联系人电话 */
    @Excel(name = "联系人电话" )
    private String mobile;

    /** 公司地址 */
    @Excel(name = "公司地址" )
    private String address;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setCompanyName(String companyName)
            {
            this.companyName = companyName;
            }

    public String getCompanyName()
            {
            return companyName;
            }
    public void setUsc(String usc)
            {
            this.usc = usc;
            }

    public String getUsc()
            {
            return usc;
            }
    public void setContactor(String contactor)
            {
            this.contactor = contactor;
            }

    public String getContactor()
            {
            return contactor;
            }
    public void setMobile(String mobile)
            {
            this.mobile = mobile;
            }

    public String getMobile()
            {
            return mobile;
            }
    public void setAddress(String address)
            {
            this.address = address;
            }

    public String getAddress()
            {
            return address;
            }


@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("companyName" ,getCompanyName())
            .append("usc" ,getUsc())
            .append("contactor" ,getContactor())
            .append("mobile" ,getMobile())
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
