package com.ruoyi.business.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料分类对象 material_category
 *
 * @author ruoyi
 * @date 2022-03-23
 */
public class MaterialCategory extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 编码 */
    @Excel(name = "编码" )
    private String code;

    /** 名称 */
    @Excel(name = "名称" )
    private String name;

    /** 主计量单位 */
    @Excel(name = "主计量单位" )
    private String mUnit;

    /** 辅计量单位 */
    @Excel(name = "辅计量单位" )
    private String aUnit;

    /** 备注 */
    @Excel(name = "备注" )
    private String remarks;

    /** 标记。0：其它，1:立杆，2：水平杆，3：脚手板 */
    @Excel(name = "标记。0：其它，1:立杆，2：水平杆，3：脚手板" )
    private Integer flag;

    /** 物料规格信息 */
    private List<MaterialSpecs> materialSpecsList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setmUnit(String mUnit) {
        this.mUnit = mUnit;
    }

    public String getmUnit() {
        return mUnit;
    }
    public void setaUnit(String aUnit) {
        this.aUnit = aUnit;
    }

    public String getaUnit() {
        return aUnit;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public List<MaterialSpecs> getMaterialSpecsList() {
        return materialSpecsList;
    }

    public void setMaterialSpecsList(List<MaterialSpecs> materialSpecsList) {
        this.materialSpecsList= materialSpecsList;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("code" ,getCode())
            .append("name" ,getName())
            .append("mUnit" ,getmUnit())
            .append("aUnit" ,getaUnit())
            .append("remarks" ,getRemarks())
            .append("flag" ,getFlag())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
            .append("materialSpecsList" ,getMaterialSpecsList())
        .toString();
    }
}
