package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.SettleSummarySettleMapper;
import com.ruoyi.business.domain.SettleSummarySettle;
import com.ruoyi.business.service.ISettleSummarySettleService;

/**
 * 汇总单与进度单关系Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Service
public class SettleSummarySettleServiceImpl implements ISettleSummarySettleService {
    @Autowired
    private SettleSummarySettleMapper settleSummarySettleMapper;

    /**
     * 查询汇总单与进度单关系
     *
     * @param id 汇总单与进度单关系主键
     * @return 汇总单与进度单关系
     */
    @Override
    public SettleSummarySettle selectSettleSummarySettleById(Long id) {
        return settleSummarySettleMapper.selectSettleSummarySettleById(id);
    }

    /**
     * 查询汇总单与进度单关系列表
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 汇总单与进度单关系
     */
    @Override
    public List<SettleSummarySettle> selectSettleSummarySettleList(SettleSummarySettle settleSummarySettle) {
        return settleSummarySettleMapper.selectSettleSummarySettleList(settleSummarySettle);
    }

    /**
     * 新增汇总单与进度单关系
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 结果
     */
    @Override
    public int insertSettleSummarySettle(SettleSummarySettle settleSummarySettle) {
        settleSummarySettle.setCreateTime(DateUtils.getNowDate());
        return settleSummarySettleMapper.insertSettleSummarySettle(settleSummarySettle);
    }

    /**
     * 修改汇总单与进度单关系
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 结果
     */
    @Override
    public int updateSettleSummarySettle(SettleSummarySettle settleSummarySettle) {
        settleSummarySettle.setUpdateTime(DateUtils.getNowDate());
        return settleSummarySettleMapper.updateSettleSummarySettle(settleSummarySettle);
    }

    /**
     * 批量删除汇总单与进度单关系
     *
     * @param ids 需要删除的汇总单与进度单关系主键
     * @return 结果
     */
    @Override
    public int deleteSettleSummarySettleByIds(Long[] ids) {
        return settleSummarySettleMapper.deleteSettleSummarySettleByIds(ids);
    }

    /**
     * 删除汇总单与进度单关系信息
     *
     * @param id 汇总单与进度单关系主键
     * @return 结果
     */
    @Override
    public int deleteSettleSummarySettleById(Long id) {
        return settleSummarySettleMapper.deleteSettleSummarySettleById(id);
    }
}
