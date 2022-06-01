package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.Billing;
import com.ruoyi.business.domain.BillingDetail;

/**
 * 计费模板Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-15
 */
public interface BillingMapper {
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
     * 删除计费模板
     *
     * @param id 计费模板主键
     * @return 结果
     */
    int deleteBillingById(Long id);

    /**
     * 批量删除计费模板
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBillingByIds(Long[] ids);

    /**
     * 批量删除计费模板明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBillingDetailByTemplateIds(Long[] ids);

    /**
     * 批量新增计费模板明细
     *
     * @param billingDetailList 计费模板明细列表
     * @return 结果
     */
    int batchBillingDetail(List<BillingDetail> billingDetailList);


    /**
     * 通过计费模板主键删除计费模板明细信息
     *
     * @param id 计费模板ID
     * @return 结果
     */
    int deleteBillingDetailByTemplateId(Long id);
}
