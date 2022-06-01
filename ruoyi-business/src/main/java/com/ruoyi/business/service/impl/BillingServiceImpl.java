package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.business.domain.BillingDetail;
import com.ruoyi.business.mapper.BillingMapper;
import com.ruoyi.business.domain.Billing;
import com.ruoyi.business.service.IBillingService;

/**
 * 计费模板Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-15
 */
@Service
public class BillingServiceImpl implements IBillingService {
    @Autowired
    private BillingMapper billingMapper;

    /**
     * 查询计费模板
     *
     * @param id 计费模板主键
     * @return 计费模板
     */
    @Override
    public Billing selectBillingById(Long id) {
        return billingMapper.selectBillingById(id);
    }

    /**
     * 查询计费模板列表
     *
     * @param billing 计费模板
     * @return 计费模板
     */
    @Override
    public List<Billing> selectBillingList(Billing billing) {
        return billingMapper.selectBillingList(billing);
    }

    /**
     * 新增计费模板
     *
     * @param billing 计费模板
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBilling(Billing billing) {
        billing.setCreateTime(DateUtils.getNowDate());
        int rows = billingMapper.insertBilling(billing);
        insertBillingDetail(billing);
        return rows;
    }

    /**
     * 修改计费模板
     *
     * @param billing 计费模板
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateBilling(Billing billing) {
        billing.setUpdateTime(DateUtils.getNowDate());
        billingMapper.deleteBillingDetailByTemplateId(billing.getId());
        insertBillingDetail(billing);
        return billingMapper.updateBilling(billing);
    }

    /**
     * 批量删除计费模板
     *
     * @param ids 需要删除的计费模板主键
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteBillingByIds(Long[] ids) {
        billingMapper.deleteBillingDetailByTemplateIds(ids);
        return billingMapper.deleteBillingByIds(ids);
    }

    /**
     * 删除计费模板信息
     *
     * @param id 计费模板主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteBillingById(Long id) {
        billingMapper.deleteBillingDetailByTemplateId(id);
        return billingMapper.deleteBillingById(id);
    }

    /**
     * 新增计费模板明细信息
     *
     * @param billing 计费模板对象
     */
    public void insertBillingDetail(Billing billing) {
        List<BillingDetail> billingDetailList = billing.getBillingDetailList();
        Long id = billing.getId();
        if (StringUtils.isNotNull(billingDetailList)) {
            List<BillingDetail> list = new ArrayList<BillingDetail>();
            for (BillingDetail billingDetail :billingDetailList)
            {
                billingDetail.setTemplateId(id);
                list.add(billingDetail);
            }
            if (list.size() > 0) {
                    billingMapper.batchBillingDetail(list);
            }
        }
    }
}
