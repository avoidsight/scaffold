package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.SettleInventory;
import com.ruoyi.business.domain.SettleSummary;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.param.SettleParam;
import com.ruoyi.business.domain.vo.SettleListVo;
import com.ruoyi.business.domain.vo.SettleSummaryVo;
import com.ruoyi.business.domain.vo.SettleVo;
import com.ruoyi.business.domain.vo.SettleWeight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SettleMapper {
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
     * 获取开始时间之前的数据, 用于保存期初期末
     * @param param
     * @return
     */
    SettleSummaryVo getBeforeSummary(SettleParam param);

    /**
     * 新增进度对账单
     *
     * @param settle 进度对账单
     * @return 结果
     */
    int insertSettle(Settle settle);

    /**
     * 批量新增进度单出入库单关系
     *
     * @param settleInventoryList 进度单出入库单关系列表
     * @return 结果
     */
    int batchSettleInventory(List<SettleInventory> settleInventoryList);

    /**
     * 查询已结算和未结算的重量
     * @param param 参数
     * @return 结果
     */
    SettleWeight selectSettleWeight(InventoryParam param);

    /**
     * 查询进度对账单
     *
     * @param id 进度对账单主键
     * @return 进度对账单
     */
    SettleVo selectSettleById(Long id);

    /**
     * 通过进度对账单主键删除进度单出入库单关系信息
     *
     * @param id 进度对账单ID
     * @return 结果
     */
    int deleteSettleInventoryBySettleId(Long id);

    /**
     * 批量删除进度单出入库单关系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSettleInventoryBySettleIds(Long[] ids);

    /**
     * 删除进度对账单
     *
     * @param id 进度对账单主键
     * @return 结果
     */
    int deleteSettleById(Long id);

    /**
     * 批量删除进度对账单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSettleByIds(Long[] ids);

    /**
     * 修改进度对账单
     *
     * @param settle 进度对账单
     * @return 结果
     */
    int updateSettle(Settle settle);

    /**
     * 通过id更新进度对账单的状态
     * @param idList
     * @param status
     * @return
     */
    int updateStatusById(@Param("idList")List<Long> idList, @Param("status")Long status);
}
