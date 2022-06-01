package com.ruoyi.business.service.impl;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ruoyi.business.domain.SettleSummarySettle;
import com.ruoyi.business.domain.param.SettleSummaryAddParam;
import com.ruoyi.business.domain.param.SettleSummarySearchParam;
import com.ruoyi.business.domain.vo.*;
import com.ruoyi.business.mapper.SettleMapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.SettleSummaryMapper;
import com.ruoyi.business.domain.SettleSummary;
import com.ruoyi.business.service.ISettleSummaryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 进度对账单汇总Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Service
public class SettleSummaryServiceImpl implements ISettleSummaryService {
    @Autowired
    private SettleSummaryMapper settleSummaryMapper;

    /**
     * 查询进度对账单汇总
     *
     * @param id 进度对账单汇总主键
     * @return 进度对账单汇总
     */
    @Override
    public SettleSumVo selectSettleSummaryById(Long id) {
        //根据settleSummaryId获取settleId集合来获取汇总信息
        Long[] ids = settleSummaryMapper.getSettleIdsBySettleSummaryId(id).stream().toArray(Long[]::new);
        // 计算期初之前的记录
        SummaryVo before = settleSummaryMapper.getBeforeSummaryByIds(ids);
        // 如果之前记录不存在, 默认为0
        BigDecimal beforeCount = new BigDecimal("0");
        if(!Objects.isNull(before)){
            // 如果记录存在, 则计算第一期的期初 = 之前记录总入库 - 总出库
            beforeCount = before.getTheoreticalInTotal().subtract(before.getTheoreticalOutTotal());
        }
        List<SummaryVo> summary = settleSummaryMapper.summaryByIds(ids);
        for (SummaryVo summaryVo : summary) {
            // 期初
            summaryVo.setBeginTotal(beforeCount);
            // 本期期末, 下期期初
            beforeCount =beforeCount.add(summaryVo.getTheoreticalInTotal()).subtract(summaryVo.getTheoreticalOutTotal());
            summaryVo.setEndTotal(beforeCount);
        }
        SettleSumVo settleSumVo = settleSummaryMapper.getSettleSummaryBaseInfoByIds(ids,id);
        settleSumVo.setSummaryVoList(summary);
        return summary(ids);
    }

    /**
     * 查询进度对账单汇总列表
     *
     * @param param 进度对账单汇总
     * @return 进度对账单汇总列表
     */
    @Override
    public List<SeSummaryVo> selectSettleSummaryList(SettleSummarySearchParam param) {
        return settleSummaryMapper.selectSettleSummaryList(param);
    }

    /**
     * 新增进度对账单汇总
     *
     * @param param 进度对账单汇总参数
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSettleSummary(SettleSummaryAddParam param) {
        if(param.getSettleIds().length == 0) {
            return 0;
        }
        SettleSummary settleSummary = new SettleSummary();
        BeanUtils.copyProperties(param, settleSummary);
        settleSummary.create();
        int row = settleSummaryMapper.insertSettleSummary(settleSummary);
        // 保存关联关系
        insertSettleSummarySettle(settleSummary.getId(), Arrays.asList(param.getSettleIds()));
        return row;
    }

    private void insertSettleSummarySettle(Long settleSummaryId, List<Long> settleIds) {
        if(CollectionUtils.isEmpty(settleIds)){
            throw new ServiceException("未关联进度对账单");
        }
        List<SettleSummarySettle> settleSummarySettleList = settleIds.stream().map(settleId -> {
            SettleSummarySettle settleSummarySettle = new SettleSummarySettle();
            settleSummarySettle.setSettleSummaryId(settleSummaryId);
            settleSummarySettle.setSettleId(settleId);
            settleSummarySettle.create();
            return settleSummarySettle;
        }).collect(Collectors.toList());
        settleSummaryMapper.batchSettleInventory(settleSummarySettleList);
    }

    /**
     * 修改进度对账单汇总
     *
     * @param settleSummary 进度对账单汇总
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSettleSummary(SettleSummary settleSummary) {
        settleSummary.update();
        return settleSummaryMapper.updateSettleSummary(settleSummary);
    }

    /**
     * 批量删除进度对账单汇总
     *
     * @param ids 需要删除的进度对账单汇总主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteSettleSummaryByIds(Long[] ids) {
        settleSummaryMapper.deleteSettleSummarySettle(ids);
        return settleSummaryMapper.deleteSettleSummaryByIds(ids);
    }

    /**
     * 删除进度对账单汇总信息
     *
     * @param id 进度对账单汇总主键
     * @return 结果
     */
    @Override
    public int deleteSettleSummaryById(Long id) {
        return settleSummaryMapper.deleteSettleSummaryById(id);
    }

    /**
     * 进度对账单汇总
     *
     * @param ids 参数
     * @return
     */
    @Override
    public SettleSumVo summary(Long[] ids) {
        // 计算期初之前的记录
        SummaryVo before = settleSummaryMapper.getBeforeSummaryByIds(ids);
        // 如果之前记录不存在, 默认为0
        BigDecimal beforeCount = new BigDecimal("0");
        if(!Objects.isNull(before)){
            // 如果记录存在, 则计算第一期的期初 = 之前记录总入库 - 总出库
            beforeCount = before.getTheoreticalInTotal().subtract(before.getTheoreticalOutTotal());
        }
        List<SummaryVo> summary = settleSummaryMapper.summaryByIds(ids);
        for (SummaryVo summaryVo : summary) {
            // 期初
            summaryVo.setBeginTotal(beforeCount);
            // 本期期末, 下期期初
            beforeCount =beforeCount.add(summaryVo.getTheoreticalInTotal()).subtract(summaryVo.getTheoreticalOutTotal());
            summaryVo.setEndTotal(beforeCount);
        }
        SettleSumVo settleSumVo = settleSummaryMapper.getSettleSummaryBaseInfoByIds(ids,null);
        settleSumVo.setSummaryVoList(summary);
        return settleSumVo;
    }

    /**
     * 获取进度对账单明细全部信息
     *
     * @param id 进度对账单主键id
     * @return 进度对账单明细全部信息
     */
    @Override
    public SettleDetailVo getSettleDetail(Long id) {
        Long[] ids = new Long[]{id};
        SettleDetailVo settleDetailVo = new SettleDetailVo();
        //获取明细头部基本信息
        SettleSumVo info = settleSummaryMapper.getSettleSummaryBaseInfoByIds(ids,null);
        //获取对账期新增供货量信息
        SummaryDetailVo addList = settleSummaryMapper.getSettleDetailList(id,0);
        //获取对账期内退场量信息
        SummaryDetailVo offList = settleSummaryMapper.getSettleDetailList(id,1);
        //获取其他费用信息
        List<SummaryDetailListVo>  otherFeeList = settleSummaryMapper.getOtherFeeById(id);
        settleDetailVo.setSettleBaseInfo(info);
        settleDetailVo.setAddList(addList);
        settleDetailVo.setOffList(offList);
        settleDetailVo.setOtherFeeList(otherFeeList);
        return settleDetailVo;
    }
}
