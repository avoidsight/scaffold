package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.SettleInventory;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.param.SettleAddParam;
import com.ruoyi.business.domain.param.SettleParam;
import com.ruoyi.business.domain.vo.SettleListVo;
import com.ruoyi.business.domain.vo.SettleSummaryVo;
import com.ruoyi.business.domain.vo.SettleVo;
import com.ruoyi.business.domain.vo.SettleWeight;
import com.ruoyi.business.mapper.InventoryMapper;
import com.ruoyi.business.mapper.SettleMapper;
import com.ruoyi.business.service.ISettleService;
import com.ruoyi.common.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SettleServiceImpl implements ISettleService {
    @Autowired
    private SettleMapper settleMapper;

    @Autowired
    private InventoryMapper inventoryMapper;


    @Override
    public List<SettleListVo> list(SettleParam param) {
        return settleMapper.list(param);
    }

    @Override
    public List<SettleSummaryVo> summary(SettleParam param) {
        // 计算期初之前的记录
        SettleSummaryVo before = settleMapper.getBeforeSummary(param);
        // 如果之前记录不存在, 默认为0
        BigDecimal beforeCount = new BigDecimal("0");
        if(!Objects.isNull(before)){
            // 如果记录存在, 则计算第一期的期初 = 之前记录总入库 - 总出库
            beforeCount = before.getInTotal().subtract(before.getOutTotal());
        }
        List<SettleSummaryVo> summary = settleMapper.summary(param);
        for (SettleSummaryVo settleSummaryVo : summary) {
            // 期初
            settleSummaryVo.setBeginTotal(beforeCount);
            // 本期期末, 下期期初
            beforeCount =beforeCount.add(settleSummaryVo.getInTotal()).subtract(settleSummaryVo.getOutTotal());
            settleSummaryVo.setEndTotal(beforeCount);
        }
        return summary;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSettle(SettleAddParam param) {
        // 计算这些出入库单的重量数据
        if(param.getInventoryIds().length == 0) {
            return 0;
        }
        Settle settle = inventoryMapper.selectSettle(param.getInventoryIds());
        BeanUtils.copyProperties(param, settle);
        // 默认未结算
        settle.setStatus(0L);
        settle.create();
        int row = settleMapper.insertSettle(settle);
        // 保存关联关系
        insertSettleInventory(settle.getId(), Arrays.asList(param.getInventoryIds()));
        return row;
    }

    private void insertSettleInventory(Long settleId, List<Long> inventoryIds) {
        if(CollectionUtils.isEmpty(inventoryIds)){
            throw new ServiceException("未关联出入库单");
        }
        List<SettleInventory> settleInventoryList = inventoryIds.stream().map(inventoryId -> {
            SettleInventory settleInventory = new SettleInventory();
            settleInventory.setSettleId(settleId);
            settleInventory.setInventoryId(inventoryId);
            settleInventory.create();
            return settleInventory;
        }).collect(Collectors.toList());
        settleMapper.batchSettleInventory(settleInventoryList);
    }

    @Override
    public SettleWeight selectSettleWeight(InventoryParam param) {
        return settleMapper.selectSettleWeight(param);
    }

    /**
     * 修改进度对账单
     *
     * @param settle 进度对账单
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateSettle(Settle settle) {
        settle.update();
        settleMapper.deleteSettleInventoryBySettleId(settle.getId());
        if(!CollectionUtils.isEmpty(settle.getSettleInventoryList())){
            insertSettleInventory(settle.getId(), settle.getSettleInventoryList().stream().map(SettleInventory::getInventoryId).collect(Collectors.toList()));
        }
        return settleMapper.updateSettle(settle);
    }

    /**
     * 批量删除进度对账单
     *
     * @param ids 需要删除的进度对账单主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteSettleByIds(Long[] ids) {
        settleMapper.deleteSettleInventoryBySettleIds(ids);
        return settleMapper.deleteSettleByIds(ids);
    }

    /**
     * 删除进度对账单信息
     *
     * @param id 进度对账单主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteSettleById(Long id) {
        settleMapper.deleteSettleInventoryBySettleId(id);
        return settleMapper.deleteSettleById(id);
    }

    @Override
    public SettleVo selectSettleById(Long id) {
        return settleMapper.selectSettleById(id);
    }

}
