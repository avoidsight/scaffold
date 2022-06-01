package com.ruoyi.business.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.SettlementDetail;
import com.ruoyi.business.domain.param.BillingAccountParam;
import com.ruoyi.business.domain.vo.*;
import com.ruoyi.business.mapper.InventoryMapper;
import com.ruoyi.business.mapper.SettleMapper;
import com.ruoyi.business.mapper.SettlementDetailMapper;
import com.ruoyi.business.service.ISettleService;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.SettlementMapper;
import com.ruoyi.business.domain.Settlement;
import com.ruoyi.business.service.ISettlementService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * 结算Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Service
public class SettlementServiceImpl implements ISettlementService {
    @Autowired
    private SettlementMapper settlementMapper;

    @Autowired
    private SettleMapper settleMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private SettlementDetailMapper settlementDetailMapper;

    /**
     * 查询结算
     *
     * @param id 结算主键
     * @return 结算
     */
    @Override
    public Settlement selectSettlementById(Long id) {
        return settlementMapper.selectSettlementById(id);
    }

    /**
     * 查询结算列表
     *
     * @param billingAccountParam 结算
     * @return 结算
     */
    @Override
    public List<SettlementVo> selectSettlementList(BillingAccountParam billingAccountParam) {
        return settlementMapper.selectSettlementList(billingAccountParam);
    }

    /**
     * 新增结算
     *
     * @param settlement 结算
     * @return 结果
     */
    @Override
    @Transactional
    public int insertSettlement(LeaseSettlementVo settlement) {
        /*
        * 根据status判断进行的操作
        * 插入结算表和它的子表数据
        *
        * 创建
        * 1.更新settlement表中状态为未归档
        * 2.更新settle表中的status为已结算
        * 3.更新inventory表中的statistics_status为已归档
        *
        * 归档
        * 1.更新settlement表中状态为已归档
        * 2.更新settle表中的status为已归档
        * 3.更新inventory表中的statistics_status为已归档
        *
        * */
        //先获取一边进度单数据
        SettleVo settleVo =  settleMapper.selectSettleById(settlement.getChecklistHeaderVo().getSettleId());
        //获取前端传入的子表数据
        List<LeaseSettlementChecklistVo> leaseSettlementChecklistVos = settlement.getList();

        //出入库表id列表
        List<Long> ids = settlement.getList().stream().map(LeaseSettlementChecklistVo::getId).collect(Collectors.toList());
        Settlement entry = new Settlement();
        //先看有没有结算id
        if(settlement.getChecklistHeaderVo().getId() != null){
            entry = this.selectSettlementById(settlement.getChecklistHeaderVo().getId());
        }else{
            entry.setSettlementDate(DateUtils.getNowDate());
        }
        entry.setTotalWeight(settlement.getChecklistHeaderVo().getTotalWeight());
        entry.setTotalMoney(settlement.getChecklistHeaderVo().getTotalMoney());
        entry.setResources(settlement.getChecklistHeaderVo().getResources());
        entry.setContractId(settlement.getChecklistHeaderVo().getContractId());
        entry.setSettleId(settlement.getChecklistHeaderVo().getSettleId());
        entry.setStatus(settlement.getChecklistHeaderVo().getStatus());

        if(2L == entry.getStatus()){
            //附件判断
            if(StringUtils.isNotEmpty(entry.getResources())){
                List<String> resourcesList = inventoryMapper.selectResourcesById(ids);
                for (String resource : resourcesList) {
                    if(StringUtils.isEmpty(resource)){
                        throw new ServiceException("出入库表中未上传附件");
                    }
                }
            }else {
                throw new ServiceException("未上传附件");
            }


            //归档日期
            entry.setFileDate(DateUtils.getNowDate());
        }
        //判定新增还是更新
        if(ObjectUtils.isEmpty(entry.getId())){
            entry.setCreateBy(SecurityUtils.getLoginUser().getUsername());
            entry.setCreateTime(DateUtils.getNowDate());
            settlementMapper.insertSettlement(entry);
        }else{
            entry.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
            entry.setUpdateTime(DateUtils.getNowDate());
            settlementMapper.updateSettlement(entry);
            //先删除子表数据
            settlementDetailMapper.deleteSettlementDetailById(entry.getId());
        }
        //子表数据
        List<SettlementDetail> settlementDetailList = Lists.newArrayList();
        for (LeaseSettlementChecklistVo leaseSettlementChecklistVo : leaseSettlementChecklistVos) {
            SettlementDetail settlementDetail = new SettlementDetail();
            settlementDetail.setSettlementId(entry.getId());
            settlementDetail.setInventoryId(leaseSettlementChecklistVo.getId());
            settlementDetail.setRemark(leaseSettlementChecklistVo.getRemark());
            settlementDetailList.add(settlementDetail);
        }
        //新增子表数据
        settlementDetailMapper.batchSaveSettlementDetail(settlementDetailList);

        if(2L == entry.getStatus()){
            //归档
            //更新进度对账单
            settleVo.setStatus(2L);
            //更新出入库
            inventoryMapper.updateStatisticsStatusById(ids, 3L);
        } else {
            //保存
            //更新进度对账单
            settleVo.setStatus(1L);
            //更新出入库
            inventoryMapper.updateStatisticsStatusById(ids, 2L);
        }
        String copyR = JSON.toJSONString(settleVo);
        Settle settle = JSONObject.parseObject(copyR,Settle.class);

        return settleMapper.updateSettle(settle);
    }

    /**
     * 修改结算
     *
     * @param settlement 结算
     * @return 结果
     */
    @Override
    @Transactional
    public int updateSettlement(Settlement settlement) {
        settlement.setUpdateTime(DateUtils.getNowDate());

        return settlementMapper.updateSettlement(settlement);
    }

    /**
     * 批量删除结算
     *
     * @param ids 需要删除的结算主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteSettlementByIds(Long[] ids) {
        /**
         * 结算单中进度对账单状态为已结算
         * 出入库单中状态改为已结算
         */
        //获取结算对应的进度对账单数据
        List<Long> settleIds = settlementMapper.selectSettleId(ids);
        settleMapper.updateStatusById(settleIds,Long.valueOf(0));

        //获取结算单中对应的出入库表数据
        List<Long> inventoryIds = settlementDetailMapper.selectInventoryId(ids);
        inventoryMapper.updateStatisticsStatusById(inventoryIds,Long.valueOf(1));
        settlementDetailMapper.deleteSettlementDetailByIds(ids);
        return settlementMapper.deleteSettlementByIds(ids);
    }

    /**
     * 删除结算信息
     *
     * @param id 结算主键
     * @return 结果
     */
    @Override
    public int deleteSettlementById(Long id) {
        return settlementMapper.deleteSettlementById(id);
    }


    /**
     * 租赁结算清单查询结算列表
     * @param id 进度对账单id
     * @return
     */
    @Override
    public List<LeaseSettlementChecklistVo> listLeaseSettlement(Long id) {
        List<LeaseSettlementChecklistVo> leaseSettlementChecklistVos = settlementMapper.listLeaseSettlement(id);
        //处理总金额
        if(!ObjectUtils.isEmpty(leaseSettlementChecklistVos)){
            for (LeaseSettlementChecklistVo leaseSettlementChecklistVo : leaseSettlementChecklistVos) {
                leaseSettlementChecklistVo.setAllMoney(leaseSettlementChecklistVo.getTotalMoney().add(leaseSettlementChecklistVo.getOtherMoney()));
            }
        }
        return leaseSettlementChecklistVos;
    }

    /**
     * 租赁结算清单查询结算列表（编辑进入）
     * @param id 进度对账单id
     * @return
     */
    @Override
    public List<LeaseSettlementChecklistVo> listLeaseSettlementEdit(Long id) {
        List<LeaseSettlementChecklistVo> leaseSettlementChecklistVos = settlementMapper.listLeaseSettlementEdit(id);
        //处理总金额
        if(!ObjectUtils.isEmpty(leaseSettlementChecklistVos)){
            for (LeaseSettlementChecklistVo leaseSettlementChecklistVo : leaseSettlementChecklistVos) {
                leaseSettlementChecklistVo.setAllMoney(leaseSettlementChecklistVo.getTotalMoney().add(leaseSettlementChecklistVo.getOtherMoney()));
            }
        }
        return leaseSettlementChecklistVos;
    }

    @Override
    public LeaseSettlementChecklistHeaderVo getLeaseSettlementChecklistHeaderById(Long id) {
        return settlementMapper.getLeaseSettlementChecklistHeaderById(id);
    }
}
