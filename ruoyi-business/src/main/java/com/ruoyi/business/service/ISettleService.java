package com.ruoyi.business.service;

import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.param.SettleAddParam;
import com.ruoyi.business.domain.param.SettleParam;
import com.ruoyi.business.domain.vo.SettleListVo;
import com.ruoyi.business.domain.vo.SettleSummaryVo;
import com.ruoyi.business.domain.vo.SettleVo;
import com.ruoyi.business.domain.vo.SettleWeight;

import java.util.List;

public interface ISettleService {
    /**
     * 进度对账列表
     * @param param 参数
     * @return 进度对账列表
     */
    List<SettleListVo> list(SettleParam param);

    /**
     * 进度对账汇总
     * @param param 参数
     * @return 进度对账汇总列表
     */
    List<SettleSummaryVo> summary(SettleParam param);

    /**
     * 新增进度单
     * @param inventoryIds 出入库单id
     * @return 结果
     */
    int insertSettle(SettleAddParam param);

    /**
     * 查询已结算和未结算的重量
     * @param param 参数
     * @return 结果
     */
    SettleWeight selectSettleWeight(InventoryParam param);

    /**
     * 修改进度对账单
     *
     * @param settle 进度对账单
     * @return 结果
     */
    int updateSettle(Settle settle);

    /**
     * 批量删除进度对账单
     *
     * @param ids 需要删除的进度对账单主键集合
     * @return 结果
     */
    int deleteSettleByIds(Long[] ids);

    /**
     * 删除进度对账单信息
     *
     * @param id 进度对账单主键
     * @return 结果
     */
    int deleteSettleById(Long id);

    /**
     * 查询进度对账单
     *
     * @param id 进度对账单主键
     * @return 进度对账单
     */
    SettleVo selectSettleById(Long id);
}
