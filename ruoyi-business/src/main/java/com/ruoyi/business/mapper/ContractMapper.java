package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.Contract;
import com.ruoyi.business.domain.ContractBilling;
import com.ruoyi.business.domain.ExternalMaterial;
import com.ruoyi.business.domain.param.ContractParam;
import com.ruoyi.business.domain.param.ExternalMaterialParam;
import com.ruoyi.business.domain.vo.ContractVo;
import com.ruoyi.business.domain.vo.ExternalMaterialVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 合同Mapper接口
 *
 * @author menmenz
 * @date 2022-03-07
 */
public interface ContractMapper {
    /**
     * 查询合同
     *
     * @param id 合同主键
     * @return 合同
     */
    public ContractVo selectContractById(Long id);

    /**
     * 查询合同列表
     *
     * @param contract 合同
     * @return 合同集合
     */
    public List<ContractVo> selectContractList(ContractParam contract);

    /**
     * 查询外部的物料
     * @param param 参数
     * @return 物料详情
     */
    List<ExternalMaterialVo> selectExternalMaterial(ExternalMaterialParam param);

    /**
     * 新增合同
     *
     * @param contract 合同
     * @return 结果
     */
    public int insertContract(Contract contract);

    /**
     * 修改合同
     *
     * @param contract 合同
     * @return 结果
     */
    public int updateContract(Contract contract);

    /**
     * 删除合同
     *
     * @param id 合同主键
     * @return 结果
     */
    public int deleteContractById(Long id);

    /**
     * 批量删除合同
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteContractByIds(Long[] ids);

    /**
     * 批量删除外部物料信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteExternalMaterialByContractIds(Long[] ids);

    /**
     * 批量新增外部物料信息
     *
     * @param externalMaterialList 外部物料信息列表
     * @return 结果
     */
    int batchExternalMaterial(List<ExternalMaterial> externalMaterialList);


    /**
     * 通过合同主键删除外部物料信息信息
     *
     * @param id 合同ID
     * @return 结果
     */
    int deleteExternalMaterialByContractId(Long id);

    /**
     * 批量删除合同计费模板
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteContractBillingByContractIds(Long[] ids);

    /**
     * 批量新增合同计费模板
     *
     * @param contractBillingList 合同计费模板列表
     * @return 结果
     */
    int batchContractBilling(List<ContractBilling> contractBillingList);


    /**
     * 通过合同主键删除合同计费模板信息
     *
     * @param id 合同ID
     * @return 结果
     */
    int deleteContractBillingByContractId(Long id);

    /**
     * 查询合同计费模板列表
     *
     * @param contractId 合同id
     * @return 合同计费模板集合
     */
    List<ContractBilling> selectContractBillingList( @Param("contractId")Long contractId, @Param("expenseType") String expenseType);
}
