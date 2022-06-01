package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 合同对象 contract
 *
 * @author menmenz
 * @date 2022-03-07
 */
@ApiModel("合同基本信息")
public class Contract extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id作为主键
     */
    private Long id;

    /**
     * 0:采购,1:租赁,2:外借,3:寄存
     */
    @Excel(name = "0:采购,1:租赁,2:外借,3:寄存")
    @ApiModelProperty("0:采购,1:租赁,2:外借,3:寄存")
    private Long type;

    @Excel(name = "0:采购,1:租赁,2:外借,3:寄存")
    @ApiModelProperty("0:采购,1:租赁,2:外借,3:寄存")
    private Long rentalType;

    /**
     * 合同名称
     */
    @Excel(name = "合同名称")
    @ApiModelProperty("合同名称")
    private String contractName;

    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进入时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("进入时间")
    private Date signedDate;

    /**
     * 仓库id
     */
    @Excel(name = "仓库id")
    @ApiModelProperty("仓库id")
    private Long warehouseId;

    /**
     * 项目id
     */
    @Excel(name = "项目id")
    @ApiModelProperty("项目id")
    @Deprecated
    private Long projectId;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称")
    @ApiModelProperty("项目名称")
    private String projectName;

    /**
     * 进入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进入时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("进入时间")
    private Date inTime;

    /**
     * 退出时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退出时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("退出时间")
    private Date outTime;

    /**
     * 附件(,分割)
     */
    @Excel(name = "附件(,分割)")
    @ApiModelProperty("附件")
    private String resources;


    /**
     * 合同编码
     */
    @Excel(name = "合同编码")
    @ApiModelProperty("合同编码")
    private String contractCode;

    /**
     * 业务单号
     */
    @Excel(name = "业务单号")
    @ApiModelProperty("业务单号")
    private String businessCode;

    /**
     * 表单编号
     */
    @Excel(name = "表单编号")
    @ApiModelProperty("表单编号")
    private String formCode;

    @Excel(name = "采购-甲方(中成)")
    @ApiModelProperty("采购-甲方(中成)")
    private String purchaseDeptName;

    @Excel(name = "采购-乙方(供应)")
    @ApiModelProperty("采购-乙方(供应商)")
    private Long purchaseSupplierId;

    @Excel(name = "租赁-甲方(项目)")
    @ApiModelProperty("租赁-甲方(项目)")
    private Long rentalLesseeId;

    @Excel(name = "租赁-乙方(中成)")
    @ApiModelProperty("租赁-乙方(中成)")
    private String rentalDeptName;

    @Excel(name = "外借-甲方(中成)")
    @ApiModelProperty("外借-甲方(中成)")
    private String lendingDeptName;

    @Excel(name = "外借-乙方(供应商)")
    @ApiModelProperty("外借-乙方(供应商)")
    private Long lendingSupplierId;

    @Excel(name = "寄存-甲方(中成)")
    @ApiModelProperty("寄存-甲方(中成)")
    private String bailmentDeptName;

    @Excel(name = "寄存-乙方(承租方)")
    @ApiModelProperty("寄存-乙方(承租方)")
    private Long bailmentLesseeId;

    /**
     * 单位id
     */
    @Excel(name = "单位id")
    @ApiModelProperty("单位id")
    @Deprecated
    private Long deptId;

    /**
     * 客户id
     */
    @Excel(name = "客户id")
    @ApiModelProperty("客户id")
    @Deprecated
    private Long customerId;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("开始日期")
    private Date startTime;

    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("结束日期")
    private Date endTime;

    /**
     * 地址
     */
    @Excel(name = "地址")
    @ApiModelProperty("地址")
    private String address;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    @ApiModelProperty("联系人")
    private String linkMan;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    @ApiModelProperty("联系电话")
    private String linkPhone;

    /**
     * 经办人
     */
    @Excel(name = "经办人")
    @ApiModelProperty("经办人")
    private String operator;

    /**
     * 计费模板id
     */
    @Excel(name = "计费模板id")
    @ApiModelProperty("计费模板id")
    private Long templateId;

    /**
     * 外部物料信息信息
     */
    private List<ExternalMaterial> externalMaterialList;

    private List<ContractBilling> contractBillingList;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResources() {
        return resources;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public String getPurchaseDeptName() {
        return purchaseDeptName;
    }

    public void setPurchaseDeptName(String purchaseDeptName) {
        this.purchaseDeptName = purchaseDeptName;
    }

    public Long getPurchaseSupplierId() {
        return purchaseSupplierId;
    }

    public void setPurchaseSupplierId(Long purchaseSupplierId) {
        this.purchaseSupplierId = purchaseSupplierId;
    }

    public Long getRentalLesseeId() {
        return rentalLesseeId;
    }

    public void setRentalLesseeId(Long rentalLesseeId) {
        this.rentalLesseeId = rentalLesseeId;
    }

    public String getRentalDeptName() {
        return rentalDeptName;
    }

    public void setRentalDeptName(String rentalDeptName) {
        this.rentalDeptName = rentalDeptName;
    }

    public String getLendingDeptName() {
        return lendingDeptName;
    }

    public void setLendingDeptName(String lendingDeptName) {
        this.lendingDeptName = lendingDeptName;
    }

    public Long getLendingSupplierId() {
        return lendingSupplierId;
    }

    public void setLendingSupplierId(Long lendingSupplierId) {
        this.lendingSupplierId = lendingSupplierId;
    }

    public String getBailmentDeptName() {
        return bailmentDeptName;
    }

    public void setBailmentDeptName(String bailmentDeptName) {
        this.bailmentDeptName = bailmentDeptName;
    }

    public Long getBailmentLesseeId() {
        return bailmentLesseeId;
    }

    public void setBailmentLesseeId(Long bailmentLesseeId) {
        this.bailmentLesseeId = bailmentLesseeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("contractName", getContractName())
                .append("warehouseId", getWarehouseId())
                .append("projectId", getProjectId())
                .append("projectName", getProjectName())
                .append("inTime", getInTime())
                .append("outTime", getOutTime())
                .append("resources", getResources())
                .append("contractCode", getContractCode())
                .append("businessCode", getBusinessCode())
                .append("formCode", getFormCode())
                .append("deptId", getDeptId())
                .append("customerId", getCustomerId())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("address", getAddress())
                .append("linkMan", getLinkMan())
                .append("linkPhone", getLinkPhone())
                .append("operator", getOperator())
                .append("templateId", getTemplateId())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .toString();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<ExternalMaterial> getExternalMaterialList() {
        return externalMaterialList;
    }

    public void setExternalMaterialList(List<ExternalMaterial> externalMaterialList) {
        this.externalMaterialList = externalMaterialList;
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public List<ContractBilling> getContractBillingList() {
        return contractBillingList;
    }

    public void setContractBillingList(List<ContractBilling> contractBillingList) {
        this.contractBillingList = contractBillingList;
    }

    public Long getRentalType() {
        return rentalType;
    }

    public void setRentalType(Long rentalType) {
        this.rentalType = rentalType;
    }
}
