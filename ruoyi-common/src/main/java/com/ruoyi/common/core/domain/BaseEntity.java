package com.ruoyi.common.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity基类
 *
 * @author ruoyi
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 创建者
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date updateTime;

    /** 是否删除0:未删除;1:删除 */
    @Excel(name = "是否删除0:未删除;1:删除" )
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long isDeleted;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setIsDeleted(Long isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted()
    {
        return isDeleted;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void create() {
        this.update();
        this.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        this.setCreateTime(DateUtils.getNowDate());
    }

    public void update() {
        this.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        this.setUpdateTime(DateUtils.getNowDate());
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
