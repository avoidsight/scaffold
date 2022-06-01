package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.Billing;

/**
 * 计费模板Service接口
 *
 * @author ruoyi
 * @date 2022-03-15
 */
public interface IBillingService {
    /**
     * 查询计费模板
     *
     * @param id 计费模板主键
     * @return 计费模板
     */
    Billing selectBillingById(Long id);

    /**
     * 查询计费模板列表
     *
     * @param billing 计费模板
     * @return 计费模板集合
     */
    List<Billing> selectBillingList(Billing billing);

    /**
     * 新增计费模板
     *
     * @param billing 计费模板
     * @return 结果
     */
    int insertBilling(Billing billing);

    /**
     * 修改计费模板
     *
     * @param billing 计费模板
     * @return 结果
     */
    int updateBilling(Billing billing);

    /**
     * 批量删除计费模板
     *
     * @param ids 需要删除的计费模板主键集合
     * @return 结果
     */
    int deleteBillingByIds(Long[] ids);

    /**
     * 删除计费模板信息
     *
     * @param id 计费模板主键
     * @return 结果
     */
    int deleteBillingById(Long id);
}
