package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料规格对象 material_specs
 *
 * @author ruoyi
 * @date 2022-03-23
 */
public class MaterialSpecs extends BaseEntity {
    private static final long serialVersionUID=1L;

    /** 自增id作为主键 */
    private Long id;

    /** 分类编码 */
    @Excel(name = "分类编码" )
    private Long categoryCode;

    /** 型号 */
    @Excel(name = "型号" )
    private String specsName;

    /** 规格类型。0：支撑架，1：作业架 */
    @Excel(name = "规格类型。0：支撑架，1：作业架" )
    private Long specsType;

    /** 直径 */
    @Excel(name = "直径" )
    private String diameter;

    /** 厚度 */
    @Excel(name = "厚度" )
    private String thickness;

    /** 长度 */
    @Excel(name = "长度" )
    private String lengths;

    /** 材质 */
    @Excel(name = "材质" )
    private String material;

    /** 单位 */
    @Excel(name = "单位" )
    private String units;

    /** 单件重量 */
    @Excel(name = "单件重量" )
    private BigDecimal singleWeight;

    /** 常见打包数量 */
    @Excel(name = "常见打包数量" )
    private Long packagesNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setCategoryCode(Long categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Long getCategoryCode() {
        return categoryCode;
    }
    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public String getSpecsName() {
        return specsName;
    }
    public void setSpecsType(Long specsType) {
        this.specsType = specsType;
    }

    public Long getSpecsType() {
        return specsType;
    }
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getDiameter() {
        return diameter;
    }
    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getThickness() {
        return thickness;
    }
    public void setLengths(String lengths) {
        this.lengths = lengths;
    }

    public String getLengths() {
        return lengths;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnits() {
        return units;
    }
    public void setSingleWeight(BigDecimal singleWeight) {
        this.singleWeight = singleWeight;
    }

    public BigDecimal getSingleWeight() {
        return singleWeight;
    }
    public void setPackagesNumber(Long packagesNumber) {
        this.packagesNumber = packagesNumber;
    }

    public Long getPackagesNumber() {
        return packagesNumber;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id" ,getId())
            .append("categoryCode" ,getCategoryCode())
            .append("specsName" ,getSpecsName())
            .append("specsType" ,getSpecsType())
            .append("diameter" ,getDiameter())
            .append("thickness" ,getThickness())
            .append("lengths" ,getLengths())
            .append("material" ,getMaterial())
            .append("units" ,getUnits())
            .append("singleWeight" ,getSingleWeight())
            .append("packagesNumber" ,getPackagesNumber())
            .append("createBy" ,getCreateBy())
            .append("createTime" ,getCreateTime())
            .append("updateBy" ,getUpdateBy())
            .append("updateTime" ,getUpdateTime())
            .append("isDeleted" ,getIsDeleted())
        .toString();
    }
}
