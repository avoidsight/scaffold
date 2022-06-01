package com.ruoyi.business.service;

import com.ruoyi.business.domain.Contract;
import com.ruoyi.business.domain.ContractBilling;
import com.ruoyi.business.domain.param.ContractParam;
import com.ruoyi.business.domain.param.ExternalMaterialParam;
import com.ruoyi.business.domain.vo.ContractVo;
import com.ruoyi.business.domain.vo.ExternalMaterialVo;

import java.util.List;

/**
 * 合同Service接口
 *
 * @author menmenz
 * @date 2022-03-07
 */
public interface IContractService {
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
     * @param ContractVo 合同
     * @return 合同集合
     */
    public List<ContractVo> selectContractList(ContractParam Contract);

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
     * 批量删除合同
     *
     * @param ids 需要删除的合同主键集合
     * @return 结果
     */
    public int deleteContractByIds(Long[] ids);

    /**
     * 删除合同信息
     *
     * @param id 合同主键
     * @return 结果
     */
    public int deleteContractById(Long id);

    /**
     * 查询外部的物料
     * @param param 参数
     * @return 物料详情
     */
    List<ExternalMaterialVo> selectExternalMaterial(ExternalMaterialParam param);

    /**
     * 查询合同计费模板列表
     *
     * @param contractId 合同id
     * @return 合同计费模板集合
     */
    List<ContractBilling> selectContractBillingList(Long contractId, String expenseType);
}
