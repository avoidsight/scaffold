package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库管理对象 warehouse
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public class Warehouse extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 仓库编码 */
            @Excel(name = "仓库编码" )
    private String code;

    /** 组织id */
            @Excel(name = "组织id" )
    private Long deptId;

    /** 仓库名称 */
            @Excel(name = "仓库名称" )
    private String name;

    /** 仓库地址 */
            @Excel(name = "仓库地址" )
    private String address;

    /** 仓库管理员 */
            @Excel(name = "仓库管理员" )
    private String keeper;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setCode(String code)
            {
            this.code = code;
            }

    public String getCode()
            {
            return code;
            }
    public void setDeptId(Long deptId)
            {
            this.deptId = deptId;
            }

    public Long getDeptId()
            {
            return deptId;
            }
    public void setName(String name)
            {
            this.name = name;
            }

    public String getName()
            {
            return name;
            }
    public void setAddress(String address)
            {
            this.address = address;
            }

    public String getAddress()
            {
            return address;
            }
    public void setKeeper(String keeper)
            {
            this.keeper = keeper;
            }

    public String getKeeper()
            {
            return keeper;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("code" ,getCode())
            .append("deptId" ,getDeptId())
            .append("name" ,getName())
            .append("address" ,getAddress())
            .append("keeper" ,getKeeper())
            .append("remark" ,getRemark())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
        }
        }
