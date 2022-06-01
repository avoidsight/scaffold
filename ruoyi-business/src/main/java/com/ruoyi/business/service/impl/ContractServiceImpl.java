package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.Contract;
import com.ruoyi.business.domain.ContractBilling;
import com.ruoyi.business.domain.ExternalMaterial;
import com.ruoyi.business.domain.param.ContractParam;
import com.ruoyi.business.domain.param.ExternalMaterialParam;
import com.ruoyi.business.domain.vo.ContractVo;
import com.ruoyi.business.domain.vo.ExternalMaterialVo;
import com.ruoyi.business.mapper.ContractMapper;
import com.ruoyi.business.service.IBillingService;
import com.ruoyi.business.service.IContractService;
import com.ruoyi.business.service.IWarehouseService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 合同Service业务层处理
 *
 * @author menmenz
 * @date 2022-03-07
 */
@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IBillingService billingService;

    /**
     * 查询合同
     *
     * @param id 合同主键
     * @return 合同
     */
    @Override
    public ContractVo selectContractById(Long id) {
        return contractMapper.selectContractById(id);
    }

    /**
     * 查询合同列表
     *
     * @param contract 合同
     * @return 合同
     */
    @Override
    public List<ContractVo> selectContractList(ContractParam contract) {
        return contractMapper.selectContractList(contract);
    }

    /**
     * 新增合同
     *
     * @param contract 合同
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertContract(Contract contract) {
        contract.setCreateTime(DateUtils.getNowDate());
        int row = contractMapper.insertContract(contract);
        insertExternalMaterial(contract);
        insertContractBilling(contract);
        return row;
    }

    /**
     * 新增外部物料信息信息
     *
     * @param contract 合同对象
     */
    public void insertExternalMaterial(Contract contract) {
        List<ExternalMaterial> externalMaterialList = contract.getExternalMaterialList();
        Long id = contract.getId();
        if (StringUtils.isNotNull(externalMaterialList)) {
            List<ExternalMaterial> list = new ArrayList<>();
            for (ExternalMaterial externalMaterial :externalMaterialList)
            {
                externalMaterial.setContractId(id);
                list.add(externalMaterial);
            }
            if (list.size() > 0) {
                contractMapper.batchExternalMaterial(list);
            }
        }
    }

    /**
     * 修改合同
     *
     * @param contract 合同
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateContract(Contract contract) {
        contract.setUpdateTime(DateUtils.getNowDate());
        contractMapper.deleteExternalMaterialByContractId(contract.getId());
        insertExternalMaterial(contract);
        contractMapper.deleteContractBillingByContractId(contract.getId());
        insertContractBilling(contract);
        return contractMapper.updateContract(contract);
    }

    /**
     * 批量删除合同
     *
     * @param ids 需要删除的合同主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteContractByIds(Long[] ids) {
        contractMapper.deleteExternalMaterialByContractIds(ids);
        contractMapper.deleteContractBillingByContractIds(ids);
        return contractMapper.deleteContractByIds(ids);
    }

    /**
     * 删除合同信息
     *
     * @param id 合同主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteContractById(Long id) {
        contractMapper.deleteExternalMaterialByContractId(id);
        return contractMapper.deleteContractById(id);
    }

    @Override
    public List<ExternalMaterialVo> selectExternalMaterial(ExternalMaterialParam param) {
        return contractMapper.selectExternalMaterial(param);
    }

    @Override
    public List<ContractBilling> selectContractBillingList(Long contractId, String expenseType) {
        return contractMapper.selectContractBillingList(contractId, expenseType);
    }

    /**
     * 新增合同计费模板信息
     *
     * @param contract 合同对象
     */
    public void insertContractBilling(Contract contract) {
        List<ContractBilling> contractBillingList = contract.getContractBillingList();
        Long id = contract.getId();
        if (StringUtils.isNotNull(contractBillingList)) {
            List<ContractBilling> list = new ArrayList<ContractBilling>();
            for (ContractBilling contractBilling :contractBillingList)
            {
                contractBilling.setContractId(id);
                list.add(contractBilling);
            }
            if (list.size() > 0) {
                contractMapper.batchContractBilling(list);
            }
        }
    }
}
