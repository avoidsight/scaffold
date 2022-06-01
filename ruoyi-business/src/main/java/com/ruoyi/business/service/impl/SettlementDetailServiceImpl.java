package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.SettlementDetailMapper;
import com.ruoyi.business.domain.SettlementDetail;
import com.ruoyi.business.service.ISettlementDetailService;

/**
 * 结算明细Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Service
public class SettlementDetailServiceImpl implements ISettlementDetailService {
    @Autowired
    private SettlementDetailMapper settlementDetailMapper;

    /**
     * 查询结算明细
     *
     * @param id 结算明细主键
     * @return 结算明细
     */
    @Override
    public SettlementDetail selectSettlementDetailById(Long id) {
        return settlementDetailMapper.selectSettlementDetailById(id);
    }

    /**
     * 查询结算明细列表
     *
     * @param settlementDetail 结算明细
     * @return 结算明细
     */
    @Override
    public List<SettlementDetail> selectSettlementDetailList(SettlementDetail settlementDetail) {
        return settlementDetailMapper.selectSettlementDetailList(settlementDetail);
    }

    /**
     * 新增结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    @Override
    public int insertSettlementDetail(SettlementDetail settlementDetail) {
        settlementDetail.setCreateTime(DateUtils.getNowDate());
        return settlementDetailMapper.insertSettlementDetail(settlementDetail);
    }

    /**
     * 修改结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    @Override
    public int updateSettlementDetail(SettlementDetail settlementDetail) {
        settlementDetail.setUpdateTime(DateUtils.getNowDate());
        return settlementDetailMapper.updateSettlementDetail(settlementDetail);
    }

    /**
     * 删除结算明细信息
     *
     * @param id 结算明细主键
     * @return 结果
     */
    @Override
    public int deleteSettlementDetailById(Long id) {
        return settlementDetailMapper.deleteSettlementDetailById(id);
    }
}
